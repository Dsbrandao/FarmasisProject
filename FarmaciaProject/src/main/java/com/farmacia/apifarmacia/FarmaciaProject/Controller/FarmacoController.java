package com.farmacia.apifarmacia.FarmaciaProject.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.farmacia.apifarmacia.FarmaciaProject.entidies.Farmaco;
import com.farmacia.apifarmacia.FarmaciaProject.repository.Farmacorepository;

@Controller
public class FarmacoController {
	
	@Autowired
	Farmacorepository farmacorepository;
	
	@GetMapping("/inicio")
	public String showFuncionarioForm(Farmaco farmaco) {
		return "add-farmaco";
	}
	
	@PostMapping("/addfarmaco")
	public String addFarmaco(@Valid Farmaco farmaco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-farmaco";
		}
		
		farmacorepository.save(farmaco);
		return "redirect:/index2";
	}
	@GetMapping("/index2")
	public String showFarmacoList(Model model) {
		model.addAttribute("farmacos", farmacorepository.findAll());
		return "/index2";
	}
	
	@GetMapping("/editar/{id}")
	public String showFarmacoUpdate(@PathVariable("id") long id, Model model) {
		
		Farmaco farmaco = farmacorepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id do Farmaco invalido:" + id));
		model.addAttribute("farmaco", farmaco);
		
		return "update-farmaco"; 
	}
	
	@PostMapping("/atualizar/{id}")
	public String farmacoUpdate(@PathVariable("id") long id, @Valid Farmaco farmaco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			farmaco.setId(id);
		
		return "update-farmaco"; 
	}
		farmacorepository.save(farmaco);
		return "redirect:/index2";
	}
	
	@GetMapping("/deletar/{id}")
	public String deleteFarmaco(@PathVariable("id") long id, Model model) {
		Farmaco farmaco = farmacorepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id do Farmaco inválido:" + id));
		farmacorepository.delete(farmaco);
	return "redirect:/index2";
	}
}
