package com.example.FinalProject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO {
    private Long idSender;
    private Long idDestination;
    private BigDecimal amount;
}
