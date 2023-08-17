/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name = "citas_activas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitasActivas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActivas;
    
    @JoinColumn(name = "numCita", referencedColumnName="numCita")
    @ManyToOne
    private Citas citas;
}
