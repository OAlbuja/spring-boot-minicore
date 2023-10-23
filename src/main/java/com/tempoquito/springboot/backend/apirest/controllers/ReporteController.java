package com.tempoquito.springboot.backend.apirest.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tempoquito.springboot.backend.apirest.models.dao.IClienteDao;
import com.tempoquito.springboot.backend.apirest.models.dao.IContratoDao;
import com.tempoquito.springboot.backend.apirest.models.entity.Cliente;
import com.tempoquito.springboot.backend.apirest.models.entity.Contrato;

@Controller
@RequestMapping("/reporte") 
public class ReporteController {
	
	@Autowired
	private IContratoDao contratoDao;
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	public String listar(Model model){
		return "home";
	}
	
	@GetMapping("/listar")
	public String listar(Model model, List<List<String>> resultados){
		model.addAttribute("core", resultados);
		return "home";
	}
	
	@RequestMapping(value = "/resultado", method = { RequestMethod.POST, RequestMethod.GET })
	public String minicore(Model model, Date fechaFin, Date fechaInicio){
		List<List<String>> resultados = new ArrayList<>();
		
		List<Date> fechas = new ArrayList<>();
		fechas.add(fechaInicio);
		Calendar c = Calendar.getInstance();
		Calendar h = Calendar.getInstance();
		c.setTime(fechaInicio);
		h.setTime(fechaFin);
		Date fechaTemp;
		fechaTemp = new java.sql.Date(c.getTimeInMillis());
		while(c.before(h)) {
			c.add(Calendar.DATE, 1);
			fechaTemp = new java.sql.Date(c.getTimeInMillis());
			fechas.add(fechaTemp);
		}
		float totalGeneral=0;
		for (Cliente temp : clienteDao.findAll()) {
			List<String> clientes = new ArrayList<String>();
			clientes.add(temp.getNombre());
			float total = 0;			
			for (Contrato con : contratoDao.findAll()) {
				for(Date f : fechas) {
					if (con.getCliente().getId() == temp.getId() && f.compareTo(con.getFecha()) == 0) {
						total = total + con.getMontos();
						totalGeneral= totalGeneral+total;
					}
				}
			}
			clientes.add(Float.toString(total));	
			resultados.add(clientes);
		}
		List<String> montos = new ArrayList<String>();
		montos.add("Total");
		montos.add(Float.toString(totalGeneral));
		resultados.add(montos);
		return listar(model, resultados);
	}
}
