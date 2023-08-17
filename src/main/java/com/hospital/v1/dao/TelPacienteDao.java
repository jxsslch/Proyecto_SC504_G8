/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.TelPaciente;
import com.hospital.v1.domain.TelPacienteDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface TelPacienteDao extends JpaRepository<TelPaciente, Long> {
    @Procedure(name = "get_telPaciente_details")
    List<TelPacienteDetails> getTelPacienteDetails();

    @Procedure(name = "insert_telPaciente")
    String insertTelPaciente(Integer p_idTelPaciente, Long p_cedPaciente, Integer p_numTelefono);

    @Procedure(name = "update_telPaciente")
    String updateTelPaciente(Integer p_idTelPaciente, Integer p_numTelefono);

    @Procedure(name = "delete_telPaciente")
    String deleteTelPaciente(Integer p_idTelPaciente);
}
