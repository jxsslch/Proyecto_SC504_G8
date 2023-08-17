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
        name = "get_telPaciente_details",
        procedureName = "get_telPaciente_details",
        resultClasses = {TelPaciente.class}
    ),
    @NamedStoredProcedureQuery(
        name = "insert_telPaciente",
        procedureName = "insert_telPaciente",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelPaciente", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedPaciente", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numTelefono", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "update_telPaciente",
        procedureName = "update_telPaciente",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelPaciente", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numTelefono", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    ),
    @NamedStoredProcedureQuery(
        name = "delete_telPaciente",
        procedureName = "delete_telPaciente",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idTelPaciente", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class)
        }
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telPaciente")
public class TelPaciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTELPACIENTE")
    private Integer idTelPaciente;
    
    @Column(name = "NUMTELEFONO")
    private Integer numTelefono;
    
    @ManyToOne
    @JoinColumn(name = "cedPaciente", referencedColumnName = "cedPaciente", updatable = false)
    private Paciente paciente;
    
    
     public TelPaciente(TelPacienteDetails telPacienteDetails) {
        this.idTelPaciente = telPacienteDetails.getIdTelPaciente();
        this.numTelefono = telPacienteDetails.getNumTelefono();
    }
    
}
