/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.v1.domain.Resultados;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ResultadosDao extends JpaRepository<Resultados, Integer> {
    
    @Procedure(name = "Resultados.getResultados")
    List<Resultados> getResultados();
    
}
