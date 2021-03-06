package com.dipinho.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipinho.userdept.entities.User;
import com.dipinho.userdept.repositories.UserRepository;


@RestController		// Pra dizer que essa classe é um controlador REST
@RequestMapping	(value = "/users")	// Pra falar qual caminho esse controlador vau responder
public class UserController {
	
	@Autowired		//
	private UserRepository repository;
	
	
	@GetMapping		
	public List<User> findAll(){		// findALL vai no BD e buscar todos os usuarios
		List<User>result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")		
	public User findById(@PathVariable Long id){	
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping		// endpoint pra salvar o usuario
	public User insert(@RequestBody User user){	
		User result = repository.save(user); // vai enviar pro bd o insert e vai retornar uma nova referencia
		return result;
	}
}
