package com.app.inmobiliaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inmobiliaria.model.Inmobiliaria;
import com.app.inmobiliaria.repository.InmobiliariaRepository;

@Service
public class InmobiliariaService {

	@Autowired
	private InmobiliariaRepository inmobiliariaRepository;
	
	public Inmobiliaria create (Inmobiliaria inmobiliaria) {
		return inmobiliariaRepository.save(inmobiliaria);
	}
	
	public List<Inmobiliaria> getAllCasas (){
		return inmobiliariaRepository.findAll();
	}
	
	public void delete (Inmobiliaria inmobiliaria) {
		inmobiliariaRepository.delete(inmobiliaria);
	}
	
	public Optional<Inmobiliaria> findById (Long id) {
		return inmobiliariaRepository.findById(id);
	}
	
	public Inmobiliaria editInmobiliaria (Inmobiliaria inmobiliaria){
        if (inmobiliaria.getId() != null && inmobiliariaRepository.existsById(inmobiliaria.getId())){
            return inmobiliariaRepository.save(inmobiliaria);
        }
        return null;
    }
}
