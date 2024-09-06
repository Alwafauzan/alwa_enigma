package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jurusan")
    private String jurusan;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Matkul> matkuls;

    // Constructors
    public Student() {
    }

    public Student(String nama, String jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}

// @Entity
// @Table(name = "matkul")
// public class Matkul {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private int matkul_id;

// @Column(name = "matkul_name")
// private String matkul_name;

// @Column(name = "student_id")
// private String student_id;

// // Constructors
// public Matkul() {
// }

// public Matkul(String matkul_name, String student_id) {
// this.matkul_name = matkul_name;
// this.student_id = student_id;
// }

// // Getters and Setters
// public int getId() {
// return matkul_id;
// }

// public void setId(int matkul_id) {
// this.matkul_id = matkul_id;
// }

// public String getNama() {
// return matkul_name;
// }

// public void setNama(String matkul_name) {
// this.matkul_name = matkul_name;
// }

// public String getKode() {
// return student_id;
// }

// public void setKode(String student_id) {
// this.student_id = student_id;
// }
// }
