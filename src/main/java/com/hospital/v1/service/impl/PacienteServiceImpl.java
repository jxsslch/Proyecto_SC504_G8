/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.PacienteDao;
import com.hospital.v1.domain.Paciente;
import com.hospital.v1.service.PacienteService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteServiceImpl implements PacienteService{
    
    @Autowired
    private PacienteDao pacienteDao;

    @Override
    public Paciente getPacienteByCedPaciente(Long cedPaciente) {
        return pacienteDao.traerPaciente(cedPaciente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> getPacientes() {
        return pacienteDao.getPacientes();
    }

    @Override
    public void addPaciente(Long cedPaciente, String nombre, Date fechaNacimiento, Integer edad, char genero) {
        pacienteDao.agregarPaciente(cedPaciente, nombre, fechaNacimiento, edad, genero);
    }

    @Override
    public void updatePaciente(Long cedPaciente, String nombre, Date fechaNacimiento, Integer edad, char genero) {
       pacienteDao.actualizarPaciente(cedPaciente, nombre, fechaNacimiento, edad, genero);
    }

    @Override
    public void deletePaciente(Long cedPaciente) {
       pacienteDao.eliminarPaciente(cedPaciente);
    }
}
