package com.farmacia.apifarmacia.FarmaciaProject.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.farmacia.apifarmacia.FarmaciaProject.entidies.Cliente;
import com.farmacia.apifarmacia.FarmaciaProject.repository.Clienterepository;

@Controller
public class ClienteController {
	
	@Autowired
	Clienterepository clienterepository;
	
	@GetMapping("/signup")
	public String showClienteForm(Cliente cliente) {
		return "add-cliente";
	}
	
	@PostMapping("/addcliente")
	public String addCliente(@Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-cliente";
		}
		
		clienterepository.save(cliente);
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String showClientListForm(Model model) {
		model.addAttribute("clientes", clienterepository.findAll());
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showclienteUpdate(@PathVariable("id") long id, Model model) {
		
		Cliente cliente = clienterepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id do cliente invalido:" + id));
		model.addAttribute("cliente", cliente);
		
		return "update-cliente"; 
	}
	
	@PostMapping("/update/{id}")
	public String clienteUpdate(@PathVariable("id") long id, @Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
		cliente.setId(id);
		
		return "update-cliente"; 
	}
		clienterepository.save(cliente);
		return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCliente(@PathVariable("id") long id, Model model) {
		Cliente cliente = clienterepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário do Id inválido:" + id));
		clienterepository.delete(cliente);
	return "redirect:/index";
	}
}
