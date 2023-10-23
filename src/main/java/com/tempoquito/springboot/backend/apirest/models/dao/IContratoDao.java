package com.tempoquito.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.tempoquito.springboot.backend.apirest.models.entity.Contrato;

public interface IContratoDao extends CrudRepository<Contrato, Long> {
}
