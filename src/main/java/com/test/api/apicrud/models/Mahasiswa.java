/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.api.apicrud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alghifaris.bagaskara
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="Mahasiswa",schema="public")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "generator_mahasiswaIdSeq")
    @SequenceGenerator(name="generator_mahasiswaIdSeq",sequenceName="generatorMahasiswaIdSeq",schema= "public",allocationSize = 1)
    private long Id;
    private String Name;
    @Column(name="Gender")
    private String Gender;
}
