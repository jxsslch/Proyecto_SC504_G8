/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Paciente;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface PacienteDao extends JpaRepository<Paciente, Long> {
    
    @Procedure(name = "Paciente.getPacientes")
    List<Paciente> getPacientes();
    
    @Procedure(name = "Paciente.getPacienteByCed")
    Paciente traerPaciente(@Param("p_cedPaciente") Long cedPaciente);
    
    @Procedure(name = "AgregarPaciente")
    void agregarPaciente(@Param("p_cedPaciente") Long cedPaciente, 
            @Param("p_nomPaciente") String nombre,
            @Param("p_fechaNacimiento") Date fechaNacimiento,
            @Param("p_edad") Integer edad,
            @Param("p_genero") char genero);
    
    @Procedure(name = "ActualizarPaciente")
    void actualizarPaciente(@Param("p_cedPaciente") Long cedPaciente, 
            @Param("p_nomPaciente") String nombre,
            @Param("p_fechaNacimiento") Date fechaNacimiento,
            @Param("p_edad") Integer edad,
            @Param("p_genero") char genero);
    
    @Procedure(name="EliminarPaciente")
    void eliminarPaciente(@Param("p_cedPaciente") Long cedPaciente);
}
