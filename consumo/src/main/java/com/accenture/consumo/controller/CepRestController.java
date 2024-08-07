package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;

@RestController
public class CepRestController {

	@Autowired
	private CepService cepService;

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
		
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);
		
		return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build(); 
	}
	
    @GetMapping("/view/{cep}")
    public String getCepView2(@PathVariable String cep, Model model) {
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);
        model.addAttribute("endereco", endereco);
        return "cepView"; // nome do template Thymeleaf
    }

}