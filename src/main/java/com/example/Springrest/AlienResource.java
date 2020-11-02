package com.example.Springrest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource 
{
	
	AlienRepository repo = new AlienRepository();
	
	@RequestMapping("getAliens")
	public List<Alien> getAliens()
	{
		System.out.println("getAliens called...");
		
		return repo.getAliens();
	}
	
/*	
	@RequestMapping("aliens/alien/{id}")
	public Alien getAlien(int id)
	{
		System.out.println("getAlien called...");
		
		return repo.getAlien(id);
	}	
*/
	
	@PostMapping("create")
	public Alien createAlien()
	{
		int a = 100;
		String b = "Lucy";
		int c = 60;
		Alien a1 = new Alien(a,b,c);
		System.out.println("createAlien called...");
		repo.create(a1);
		return a1;	
	}
	
	
	@PutMapping("update")
	public Alien updateAlien()
	{
		int a = 108;
		String b = "Akash";
		int c = 55;
		Alien a1 = new Alien(a,b,c);
		System.out.println("UpdateAlien called..!");
		
		repo.update(a1);
		
		return a1;
	}


	@DeleteMapping("delete")
	public void deleteAlien()
	{
		int id = 100;
		System.out.println("Delete Alien called..!");
		
		repo.delete(id);
		
	}
	


}
