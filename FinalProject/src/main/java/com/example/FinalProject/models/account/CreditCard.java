package com.example.FinalProject.models.account;

import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CreditCard extends Account {

    private BigDecimal creditCardLimit;
    private Double interestRate;

    private LocalDate lastApplyInterest = LocalDate.now();

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secundaryOwner, BigDecimal creditCardLimit, Double interestRate, LocalDate lastApplyInterest) {
        super(balance, primaryOwner, secundaryOwner);
        this.creditCardLimit = creditCardLimit;
        this.interestRate = interestRate;
        this.lastApplyInterest = lastApplyInterest;
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, BigDecimal creditCardLimit, Double interestRate, LocalDate lastApplyInterest) {
        super(balance, primaryOwner);
        this.creditCardLimit = creditCardLimit;
        this.interestRate = interestRate;
        this.lastApplyInterest = lastApplyInterest;
    }

    public BigDecimal getCreditCardLimit() {
        return creditCardLimit;
    }

    public LocalDate getLastApplyInterest() {
        return lastApplyInterest;
    }

    public void setLastApplyInterest(LocalDate lastApplyInterest) {
        this.lastApplyInterest = lastApplyInterest;
    }

    public void setCreditCardLimit(BigDecimal creditCardLimit) {

        BigDecimal defaultValor = BigDecimal.valueOf(100.00);
        BigDecimal maxValor = BigDecimal.valueOf(100000.00);

        if (creditCardLimit == null) { //si es nulo me settea el creditCardLimit en 100.00
            this.creditCardLimit = defaultValor;

        } else if (creditCardLimit.compareTo(defaultValor)<0) { //si es menor me settea el creditCardLimit en 100.00
            this.creditCardLimit = defaultValor;

        } else if (creditCardLimit.compareTo(maxValor)>0) { // si es mayor al creditCardLimit (100000) se settea a 100000
            this.creditCardLimit = maxValor;

        } else {
            this.creditCardLimit=creditCardLimit;
        }
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        double defaultRate = 0.2;
        double minRate = 0.1;
        if(interestRate==null){
            this.interestRate=defaultRate;
        } else if (interestRate<minRate) {
            this.interestRate=defaultRate;
        }else{
            this.interestRate=interestRate;
        }


    }

    //M??todo por el cual se aplica el inter??s a la CreditCard de forma mensual cada vez que se chequea el balance de la CreditCard y se comprueba que ha pasado un mes desde que se aplic?? por ??ltima vez el inter??s, dicha aplicaci??n se efect??a de tal forma:  inter??s anual = 12%  => se aplica un 1% cada mes  (12% inter??s / 12 meses = 1%/mes)

    public void applyInterestCreditCard() {
        if (Period.between(lastApplyInterest, LocalDate.now()).getMonths() > 1) {
            super.setBalance(super.getBalance().add(super.getBalance().multiply(BigDecimal.valueOf(interestRate/12))
                    .multiply(BigDecimal.valueOf((Period.between(lastApplyInterest, LocalDate.now()).getMonths())))));
            //Actualizamos el lastInterest a fecha actual sin perder los a??os
            lastApplyInterest.plusMonths(Period.between(lastApplyInterest, LocalDate.now()).getMonths());
        }
    }

}
