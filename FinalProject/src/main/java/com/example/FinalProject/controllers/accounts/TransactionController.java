package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.services.accounts.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/send/account-id/{accountId}/money/{money}/hashkey/{hashKey}")
    public void doTransactionSendMoney (@PathVariable("accountId") Long accountId,
                                        @PathVariable("money") BigDecimal money,
                                        @RequestHeader("hashKey") String hashKey) {
        transactionService.doTransactionSendMoney(accountId, money,hashKey);
    }

    @PutMapping("/receive/account-id/{accountId}/money/{money}")
    public void doTransactionReceiveMoney (@PathVariable("accountId") Long accountId,
                                        @PathVariable("money") BigDecimal money,
                                        @RequestHeader("hashKey") String hashKey) {
        transactionService.doTransactionReceiveMoney(accountId, money,hashKey);
    }

    @PutMapping("/receive/account-id/{accountId}/account-destination/{accountDestination}/money/{money}")
    public void doTransactionAccountHolder (@PathVariable("accountId") Long accountId,
                                           @PathVariable("accountDestination") Long accountDestination,
                                           @PathVariable("money") BigDecimal money,
                                           @RequestHeader("hashKey") String hashKey) {
        transactionService.doTransactionAccountHolder(accountId, accountDestination, money,hashKey);
    }

}
