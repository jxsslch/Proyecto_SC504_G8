/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.ExpedienteDao;
import com.hospital.v1.domain.Expediente;
import com.hospital.v1.service.ExpedienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {
    
    @Autowired
    private ExpedienteDao expedDao;

    @Override
    @Transactional(readOnly = true)
    public List<Expediente> getExpedientes() {
        return expedDao.getExpedientes();
    }

    @Override
    public String insertExpedienteProcedure(Integer p_idExpediente, Long p_cedDoctor, Long p_cedPaciente, Integer p_numCita) {
        return expedDao.insertExpedienteProcedure(p_idExpediente, p_cedDoctor, p_cedPaciente, p_numCita);
    }
    
    
}
