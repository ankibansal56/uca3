package com.infosys.Account.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.Account.DTO.AccountDTO;
import com.infosys.Account.DTO.LoginDTO;
import com.infosys.Account.Entity.Account;
import com.infosys.Account.Repository.AccountRepository;

@Service
public class AccountService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccountRepository acctRepo;
	
	public void createAccount(AccountDTO acctDTO) {
		logger.info("Creation request for customer {}", acctDTO);
		Account acctEntity = acctDTO.createEntity();
		acctRepo.save(acctEntity);
	}
	
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		Account acct = acctRepo.findByEmail(loginDTO.getEmail());
		if(loginDTO.getPassword().equals(acct.getPassword()))
			return true;
		return false;
		
	}
	
	public AccountDTO getCustomerProfile(String email) {
		logger.info("Profile request for customer {}", email);
		Account acct = acctRepo.findByEmail(email);
		AccountDTO acctDTO = AccountDTO.valueOf(acct);
		logger.info("Profile for customer : {}", acctDTO);
		return acctDTO;
	}
}
