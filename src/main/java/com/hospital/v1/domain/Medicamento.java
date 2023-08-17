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
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "medicamento")
@NamedStoredProcedureQuery(
    name = "Medicamento.getMedicamentos",
    procedureName = "get_medicamentos",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_medicamentos", type = void.class)
    },
    resultClasses = Medicamento.class
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMEDICAMENTO")
    private Integer idMedicamento;
    
    @Column(name = "NOMMEDICAMENTO")
    private String nomMedicamento;
    
    @Column(name = "CANTDISPONIBLE")
    private Integer cantDisponible;
    
    @Column(name = "FECHAVENCIMIENTO")
    private Date fechaVencimiento;
    
    
    
    
}
