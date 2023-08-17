/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.TelDoctorDao;
import com.hospital.v1.domain.TelDoctorDetails;
import com.hospital.v1.service.TelDoctorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelDoctorServiceImpl implements TelDoctorService {
    
    @Autowired
    private TelDoctorDao telDoctorDao;
    
    @Autowired
    private EntityManager entityManager;

    public List<TelDoctorDetails> getTelDoctorDetails() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_telDoctor_details");
    query.registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);
    query.execute();

    List<Object[]> resultSet = query.getResultList();
    List<TelDoctorDetails> telDoctorDetailsList = new ArrayList<>();

    for (Object[] result : resultSet) {
        TelDoctorDetails telDoctorDetails = new TelDoctorDetails();
        telDoctorDetails.setIdTelDoctor((Integer) result[0]);
        telDoctorDetails.setCedDoctor((Integer) result[1]);
        telDoctorDetails.setNumTelefono((Integer) result[2]);
        telDoctorDetailsList.add(telDoctorDetails);
    }

    return telDoctorDetailsList;
    }

    public String insertTelDoctor(Integer idTelDoctor, Long cedDoctor, Integer numTelefono) {
        return telDoctorDao.insertTelDoctor(idTelDoctor, cedDoctor, numTelefono);
    }

    public String updateTelDoctor(Integer idTelDoctor, Integer numTelefono) {
        return telDoctorDao.updateTelDoctor(idTelDoctor, numTelefono);
    }

    public String deleteTelDoctor(Integer idTelDoctor) {
        return telDoctorDao.deleteTelDoctor(idTelDoctor);
    }
}
