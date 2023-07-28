/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hospital.v1.service.HorarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hospital.v1.domain.Horario;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private HorarioService horService;

    @GetMapping("/")
    public String inicio(Model model) {
        var Horarios = horService.getHorarios();
        model.addAttribute("activePage", "horario");
        model.addAttribute("Horarios", Horarios);
        return "horario";
    }

    @RequestMapping("/{idHorario}")
    public String getHorarioDetails(@PathVariable("idHorario") Long idHorario, Model model) {
        var Horario = horService.getByIdHorario(idHorario);

        model.addAttribute("Horarios",Horario);
        return "horario";
    }
//    

    @PostMapping("/guardar")
    public String guardarHorario(@ModelAttribute Horario horario) {
        String horarioStr = horario.getHoras(); 
        Timestamp timestamp = convertToTimestamp(horarioStr);

        String[] array = String.valueOf(timestamp).split(" "); 
        System.out.println(array[1]);

        System.out.println(horarioStr);
        System.out.println(timestamp);

        horService.addHorario(horario.getIdHorario(),
                horario.getDias(),
                array[1]);
        return "redirect:/horario/";
    }

    
    @PostMapping("/actualizar")
    public String actualizarDoctor(@ModelAttribute Horario horario){
        horService.updateHorario(horario.getIdHorario(), 
                horario.getDias(), 
                horario.getHoras());
        return "redirect:/horario/";
    }
    

    @PostMapping("/borrar")
    public String borrarDoctor(@ModelAttribute Horario horario) {
        horService.deleteHorario(horario.getIdHorario());
        return "redirect:/horario/";
    }

    public Timestamp convertToTimestamp(String horarioStr) {
        // Create a LocalTime object with the provided hour and set minutes, seconds, and milliseconds to 0.
        LocalTime localTime = LocalTime.of(Integer.valueOf(horarioStr), 0, 0, 0);

        // Convert the LocalTime object to a java.sql.Timestamp (today's date will be used).
        return Timestamp.valueOf(localTime.atDate(java.time.LocalDate.now()));
    }

}
