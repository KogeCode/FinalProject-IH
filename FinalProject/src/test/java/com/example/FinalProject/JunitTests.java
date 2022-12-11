package com.example.FinalProject;

import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.repositories.accounts.*;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.AdminRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JunitTests {
//Repositorios de users
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AccountHolderRepository accountHolderRepository;

//Repositorios de accountsº


	@Autowired
	CheckingRepository checkingRepository;

	@Autowired
	SavingAccountRepository savingAccountRepository;

	AccountHolder accountHolder1;
	AccountHolder accountHolder2;
	Admin admin1;

	Checking checking1;
	Checking checking2;
	Checking checking3;
	SavingAccount savingAccount1;



	@BeforeEach
	void setUp() {

		accountHolder1 = accountHolderRepository.save(new AccountHolder("Cristian", "1234", LocalDate.of(1994,12,28), new Address("C/Jaume Coll",8100,"Mollet del Vallès","España")));

		accountHolder2 =accountHolderRepository.save(new AccountHolder("Raul Guapo", "1234", LocalDate.of(1994,12,28), new Address("C/Maricon no lo oculto",8100,"Mollet del Vallès","España")));

		admin1= adminRepository.save (new Admin("Cristian","12345","Koge"));

		checking1 = checkingRepository.save(new Checking(BigDecimal.valueOf(1000.00),accountHolder1, "Srritor",BigDecimal.valueOf(260)));
		checking2 = checkingRepository.save(new Checking(BigDecimal.valueOf(1000.00),accountHolder2, "4444",BigDecimal.valueOf(260)));
		checking3 = checkingRepository.save(new Checking(BigDecimal.valueOf(1000.00),accountHolder1,accountHolder2, "1212",BigDecimal.valueOf(240)));


		savingAccount1 = savingAccountRepository.save(new SavingAccount(BigDecimal.valueOf(30000),accountHolder1,12.0,"1111",BigDecimal.valueOf(270)));
	}
	@AfterEach
	void tearDown (){
		checkingRepository.deleteAll();
		savingAccountRepository.deleteAll();
		adminRepository.deleteAll();
		accountHolderRepository.deleteAll();
	}
	@Test
	void contextLoads() {
	}
	@Test
	void shouldCreateAnAdmin(){
		assertEquals(1, adminRepository.findAll().size());
	}
	@Test
	void shouldCreateATwoAccountHolders(){
		assertEquals(2, accountHolderRepository.findAll().size());
	}
	@Test
	void shouldCreateATwoChekingAccounts(){
		assertEquals(3,accountHolderRepository.findAll().size());

	}
	@Test
	void shouldCreateASavingAccount(){
		assertEquals(1, savingAccountRepository.findAll().size());
		assertEquals("1111", savingAccountRepository.findById(savingAccount1.getAccountId()).get().getSecretKey());
	}
}
