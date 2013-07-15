package com.adrianmoya.specbddsample.java.builders;

import com.adrianmoya.specbddsample.java.Account;
import com.adrianmoya.specbddsample.java.AlertListener;

public class AccountBuilder {

    int balance;
    String holder;
    AlertListener alerts;

    public AccountBuilder() {
        this.balance = 0;
        this.holder = "Account Holder";
    }
    
    public AccountBuilder withBalance(int balance){
        this.balance = balance;
        return this;
    }
    
    public AccountBuilder withHolderName(String name){
        this.holder = name;
        return this;
    }
    
    public AccountBuilder withAlerts(AlertListener alerts){
        this.alerts = alerts;
        return this;
    }
    
    public static AccountBuilder anAccount(){
        return new AccountBuilder();
    }
    
    public Account build(){
        return new Account(this.holder, this.balance, this.alerts);
    }
}
