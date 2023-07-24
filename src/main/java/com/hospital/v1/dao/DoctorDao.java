/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.v1.domain.Doctor;
import java.util.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface DoctorDao extends JpaRepository<Doctor, Long> {
    
    @Procedure(name = "Doctor.getDetails")
    List<HashMap<String,Object>> getDoctorDetails(@Param("p_cedDoctor") Long cedDoctor);
    
    @Procedure(name = "Doctor.getDoctors")
    List<Doctor> getDoctors();
    
    @Procedure(name = "TraerDoctor", outputParameterName = "v_doctor")
    Doctor traerDoctor(@Param("p_cedDoctor") Long cedDoctor);
    
    @Procedure(name = "AgregarDoctor")
    void agregarDoctor(@Param("p_cedDoctor") Long cedDoctor, 
            @Param("p_puesto") String puesto,
            @Param("p_nomDoctor") String nombre,
            @Param("p_genero") String genero,
            @Param("p_idHorario") Long idHorario);
    
    @Procedure(name = "ActualizarDoctor")
    void actualizarDoctor(@Param("p_cedDoctor") Long cedDoctor, 
            @Param("p_puesto") String puesto,
            @Param("p_nomDoctor") String nombre,
            @Param("p_genero") String genero,
            @Param("p_idHorario") Long idHorario);
    
    @Procedure(name="EliminarDoctor")
    void eliminarDoctor(@Param("p_cedDoctor") Long cedDoctor);

}