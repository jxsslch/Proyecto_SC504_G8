/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.service;

import com.hospital.v1.domain.TelDoctorDetails;
import java.util.List;


public interface TelDoctorService {
    
    public List<TelDoctorDetails> getTelDoctorDetails();

    public String insertTelDoctor(Integer idTelDoctor, Long cedDoctor, Integer numTelefono);

    public String updateTelDoctor(Integer idTelDoctor, Integer numTelefono);

    public String deleteTelDoctor(Integer idTelDoctor);
}
