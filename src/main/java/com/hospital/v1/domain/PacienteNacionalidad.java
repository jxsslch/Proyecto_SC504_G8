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
@Table(name = "PacienteNacionalidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteNacionalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPACIENTENACIONALIDAD")
    private Long idPacienteNacionalidad;
    
    @JoinColumn(name = "IDNACIONALIDAD", referencedColumnName="IDNACIONALIDAD")
    @ManyToOne
    private Nacionalidad nacionalidad;
    
    @JoinColumn(name = "CEDPACIENTE", referencedColumnName="CEDPACIENTE")
    @ManyToOne
    private Paciente paciente;


   
}
