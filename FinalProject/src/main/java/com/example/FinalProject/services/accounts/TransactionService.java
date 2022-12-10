package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.Transaction;
import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import com.example.FinalProject.repositories.users.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    public void doTransactionSendMoney(Long accountId, BigDecimal money, String hashKey) {

        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la cuenta con el id en el sitema"));

        String hashedKey = thirdPartyRepository.findByHashedKey(hashKey).get().getHashedKey();

        if (hashedKey.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This hashKey doesn't match with the system");
        }

        if (account.getBalance().compareTo(money) < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Esta cuenta no tiene balance suficiente");
        }

        //ThirdParty
        Transaction transaction = new Transaction();
        transaction.setAmount(money);
        account.setBalance(account.getBalance().add(money));
        accountRepository.save(account);
        transaction.setId(account.getAccountId());
        transaction.setDestinationAccount(account);

        transactionRepository.save(transaction);
    }

    public void doTransactionReceiveMoney(Long accountId, BigDecimal money, String hashKey) {

        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la cuenta con el id en el sitema"));

        String hashedKey = thirdPartyRepository.findByHashedKey(hashKey).get().getHashedKey();

        if (hashedKey.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This hashKey doesn't match with the system");
        }

        if (account.getBalance().compareTo(money) < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Esta cuenta no tiene balance suficiente");
        }

        if (account instanceof Checking) {
            ((Checking) account).penalthyFeeApply();
        } else if (account instanceof SavingAccount) {
            ((SavingAccount) account).penalthyFeeApply();
        }

        //ThirdParty
        Transaction transaction = new Transaction();
        account.setBalance(account.getBalance().subtract(money));
        accountRepository.save(account);
        transaction.setAmount(money);
        transaction.setId(account.getAccountId());
        transactionRepository.save(transaction);
    }

    public void doTransactionAccountHolder(Long accountId, Long accountDestination, BigDecimal money, String hashKey) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la cuenta con el id en el sitema"));
        Account accountD= accountRepository.findById( accountDestination).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la cuenta destino con el id en el sitema"));
        String hashedKey = thirdPartyRepository.findByHashedKey(hashKey).get().getHashedKey();

        if (hashedKey.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This hashKey doesn't match with the system");
        }

        if (account.getBalance().compareTo(money) < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Esta cuenta no tiene balance suficiente");
        }

        if (account instanceof Checking) {
            ((Checking) account).penalthyFeeApply();
        } else if (account instanceof SavingAccount) {
            ((SavingAccount) account).penalthyFeeApply();
        }


        Transaction transaction = new Transaction();
        //factorizamos account1
        //restamos la cantidad de dinero a la cuenta
        account.setBalance(account.getBalance().subtract(money));
        accountRepository.save(account);

        //se la incrementamos al destinatario
        accountD.setBalance(accountD.getBalance().add(money));
        accountRepository.save(accountD);

        transaction.setAmount(money);
        transaction.setSenderAccount(account);
        transaction.setDestinationAccount(accountD);
        transactionRepository.save(transaction);

    }
}
