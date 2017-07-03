package com.parkoon.security.what;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parkoon.security.domain.Account;
import com.parkoon.security.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Account account = accountRepository.findByUserId(userid);
		
		if (account == null) {
			throw new UsernameNotFoundException(userid);
		}
		return new UserDetailsImpl(account);
	}

}
