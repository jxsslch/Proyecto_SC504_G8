/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.TelPacienteDao;
import com.hospital.v1.domain.TelPacienteDetails;
import com.hospital.v1.service.TelPacienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelPacienteServiceImpl implements TelPacienteService {
    
    @Autowired
    private TelPacienteDao telPacienteDao;
    
    @Autowired
    private EntityManager entityManager;

    public List<TelPacienteDetails> getTelPacienteDetails() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_telPaciente_details");
    query.registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);
    query.execute();

    List<Object[]> resultSet = query.getResultList();
    List<TelPacienteDetails> telPacienteDetailsList = new ArrayList<>();

    for (Object[] result : resultSet) {
        TelPacienteDetails telPacienteDetails = new TelPacienteDetails();
        telPacienteDetails.setIdTelPaciente((Integer) result[0]);
        telPacienteDetails.setCedPaciente((Integer) result[1]);
        telPacienteDetails.setNumTelefono((Integer) result[2]);
        telPacienteDetailsList.add(telPacienteDetails);
    }

    return telPacienteDetailsList;
    }

    public String insertTelPaciente(Integer idTelPaciente, Long cedPaciente, Integer numTelefono) {
        return telPacienteDao.insertTelPaciente(idTelPaciente, cedPaciente, numTelefono);
    }

    public String updateTelPaciente(Integer idTelPaciente, Integer numTelefono) {
        return telPacienteDao.updateTelPaciente(idTelPaciente, numTelefono);
    }

    public String deleteTelPaciente(Integer idTelPaciente) {
        return telPacienteDao.deleteTelPaciente(idTelPaciente);
    }
}
