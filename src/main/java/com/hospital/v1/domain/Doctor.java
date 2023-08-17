/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Doctor")
@NamedStoredProcedureQuery(
        name = "Doctor.getDetails",
        procedureName = "get_doctor_details",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "p_cedDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_puesto", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_nomDoctor", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_genero", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_idHorario", type = Long.class)
        }
)
@NamedStoredProcedureQuery(
    name = "Doctor.getDoctors",
    procedureName = "get_doctors",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_doctors", type = void.class)
    },
    resultClasses = { Doctor.class }
)

@NamedStoredProcedureQuery(
    name = "TraerDoctor",
    procedureName = "doctor_package.TraerDoctor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "v_doctor", type = void.class)
    },
    resultClasses = { Doctor.class }
)
@NamedStoredProcedureQuery(
        name = "AgregarDoctor",
        procedureName = "doctor_package.AgregarDoctor",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_puesto", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomDoctor", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_genero", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class)
        }
)
@NamedStoredProcedureQuery(
    name = "ActualizarDoctor",
    procedureName = "doctor_package.ActualizarDoctor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_puesto", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomDoctor", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_genero", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class)
    }
)
@NamedStoredProcedureQuery(
    name = "EliminarDoctor",
    procedureName = "doctor_package.EliminarDoctor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class)
    }
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ceddoctor;

    private String puesto;
    private String nomdoctor;
    private String genero;
    
    @JoinColumn(name = "IDHORARIO", referencedColumnName="IDHORARIO")
    @ManyToOne
    private Horario horario;
    


   
}
