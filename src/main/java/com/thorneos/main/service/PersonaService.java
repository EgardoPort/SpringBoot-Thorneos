package com.thorneos.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thorneos.main.entities.Persona;
import com.thorneos.main.repository.IPersonaRepository;

@Service
@Transactional
public class PersonaService implements UserDetailsService{
	
	@Autowired
	IPersonaRepository iPersona;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Persona per = iPersona.findByUsuario(usuario);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("Administrador"));
		roles.add(new SimpleGrantedAuthority("encargado"));
		
		UserDetails userDet = new User(per.getUsuario(), per.getClave(), roles);
		
		return userDet;
	}

}
