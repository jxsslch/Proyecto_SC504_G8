/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Tratamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface TratamientoDao extends JpaRepository<Tratamiento, Integer> {
    @Procedure(name = "Tratamiento.getTratamientos")
    List<Tratamiento> getTratamientos();
    
}
