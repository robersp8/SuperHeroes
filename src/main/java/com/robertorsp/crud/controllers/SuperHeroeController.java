package com.robertorsp.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robertorsp.crud.entities.SuperHeroe;
import com.robertorsp.crud.repositories.SuperHeroeRepository;

@Controller
public class SuperHeroeController {

	private final SuperHeroeRepository superheroeRepository;

	@Autowired
	public SuperHeroeController(SuperHeroeRepository superheroeRepository) {
		this.superheroeRepository = superheroeRepository;
	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("users", superheroeRepository.findAll());
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(SuperHeroe superheroe) {
		return "add-superheroe";
	}

	@PostMapping("/addsuperheroe")
	public String addUser(@Valid SuperHeroe superheroe, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-superheroe";
		}

		superheroeRepository.save(superheroe);
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		SuperHeroe superheroe = superheroeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid superheroe Id:" + id));
		model.addAttribute("superheroe", superheroe);

		return "update-superheroe";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid SuperHeroe superheroe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			superheroe.setId(id);
			return "update-superheroe";
		}

		superheroeRepository.save(superheroe);

		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		SuperHeroe superheroe = superheroeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid superheroe Id:" + id));
		superheroeRepository.delete(superheroe);

		return "redirect:/index";
	}
}
