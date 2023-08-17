/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hospital.v1.dao;

import com.hospital.v1.domain.Citas;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface CitasDao extends JpaRepository<Citas, Integer> {
    @Procedure(name = "getCitasDetails")
    List<Citas> getCitasDetails();

    @Procedure(name = "insertCitas")
    String insertCitas(
        @Param("p_numCita") Integer numCita,
        @Param("p_motivo") String motivo,
        @Param("p_estado") String estado,
        @Param("p_fecha") Date fecha,
        @Param("p_hora") String hora,
        @Param("p_cedPaciente") Integer cedPaciente
    );

    @Procedure(name = "updateCitas")
    String updateCitas(
        @Param("p_numCita") Integer numCita,
        @Param("p_motivo") String motivo,
        @Param("p_estado") String estado,
        @Param("p_fecha") Date fecha,
        @Param("p_hora") String hora,
        @Param("p_cedPaciente") Integer cedPaciente
    );
}
