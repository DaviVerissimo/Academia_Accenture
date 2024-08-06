package com.accenture.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pessoa.entity.Pessoa;
import com.accenture.pessoa.repository.PessoaRepository;

import jakarta.validation.Valid;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Optional<Pessoa> findById(long id) {
		
		return pessoaRepository.findById(id);

	}

	public Pessoa save(@Valid Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
	}

	public void delete(Pessoa pessoa) {
		
		pessoaRepository.delete(pessoa);
		
	}
}
