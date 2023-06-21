/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.test.api.apicrud.mahasiswaRepository;

import com.test.api.apicrud.models.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alghifaris.bagaskara
 */
public interface mahasiswaRepository extends JpaRepository<Mahasiswa,Long> {
    
}
