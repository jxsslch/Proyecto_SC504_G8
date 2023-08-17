/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.service;

import java.util.List;
import com.hospital.v1.domain.Citas;
import java.sql.Date;

public interface CitasService {
    
    public List<Citas> getCitas();
    
    public String insertarCitas(Integer numCita, String motivo, String estado, Date fecha, String hora, Integer cedPaciente);
    
    public String actualizarCitas(Integer numCita, String motivo, String estado, Date fecha, String hora, Integer cedPaciente);
}
