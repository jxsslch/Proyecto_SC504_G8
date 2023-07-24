/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HorarioDao extends JpaRepository<Horario, Long> {
    
}
