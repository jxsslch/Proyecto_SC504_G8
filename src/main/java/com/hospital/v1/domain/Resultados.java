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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "resultados")
@NamedStoredProcedureQuery(
    name = "Resultados.getResultados",
    procedureName = "get_resultados",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_resultados", type = void.class)
    },
    resultClasses = Resultados.class
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRESULTADO")
    private Integer idResultado;
    
    @Column(name = "dictamen")
    private String dictamen;
    
    @Column(name = "analisis")
    private String analisis;
    
    @JoinColumn(name = "CEDPACIENTE", referencedColumnName="CEDPACIENTE")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "CEDDOCTOR", referencedColumnName="CEDDOCTOR")
    @ManyToOne
    private Doctor doctor;
    
    @JoinColumn(name = "IDEXPEDIENTE", referencedColumnName = "IDEXPEDIENTE")
    @ManyToOne
    private Expediente expediente;
    
    
}
