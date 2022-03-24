package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.model.entity.UserEntity;
import com.mx.api.parrot.challenger.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity usuario = userRepository.findByUsername(username);

		if (Objects.isNull(usuario)) {
			log.error("User no exist");
			throw new UsernameNotFoundException("User no exist");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);

	}
}
