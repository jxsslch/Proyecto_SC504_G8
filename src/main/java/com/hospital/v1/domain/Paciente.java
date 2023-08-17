/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Paciente")
@NamedStoredProcedureQuery(
    name = "Paciente.getPacientes",
    procedureName = "get_pacientes",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_pacientes", type = void.class)
    },
    resultClasses = { Paciente.class }
)

@NamedStoredProcedureQuery(
    name = "TraerPaciente",
    procedureName = "paciente_package.TraerPaciente",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_paciente", type = void.class)
    },
    resultClasses = { Paciente.class }
)
@NamedStoredProcedureQuery(
        name = "AgregarPaciente",
        procedureName = "paciente_package.AgregarPaciente",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomPaciente", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechaNacimiento", type = Date.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_edad", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_genero", type = char.class)
        }
)
@NamedStoredProcedureQuery(
    name = "ActualizarPaciente",
    procedureName = "paciente_package.ActualizarPaciente",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomPaciente", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechaNacimiento", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_edad", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_genero", type = char.class)
    }
)
@NamedStoredProcedureQuery(
    name = "EliminarPaciente",
    procedureName = "paciente_package.EliminarPaciente",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Long.class)
    }
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CEDPACIENTE")
    private Long cedPaciente;
    
    @Column(name = "NOMPACIENTE")
    private String nomPaciente;

    @Column(name = "FECHANACIMIENTO")
    private Date fechaNacimiento;
    
    @Column(name = "edad")
    private Integer edad;
    
    @Column(name = "genero")
    private char genero;
    

    


   
}
