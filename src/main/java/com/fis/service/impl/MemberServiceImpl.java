package com.fis.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fis.dao.MemberDao;
import com.fis.model.Member;
import com.fis.service.MemberService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class MemberServiceImpl implements UserDetailsService, MemberService {
	
	@Autowired
	private MemberDao userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Member user = userDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Member> findAll() {
		List<Member> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
    public Member save(Member user) {
        return userDao.save(user);
    }
}