package com.example.FinalProject;

import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.models.users.Role;
import com.example.FinalProject.models.users.ThirdParty;
import com.example.FinalProject.repositories.accounts.*;
import com.example.FinalProject.repositories.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

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
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 8);


		ThirdParty user = thirdPartyRepository.save(new ThirdParty("BBVA",passwordEncoder.encode("123456"),"456"));
		AccountHolder accountHolder= accountHolderRepository.save(new AccountHolder( "Cristian",passwordEncoder.encode("abcd"), LocalDate.of(1994,12,1), new Address("Jaume Coll",8100,"Mollet","España")));
		Admin admin = adminRepository.save (new Admin("Kiko",passwordEncoder.encode("11456"),"kikoman"));

		Role role = new Role("THIRD_PARTY",user);
		roleRepository.save(role);

		Role role1 = new Role("ACCOUNT_HOLDER",accountHolder);
		roleRepository.save(role1);

		Role role2 = new Role("ADMIN",admin);
		roleRepository.save(role2);


	}
}
