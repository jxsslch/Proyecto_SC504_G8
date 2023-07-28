/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.HorarioDao;
import com.hospital.v1.domain.Horario;
import com.hospital.v1.domain.HorarioResult;
import com.hospital.v1.service.HorarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorarioServiceImpl implements HorarioService {
    
    @Autowired
    private HorarioDao horarioDao;
    
    private final EntityManager entityManager;
    
    public HorarioServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> getHorarios() {
       return horarioDao.getHorarios();
    }

    @Override
    public HorarioResult getByIdHorario(Long idHorario) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("TraerHorario");
        query.setParameter("p_idHorario", idHorario);
        query.execute();

        return (HorarioResult) query.getSingleResult();
    }

    @Override
    public void addHorario(Long idHorario, String dias, String horas) {
        horarioDao.agregarHorario(idHorario, dias, horas);
    }

    @Override
    public void deleteHorario(Long idHorario) {
        horarioDao.eliminarHorario(idHorario);
    }

    @Override
    public void updateHorario(Long idHorario, String dias, String horas) {
         horarioDao.actualizarHorairo(idHorario, dias, horas);
    }
    
}
