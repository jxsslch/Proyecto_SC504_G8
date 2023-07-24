/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor")
@NamedStoredProcedureQuery(
        name = "Doctor.getDetails",
        procedureName = "get_doctor_details",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class),
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
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_doctor", type = void.class)
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

    public Doctor() {
    }
    
    
    
    public Doctor(Long ceddoctor, String puesto, String nomdoctor, String genero, Horario horario) {
        this.ceddoctor = ceddoctor;
        this.puesto = puesto;
        this.nomdoctor = nomdoctor;
        this.genero = genero;
        this.horario = horario;
    }

    public Long getCeddoctor() {
        return ceddoctor;
    }

    public void setCeddoctor(Long ceddoctor) {
        this.ceddoctor = ceddoctor;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNomdoctor() {
        return nomdoctor;
    }

    public void setNomdoctor(String nomdoctor) {
        this.nomdoctor = nomdoctor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

   
    
    
}
