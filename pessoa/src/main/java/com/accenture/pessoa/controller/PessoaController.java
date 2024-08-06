package com.accenture.pessoa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pessoa.entity.Pessoa;
import com.accenture.pessoa.service.PessoaService;

import jakarta.validation.Valid;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public List<Pessoa> Get() {

		return pessoaService.findAll();

	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id) {

		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if (pessoa.isPresent())
			return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST)
	public Pessoa Post(@Valid @RequestBody Pessoa pessoa) {
		
		return pessoaService.save(pessoa);
		
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa) {
		Optional<Pessoa> oldPessoa = pessoaService.findById(id);
		if (oldPessoa.isPresent()) {
			Pessoa pessoa = oldPessoa.get();
			pessoa.setNome(newPessoa.getNome());
			pessoaService.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if (pessoa.isPresent()) {
			pessoaService.delete(pessoa.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}