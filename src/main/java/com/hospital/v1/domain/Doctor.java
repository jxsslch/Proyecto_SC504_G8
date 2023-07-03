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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ceddoctor;

    private String puesto;
    private String nomdoctor;
    private String genero;
    private Long idhorario;

    public Doctor() {
    }
    
    
    
    public Doctor(Long ceddoctor, String puesto, String nomdoctor, String genero, Long idhorario) {
        this.ceddoctor = ceddoctor;
        this.puesto = puesto;
        this.nomdoctor = nomdoctor;
        this.genero = genero;
        this.idhorario = idhorario;
    }

    public Long getCeddoctor() {
        return ceddoctor;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getNomdoctor() {
        return nomdoctor;
    }

    public String getGenero() {
        return genero;
    }

    public Long getIdhorario() {
        return idhorario;
    }

    public void setCeddoctor(Long ceddoctor) {
        this.ceddoctor = ceddoctor;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setNomdoctor(String nomdoctor) {
        this.nomdoctor = nomdoctor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdhorario(Long idhorario) {
        this.idhorario = idhorario;
    }

}
