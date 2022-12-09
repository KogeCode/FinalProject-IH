package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.services.accounts.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransferService transferService;

    @PutMapping("/send/accountId/{accountId}/money/{money}/hashKey/{hashKey}")
    public void doTransactionSendMoney (@PathVariable("accountId") Long accountId,
                                      @PathVariable("money") BigDecimal money,
                                      @PathVariable("hashKey") String hashKey) {
        transferService.doTransactionSendMoney(accountId, money,hashKey);
    }

    @PutMapping("/Receive/accountId/{accountId}/money/{money}/hashKey/{hashKey}")
    public void doTransactionReceiveMoney (@PathVariable("accountId") Long accountId,
                                        @PathVariable("money") BigDecimal money,
                                        @PathVariable("hashKey") String hashKey) {
        transferService.doTransactionReceiveMoney(accountId, money,hashKey);
    }

    @PutMapping("/Receive/accountId/{accountId}/accountDestination/{accountDestination}/money/{money}/hashKey/{hashKey}")
    public void doTransactionReceiveMoneyAccountHolder (@PathVariable("accountId") Long accountId,
                                                        @PathVariable("accountDestination") Long accountDestination,
                                           @PathVariable("money") BigDecimal money,
                                           @PathVariable("hashKey") String hashKey) {
        transferService.doTransactionAccountHolder(accountId, accountDestination, money,hashKey);
    }

}
