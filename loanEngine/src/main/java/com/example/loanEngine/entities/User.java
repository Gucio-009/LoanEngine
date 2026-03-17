package com.example.loanEngine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


//I do not know why @Data isn't working, so I provided functions manually
@Entity
@Table(name = "users")
public class User {
    @Id
    private String personalCode;
    private int creditModifier;
    private boolean hasDebt;

    public boolean isHasDebt() {
        return hasDebt;
    }

    public int getCreditModifier() {
        return creditModifier;
    }

}


