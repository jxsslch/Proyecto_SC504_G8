/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.v1.service.impl;

import com.hospital.v1.dao.DosisDao;
import com.hospital.v1.domain.Dosis;
import com.hospital.v1.service.DosisService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DosisServiceImpl implements DosisService {
    private DosisDao dosisDao;

    @Override
    @Transactional(readOnly = true)
    public List<Dosis> getDosis() {
        return dosisDao.getDosis();
    }
}
