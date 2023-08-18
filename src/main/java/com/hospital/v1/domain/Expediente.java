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
import jakarta.persistence.OneToOne;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Expediente")
@NamedStoredProcedureQuery(
    name = "Expedientes.getExpedientes",
    procedureName = "get_expedientes",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_expedientes", type = void.class)
    },
    resultClasses = Expediente.class
)
@NamedStoredProcedureQuery(
    name = "Expediente.insertExpediente",
    procedureName = "insert_expediente",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idExpediente", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numCita", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expediente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEXPEDIENTE")
    private Integer idExpediente;
    
    
    @JoinColumn(name = "CEDDOCTOR", referencedColumnName="CEDDOCTOR")
    @ManyToOne
    private Doctor doctor;
    
    @JoinColumn(name = "CEDPACIENTE", referencedColumnName="CEDPACIENTE")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "NUMCITA", referencedColumnName="NUMCITA")
    @OneToOne
    private Citas citas;
}
