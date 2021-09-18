package com.farmacia.apifarmacia.FarmaciaProject.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.farmacia.apifarmacia.FarmaciaProject.entidies.Funcionario;
import com.farmacia.apifarmacia.FarmaciaProject.repository.Funcionariorepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	Funcionariorepository funcionariorepository;
	
	@GetMapping("/start")
	public String showFuncionarioForm(Funcionario funcionario) {
		return "add-funcionario";
	}
	
	@PostMapping("/addfuncionario")
	public String addFuncionario(@Valid Funcionario funcionario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-funcionario";
		}
		
		funcionariorepository.save(funcionario);
		return "redirect:/index3";
	}
	@GetMapping("/index3")
	public String showFuncionarioList(Model model) {
		model.addAttribute("funcionarios", funcionariorepository.findAll());
		return "/index3";
	}
	
	@GetMapping("/editar2/{id}")
	public String showFuncionarioUpdate(@PathVariable("id") long id, Model model) {
		
		Funcionario funcionario = funcionariorepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id do Funcionario invalido:" + id));
		model.addAttribute("funcionario", funcionario);
		
		return "update-funcionario"; 
	}
	
	@PostMapping("/atualizar2/{id}")
	public String funcionarioUpdate(@PathVariable("id") long id, @Valid Funcionario funcionario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			funcionario.setId(id);
		
		return "update-funcionario"; 
	}
		funcionariorepository.save(funcionario);
		return "redirect:/index3";
	}
	
	@GetMapping("/deletar2/{id}")
	public String deleteFuncionario(@PathVariable("id") long id, Model model) {
		Funcionario funcionario = funcionariorepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id do Funcionario inválido:" + id));
		funcionariorepository.delete(funcionario);
	return "redirect:/index3";
	}
}
