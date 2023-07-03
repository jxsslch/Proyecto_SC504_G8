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
}
