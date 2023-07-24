/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "Horario")
public class Horario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHORARIO")
    private Long idHorario;
    
    @Column(name = "dias")
    private String dias;

    @Column(name = "horas")
    private String horas;

    public Horario() {
    }

    public Horario(Long idHorario, String dias, String horas) {
        this.idHorario = idHorario;
        this.dias = dias;
        this.horas = horas;
    }    

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDias() {
        return dias;
    }

    public String getHoras() {
        return horas;
    }
    
    
    
}
