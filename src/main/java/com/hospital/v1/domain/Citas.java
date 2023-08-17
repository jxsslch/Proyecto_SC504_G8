/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Citas")
@NamedStoredProcedureQuery(
    name = "getCitasDetails",
    procedureName = "get_citas_details",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
    },
    resultClasses = Citas.class
)
@NamedStoredProcedureQuery(
    name = "insertCitas",
    procedureName = "insert_citas",
    parameters = {
        @StoredProcedureParameter(name = "p_numCita", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_motivo", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_estado", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_fecha", type = Date.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_hora", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_cedPaciente", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "mensaje", type = String.class, mode = ParameterMode.OUT)
    }
)
@NamedStoredProcedureQuery(
    name = "updateCitas",
    procedureName = "update_citas",
    parameters = {
        @StoredProcedureParameter(name = "p_numCita", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_motivo", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_estado", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_fecha", type = Date.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_hora", type = String.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "p_cedPaciente", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "mensaje", type = String.class, mode = ParameterMode.OUT)
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMCITA")
    private Integer numCita;
    
    @Column(name = "motivo")
    private String motivo;
    
    @Column(name = "estado")
    private char estado;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "hora")
    private String hora;
    
    @JoinColumn(name = "CEDPACIENTE", referencedColumnName="CEDPACIENTE")
    @ManyToOne
    private Paciente paciente;
}
