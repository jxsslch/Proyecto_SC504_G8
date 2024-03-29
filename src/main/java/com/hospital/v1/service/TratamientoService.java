/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.service;

import com.hospital.v1.domain.Tratamiento;
import java.util.List;


public interface TratamientoService {
    List<Tratamiento> getTratamientos();
    
    void guardarTratamiento(Tratamiento trat);
    
    void eliminarTratamiento(Tratamiento trat);
    
    void actualizarTratamiento(Tratamiento trat);
}
