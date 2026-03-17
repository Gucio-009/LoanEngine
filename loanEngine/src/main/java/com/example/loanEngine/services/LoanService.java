package com.example.loanEngine.services;

import com.example.loanEngine.dto.LoanRequest;
import com.example.loanEngine.dto.LoanResponse;
import com.example.loanEngine.entities.User;
import com.example.loanEngine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired private UserRepository userRepository;

    public LoanResponse calculate(LoanRequest req) {
        User user = userRepository.findById(req.personalCode()).orElse(null);

        if (user == null) {
            return new LoanResponse(false, 0, req.period(), "user doesn't exist");
        }

        if (user.isHasDebt()) {
            return new LoanResponse(false, 0, req.period(), "you have debt already");
        }

        int modifier = user.getCreditModifier();

        int maxPossibleAmount = modifier * req.period();

        if (maxPossibleAmount >= 2000) {
            int approvedAmount = Math.min(maxPossibleAmount, 10000);
            return new LoanResponse(true, approvedAmount, req.period(), "proposition");
        }

        for (int p = 12; p <= 60; p++) {
            if (modifier * p >= 2000) {
                int approvedAmount = Math.min(modifier * p, 10000);
                return new LoanResponse(true, approvedAmount, p, "proposition");
            }
        }

        return new LoanResponse(false, 0, req.period(), "Lack of capacity even at maximum period");
    }
}
