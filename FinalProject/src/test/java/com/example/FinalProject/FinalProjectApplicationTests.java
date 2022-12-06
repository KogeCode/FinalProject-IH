package com.example.FinalProject;

import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.accounts.CheckingRepository;
import com.example.FinalProject.repositories.accounts.CreditCardRepository;
import com.example.FinalProject.repositories.accounts.StudentCheckingRepository;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.AdminRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalProjectApplicationTests {
//Repositorios de users
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AccountHolderRepository accountHolderRepository;
	@Autowired
	ThirdPartyRepository thirdPartyRepository;

//Repositorios de accountsº

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	CreditCardRepository creditCardRepository;
	@Autowired
	StudentCheckingRepository studentCheckingRepository;


	@Test
	void contextLoads() {
	}

}
