package com.tempoquito.springboot.backend.apirest.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tempoquito.springboot.backend.apirest.models.dao.IContratoDao;
import com.tempoquito.springboot.backend.apirest.models.entity.Contrato;

@Service
public class ContratoServiceImpl implements IContratoService {

	@Autowired
	private IContratoDao contratoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Contrato> findAll() {
		return (List<Contrato>) contratoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Contrato findById(Long id) {
		return contratoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Contrato save(Contrato contrato) {
		return contratoDao.save(contrato);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		contratoDao.deleteById(id);
	}
}
