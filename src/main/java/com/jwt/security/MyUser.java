package com.jwt.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class MyUser implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		if(username.equals("pervez")){
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new GrantedAuthority() {
				
				@Override
				public String getAuthority() {
					// TODO Auto-generated method stub
					return "ROLE_USER";
				}
			};
			
			authorities.add(authority);
			
			User user = new User("pervez", "abc", authorities);
			return user;
		}
		
		return null;
	}

	
}