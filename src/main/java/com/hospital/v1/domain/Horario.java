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
import java.sql.Timestamp;

@Entity
@Table(name = "Horario")
@NamedStoredProcedureQuery(
    name = "Horario.getHorarios",
    procedureName = "get_horarios",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_horarios", type = void.class)
    },
    resultClasses = { Horario.class }
)
@NamedStoredProcedureQuery(
        name = "AgregarHorario",
        procedureName = "horario_package.AgregarHorario",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dias", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_horas", type = String.class)
        }
)
@NamedStoredProcedureQuery(
    name = "TraerHorario",
    procedureName = "horario_package.TraerHorario",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "v_horario", type = void.class)
    },
    resultClasses = { HorarioResult.class }
)
@NamedStoredProcedureQuery(
    name = "EliminarHorario",
    procedureName = "horario_package.EliminarHorario",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class)
    }
)
@NamedStoredProcedureQuery(
        name = "ActualizarHorario",
        procedureName = "horario_package.ActualizarHorario",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idHorario", type = Long.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dias", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_horas", type = String.class)
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHORARIO")
    private Long idHorario;
    
    @Column(name = "dias")
    private String dias;

    @Column(name = "horas")
    private String horas;
    
}
