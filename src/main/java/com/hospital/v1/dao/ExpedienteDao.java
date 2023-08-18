/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Expediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface ExpedienteDao extends JpaRepository<Expediente, Integer> {
    @Procedure(name = "Expedientes.getExpedientes")
    public List<Expediente> getExpedientes();
    
    @Procedure(name = "insert_expediente")
    String insertExpedienteProcedure(
        Integer p_idExpediente,
        Long p_cedDoctor,
        Long p_cedPaciente,
        Integer p_numCita
    );
}
