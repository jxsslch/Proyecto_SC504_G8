/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.domain.Doctor;
import com.hospital.v1.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService docService;

    @GetMapping("/")
    public String listAll(Model model) {   
        var Doctores = docService.getDoctors();
        model.addAttribute("Doctores", Doctores);
        return "index";
    }
    
    @RequestMapping("/{ceddoctor}")
    public String getDoctorDetails(@PathVariable("ceddoctor") Long cedDoctor, Model model){
        model.addAttribute("Doctores",docService.getDoctorDetails(cedDoctor));
        return "index";
    }
}

