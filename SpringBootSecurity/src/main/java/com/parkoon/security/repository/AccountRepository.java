package com.parkoon.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkoon.security.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUserId(String userid);

}
