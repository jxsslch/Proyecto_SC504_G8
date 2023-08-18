package com.hospital.v1.service.impl;

import com.hospital.v1.dao.DoctorDao;
import com.hospital.v1.domain.Doctor;
import com.hospital.v1.domain.Horario;
import com.hospital.v1.service.DoctorService;
import com.hospital.v1.service.TelDoctorService;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {

    //Esto crea una unica copia de un objeto
    @Autowired
    private DoctorDao doctorDao;
    
    @Autowired
    private TelDoctorService telService;
    
    @Override
    @Procedure(name = "Doctor.getDetails")
    public Doctor getDoctorDetails(Long cedDoctor) {
        List<HashMap<String, Object>> map = doctorDao.getDoctorDetails(cedDoctor);

        return convertToDoctor(map);
    }

    public Doctor convertToDoctor(List<HashMap<String, Object>> map) {
        Long ceddoctor = 0L;
        String puesto = "";
        String nomdoctor = "";
        String genero = "";
        Horario idhorario = null;
        for (HashMap<String, Object> m : map) {
            ceddoctor = (Long) m.get("ceddoctor");
            puesto = (String) m.get("p_puesto");
            nomdoctor = (String) m.get("p_nomDoctor");
            genero = (String) m.get("p_genero");
            
            Long idhorarioId = (Long) m.get("p_idHorario");
            idhorario = new Horario(idhorarioId, "", "");
            
        }
        return new Doctor(ceddoctor, puesto, nomdoctor, genero, idhorario);
    }

    @Override
    @Transactional(readOnly = true)
    public Doctor getDoctorByCedDoctor(Long cedDoctor) {
        return doctorDao.traerDoctor(cedDoctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getDoctors() {
        return doctorDao.getDoctors();
    }

    @Override
    public void addDoctor(Long cedDoctor, String puesto, String nombre, String genero, Long idHorario) {
        doctorDao.agregarDoctor(cedDoctor, puesto, nombre, genero, idHorario);
        
    }

    @Override
    public void updateDoctor(Long cedDoctor, String puesto, String nombre, String genero, Long idHorario) {
        doctorDao.actualizarDoctor(cedDoctor, puesto, nombre, genero, idHorario);
    }

    @Override
    public void deleteDoctor(Long cedDoctor) {
        doctorDao.eliminarDoctor(cedDoctor);
    }
    

}
