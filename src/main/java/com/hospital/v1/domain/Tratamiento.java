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
@Table(name = "Tratamiento")
@NamedStoredProcedureQuery(
    name = "Tratamiento.getTratamientos",
    procedureName = "get_tratamientos",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_tratamientos", type = void.class)
    },
    resultClasses = Tratamiento.class
)
@NamedStoredProcedureQuery(
    name = "Tratamiento.TraerTratamiento",
    procedureName = "expediente_tratamiento_package.TraerExpTrat",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idExpTrat", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "v_tratamiento", type = void.class)
    },
    resultClasses = { Tratamiento.class }
)
@NamedStoredProcedureQuery(
    name = "Tratamiento.AgregarTratamiento",
    procedureName = "expediente_tratamiento_package.AgregarExpTrat",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idExpTrat", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTratamiento", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idExpediente", type = Integer.class)
    }
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTRATAMIENTO")
    private Integer idTratamiento;
    
    @Column(name = "VISITAESPECIALISTA")
    private String visitaEspecialista;
    
    @Column(name = "cirugia")
    private char cirugia;
    
    @JoinColumn(name = "CEDPACIENTE", referencedColumnName="CEDPACIENTE")
    @ManyToOne
    private Paciente paciente;
    
}
