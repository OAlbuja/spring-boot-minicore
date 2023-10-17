//Necesario para la persistencia de datos con la base de datos
//CrudRepository sirve para heredar todas las operaciones para la persistencia 
//hay documentacion en la pagina de Spring

package com.tempoquito.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tempoquito.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
