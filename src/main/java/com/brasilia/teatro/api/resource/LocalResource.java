package com.brasilia.teatro.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.model.Local;
import com.brasilia.teatro.api.repository.LocalRepository;

@RestController
@RequestMapping("/locais")
public class LocalResource {

	@Autowired
	private LocalRepository localRepository;

	@GetMapping
	public List<Local> listar() {
		return localRepository.findAll();
	}

}
