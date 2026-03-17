package com.example.loanEngine.contollers;

import com.example.loanEngine.dto.LoanRequest;
import com.example.loanEngine.dto.LoanResponse;
import com.example.loanEngine.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "http://localhost:3000")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/check")
    public LoanResponse check(@RequestBody LoanRequest request) {
        return loanService.calculate(request);
    }
}
