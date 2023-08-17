/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.PacienteNacionalidadDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.v1.domain.PacienteNacionalidad;
import com.hospital.v1.domain.PacienteNacionalidadDetails;
import com.hospital.v1.service.PacienteNacionalidadService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class PacienteNacionalidadServiceImpl implements PacienteNacionalidadService {

    @Autowired
    private PacienteNacionalidadDao pacNacDao;

    @Override
    public List<PacienteNacionalidadDetails> getPacientes() {
        List<PacienteNacionalidad> pacienteNacionalidades = pacNacDao.findAll();
        List<PacienteNacionalidadDetails> pacienteNacionalidadDetailsList = new ArrayList<>();

        for (PacienteNacionalidad pacienteNacionalidad : pacienteNacionalidades) {
            PacienteNacionalidadDetails pacienteNacionalidadDetails = new PacienteNacionalidadDetails();

            pacienteNacionalidadDetails.setIdPacienteNacionalidad(pacienteNacionalidad.getIdPacienteNacionalidad());
            pacienteNacionalidadDetails.setNacionalidad(pacienteNacionalidad.getNacionalidad());
            pacienteNacionalidadDetails.setPaciente(pacienteNacionalidad.getPaciente());

            pacienteNacionalidadDetailsList.add(pacienteNacionalidadDetails);
        }

        return pacienteNacionalidadDetailsList;
    }

}
