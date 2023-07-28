/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.service;

import java.util.List;
import com.hospital.v1.domain.Horario;
import com.hospital.v1.domain.HorarioResult;
import java.sql.Timestamp;

public interface HorarioService {
    public List<Horario> getHorarios();
    
    public HorarioResult getByIdHorario(Long idHorario);
    
    public void addHorario(Long idHorario, String dias, String horas);
    
    public void deleteHorario(Long idHorario);
    
    public void updateHorario(Long idHorario, String dias, String horas);
}
