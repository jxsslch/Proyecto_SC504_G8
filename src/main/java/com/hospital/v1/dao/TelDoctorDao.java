/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.TelDoctor;
import com.hospital.v1.domain.TelDoctorDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface TelDoctorDao extends JpaRepository<TelDoctor, Long> {
    @Procedure(name = "get_telDoctor_details")
    List<TelDoctorDetails> getTelDoctorDetails();

    @Procedure(name = "insert_telDoctor")
    String insertTelDoctor(Integer p_idTelDoctor, Long p_cedDoctor, Integer p_numTelefono);

    @Procedure(name = "update_telDoctor")
    String updateTelDoctor(Integer p_idTelDoctor, Integer p_numTelefono);

    @Procedure(name = "delete_telDoctor")
    String deleteTelDoctor(Integer p_idTelDoctor);
}
