package com.example.FinalProject;

import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.models.users.ThirdParty;
import com.example.FinalProject.models.users.User;
import com.example.FinalProject.repositories.accounts.*;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.AdminRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {
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
	@Autowired
	SavingAccountRepository savingAccountRepository;
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 8);

		ThirdParty user = thirdPartyRepository.save(new ThirdParty("BBVA","1111","456"));
		AccountHolder accountHolder= accountHolderRepository.save(new AccountHolder( "Cristian","1234", LocalDate.of(1994,12,1), new Address("Jaume Coll",8100,"Mollet","España")));
		Admin admin = adminRepository.save (new Admin("Kiko","11112","kikoman"));
	}
}
