package com.tempoquito.springboot.backend.apirest.models.services;

import java.util.List;
import com.tempoquito.springboot.backend.apirest.models.entity.Contrato;

public interface IContratoService {
	public List<Contrato> findAll();
	public Contrato findById(Long id);
	public Contrato save(Contrato contrato);
	public void delete(Long id);
}
