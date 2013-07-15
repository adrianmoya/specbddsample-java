package com.adrianmoya.specbddsample.java;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static com.adrianmoya.specbddsample.java.builders.AccountBuilder.*;
import org.junit.Before;

public class AccountSpec {
    
    private Account account;
    private AlertListener alerts;
    
    @Before
    public void setup(){
        this.alerts = mock(AlertListener.class);
    }
    
    @Test
    public void it_should_decrease_balance_when_a_debit_is_made(){
        //Given
        this.account = anAccount()
                .withBalance(200)
                .build();
        
        //When
        this.account.debit(50);
        
        //Then
        assertThat(accountBalance(), is(150));
    }
    
    @Test
    public void it_should_increase_balance_when_a_credit_is_made(){
        //Given
        this.account = anAccount()
                .withBalance(100)
                .build();
        
        //When
        this.account.credit(50);
        
        //Then
        assertThat(accountBalance(), is(150));
    }    
    
    @Test
    public void it_should_alert_account_holder_when_balance_is_below_100(){
        //Given
        this.account = anAccount()
                .withHolderName("Adrian")
                .withBalance(150)
                .withAlerts(this.alerts)
                .build();
        
        //When
        this.account.debit(90);
        
        //Then
        verify(alerts).sendAlert("Adrian, your account balance is below 100");
    }    
    
    //Helpers
    
    private int accountBalance(){
        return this.account.getBalance();
    }
    
}