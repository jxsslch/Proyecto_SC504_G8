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
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "get_telDoctor_details",
        procedureName = "get_telDoctor_details",
        resultClasses = {TelDoctor.class}
    ),
    @NamedStoredProcedureQuery(
        name = "insert_telDoctor",
        procedureName = "insert_telDoctor",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numTelefono", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "update_telDoctor",
        procedureName = "update_telDoctor",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numTelefono", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "delete_telDoctor",
        procedureName = "delete_telDoctor",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelDoctor", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telDoctor")
public class TelDoctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTELDOCTOR")
    private Integer idTelDoctor;
    
    @Column(name = "NUMTELEFONO")
    private Integer numTelefono;
    
    @ManyToOne
    @JoinColumn(name = "cedDoctor", referencedColumnName = "cedDoctor", updatable = false)
    private Doctor doctor;
    
    
     public TelDoctor(TelDoctorDetails telDoctorDetails) {
        this.idTelDoctor = telDoctorDetails.getIdTelDoctor();
        this.numTelefono = telDoctorDetails.getNumTelefono();
    }
    
}
