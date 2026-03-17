package com.example.loanEngine.dto;

public record LoanResponse(boolean approved, int amount, int period, String message) {}