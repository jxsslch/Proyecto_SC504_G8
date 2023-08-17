/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.service;

import com.hospital.v1.domain.TelPacienteDetails;
import java.util.List;


public interface TelPacienteService {
    
    public List<TelPacienteDetails> getTelPacienteDetails();

    public String insertTelPaciente(Integer idTelPaciente, Long cedPaciente, Integer numTelefono);

    public String updateTelPaciente(Integer idTelPaciente, Integer numTelefono);

    public String deleteTelPaciente(Integer idTelPaciente);
}
