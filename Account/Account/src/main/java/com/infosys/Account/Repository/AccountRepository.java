package com.infosys.Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.Account.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	Account findByEmail(String email);
}
