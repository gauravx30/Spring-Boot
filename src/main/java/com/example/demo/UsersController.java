package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private userJpaRespository userJpaRespository;
	
	@RequestMapping("/add")
	public String add()
	{
		return "add";
	}

	@RequestMapping("/addaction")
	public String addaction(Users users)
	{
	userJpaRespository.save(users);
	return "add";
	}

	@GetMapping(value ="/all")
	@ResponseBody
	public List<Users> findAll()
	{
		return userJpaRespository.findAll();
	}
	
	@GetMapping(value= "/{name}")
	@ResponseBody
	public Users findByName(@PathVariable final String name)
	{
		return userJpaRespository.findByName(name);
	}
	
	@PostMapping(value= "/{load}")
	@ResponseBody
	public Users load(@RequestBody final Users users)
	{
		userJpaRespository.save(users);
		return userJpaRespository.findByName(users.getName());
	}
	
	
}
