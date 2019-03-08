package com.infosys.Account.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.Account.DTO.AccountDTO;
import com.infosys.Account.DTO.LoginDTO;
import com.infosys.Account.Service.AccountService;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class AccountController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccountService acctService;
	
	@RequestMapping(value = "/account", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody AccountDTO acctDTO) {
		logger.info("Creation request for customer {}", acctDTO);
		acctService.createAccount(acctDTO);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		boolean x = acctService.login(loginDTO);
		System.out.println(x);
		return x;
	}
	
	@RequestMapping(value = "/account/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO getCustomerProfile(@PathVariable String email) {
		logger.info("Profile request for customer {}", email);
		return acctService.getCustomerProfile(email);
	}
}
