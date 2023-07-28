/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Horario;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface HorarioDao extends JpaRepository<Horario, Long> {
    
    
    @Procedure(name = "Horario.getHorarios")
    List<Horario> getHorarios();
    
    @Procedure(name = "TraerHorario")
    List<Horario> getHorarioByIdHorario(@Param("p_idHorario") Long idHorario);
    
    @Procedure(name = "AgregarHorario")
    void agregarHorario(@Param("p_idHorario") Long idHorario, 
            @Param("p_dias") String dias,
            @Param("p_horas") String horas); 
    
    @Procedure(name = "EliminarHorario")
    void eliminarHorario(@Param("p_idHorario") Long idHorario);
    
    @Procedure(name = "ActualizarHorario")
    void actualizarHorairo(@Param("p_idHorario") Long idHorario, 
            @Param("p_dias") String dias,
            @Param("p_horas") String horas); 
}
