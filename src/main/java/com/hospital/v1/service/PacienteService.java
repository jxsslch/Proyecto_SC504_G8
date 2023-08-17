
package com.hospital.v1.service;

import com.hospital.v1.domain.Paciente;
import java.sql.Date;
import java.util.List;

public interface PacienteService {
//    public Paciente getPacienteDetails(Long cedPaciente);
//    
//    public Paciente convertToPaciente(List<HashMap<String, Object>> map);
    
    public Paciente getPacienteByCedPaciente(Long cedPaciente);
    
    public List<Paciente> getPacientes();
    
    public void addPaciente( Long cedPaciente,
            String nombre,
            Date fechaNacimiento,
            Integer edad,
            char genero);
    
    public void updatePaciente(Long cedPaciente,
            String nombre,
            Date fechaNacimiento,
            Integer edad,
            char genero);
    
    public void deletePaciente(Long cedPaciente);
}
