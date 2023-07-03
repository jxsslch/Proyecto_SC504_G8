package com.hospital.v1.service.impl;

import com.hospital.v1.dao.DoctorDao;
import com.hospital.v1.domain.Doctor;
import com.hospital.v1.service.DoctorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    //Esto crea una unica copia de un objeto
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> getDoctors() {
        var lista = (List<Doctor>) doctorDao.findAll(); //Devuelve el listado de los registros de la tabla doctor
        return lista;
    }

    @Override
    public Doctor getDoctor(Doctor doctor) {
        return doctorDao.findById(doctor.getCeddoctor()).orElse(null);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorDao.delete(doctor);
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorDao.save(doctor);
    }

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
        Long idhorario = 0L;
        for (HashMap<String, Object> m : map) {
            ceddoctor = (Long) m.get("ceddoctor");
            puesto = (String) m.get("p_puesto");
             nomdoctor = (String) m.get("p_nomDoctor");
             genero = (String) m.get("p_genero");
             idhorario = (Long) m.get("p_idHorario");
            
        }
        return new Doctor(ceddoctor, puesto, nomdoctor, genero, idhorario);
    }

}
