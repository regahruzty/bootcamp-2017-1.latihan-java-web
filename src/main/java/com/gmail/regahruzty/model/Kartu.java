/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.model;

import java.sql.Date;

/**
 *
 * @author Diani
 */
public class Kartu {
    
    private Integer bulanKe;
    private Float bungaBulanan;
    private Date jatuhTempo;

    public Integer getBulanKe() {
        return bulanKe;
    }

    public void setBulanKe(Integer bulanKe) {
        this.bulanKe = bulanKe;
    }

    public Float getBungaBulanan() {
        return bungaBulanan;
    }

    public void setBungaBulanan(Float bungaBulanan) {
        this.bungaBulanan = bungaBulanan;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }
    
}
