package com.raneez.truewallet.data;

/**
 * Created by raneezahmed on 17/08/17.
 */

public class Expense {

    String id;
    String description;
    double amount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
