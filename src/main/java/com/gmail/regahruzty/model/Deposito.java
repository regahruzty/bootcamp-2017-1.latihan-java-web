/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Diani
 */
public class Deposito {
    
    private Integer id;
    private Registrasi nomorRegister;
    private Integer jangkaWaktu;
    private Boolean perpanjangOtomatis;
    private Integer nominal;
    private Float bungaBulanan;
    private LocalDate jatuhTempo;
    private Float bungaPerAnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Registrasi getNomorRegister() {
        return nomorRegister;
    }

    public void setNomorRegister(Registrasi nomorRegister) {
        this.nomorRegister = nomorRegister;
    }

    public Integer getJangkaWaktu() {
        return jangkaWaktu;
    }

    public void setJangkaWaktu(Integer jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }

    public Boolean getPerpanjangOtomatis() {
        return perpanjangOtomatis;
    }

    public void setPerpanjangOtomatis(Boolean perpanjangOtomatis) {
        this.perpanjangOtomatis = perpanjangOtomatis;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Float getBungaBulanan() {
        return bungaBulanan;
    }

    public void setBungaBulanan(Float bungaBulanan) {
        this.bungaBulanan = bungaBulanan;
    }

    public LocalDate getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(LocalDate jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public Float getBungaPerAnum() {
        return bungaPerAnum;
    }

    public void setBungaPerAnum(Float bungaPerAnum) {
        this.bungaPerAnum = bungaPerAnum;
    }
    



}
