/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.dao;

import com.gmail.regahruzty.configuration.KonfigurasiDB;
import com.gmail.regahruzty.model.Deposito;
import com.gmail.regahruzty.model.Registrasi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diani
 */
public class DepositoDao {
    
    public List<Deposito> semuaDataDeposito() throws SQLException {
        List<Deposito> listDeposito = new ArrayList<>();
        String sql = "select id, nomor_register_id, jangka_waktu, perpanjang_otomatis, nominal, bunga_per_anum, bunga_bulanan, jatuh_tempo, tanggal_buat, nomor_register, nama_nasabah, jenis_kelamin from latihan_2.aplikasi apk join latihan_2.registrasi reg on (apk.nomor_register_id = reg.nomor_register)";
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Deposito deposito = new Deposito();
            deposito.setId(resultSet.getInt("id"));
            deposito.setJangkaWaktu(resultSet.getInt("jangka_waktu"));
            deposito.setPerpanjangOtomatis(resultSet.getBoolean("perpanjang_otomatis"));
            deposito.setNominal(resultSet.getInt("nominal"));
            deposito.setBungaPerAnum(resultSet.getFloat("bunga_per_anum"));
            deposito.setBungaBulanan(resultSet.getFloat("bunga_bulanan"));
            deposito.setJatuhTempo(resultSet.getDate("jatuh_tempo").toLocalDate());
            deposito.setTanggalBuat(resultSet.getDate("tanggal_buat"));
            
            Registrasi registrasi = new Registrasi();
            registrasi.setNomorRegister(resultSet.getInt("nomor_register"));
            registrasi.setNamaNasabah(resultSet.getString("nama_nasabah"));
            registrasi.setJenisKelamin(resultSet.getString("jenis_kelamin"));
            deposito.setNomorRegister(registrasi);
            
            listDeposito.add(deposito);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listDeposito;
    } 
    
    
    
    public void save(Deposito deposito) throws SQLException {
        
        Integer value = deposito.getJangkaWaktu();
        LocalDate now = LocalDate.now();
        LocalDate plus = now.plusMonths(deposito.getJangkaWaktu());
        Long dayPunish = ChronoUnit.DAYS.between(now, plus);
        System.out.println(dayPunish);
        
       
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "insert into latihan_2.aplikasi (nomor_register_id, jangka_waktu, perpanjang_otomatis, nominal, bunga_per_anum, bunga_bulanan, jatuh_tempo, tanggal_buat) values (?, ?, ?, ?, ?, ?, ?, now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, deposito.getNomorRegister().getNomorRegister());
        preparedStatement.setInt(2, deposito.getJangkaWaktu());
        preparedStatement.setBoolean(3, deposito.getPerpanjangOtomatis());
        preparedStatement.setInt(4, deposito.getNominal());
        preparedStatement.setFloat(5, deposito.getBungaPerAnum());
        preparedStatement.setFloat(6, (deposito.getBungaPerAnum()/100)*deposito.getNominal()*30/365);
        
        Float bunga = deposito.getBungaPerAnum()/100*deposito.getNominal()*30/365;
        System.out.println(bunga);
        
        preparedStatement.setDate(7, Date.valueOf(plus));
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
    }
    
    public Deposito cariDepositoDenganId(Integer id) throws SQLException { 
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "select * from latihan_2.aplikasi apk join latihan_2.registrasi reg on (apk.nomor_register_id = reg.nomor_register) where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        Deposito deposito = new Deposito();
        if (resultSet.next()) {
            deposito.setId(resultSet.getInt("id"));
            deposito.setJangkaWaktu(resultSet.getInt("jangka_waktu"));
            deposito.setNominal(resultSet.getInt("nominal"));
            deposito.setPerpanjangOtomatis(resultSet.getBoolean("perpanjang_otomatis"));
            deposito.setBungaPerAnum(resultSet.getFloat("bunga_per_anum"));
            deposito.setBungaBulanan(resultSet.getFloat("bunga_bulanan"));
            deposito.setJatuhTempo(resultSet.getDate("jatuh_tempo").toLocalDate());
            deposito.setTanggalBuat(resultSet.getDate("tanggal_buat"));
            
            Registrasi registrasi = new Registrasi();
            registrasi.setNomorRegister(resultSet.getInt("nomor_register"));
            registrasi.setNamaNasabah(resultSet.getString("nama_nasabah"));
            registrasi.setJenisKelamin(resultSet.getString("jenis_kelamin"));
            
            deposito.setNomorRegister(registrasi);
            
        }
              return deposito; 
}
    
    public void kartu(Deposito deposito) throws SQLException {
        
        Integer value = deposito.getJangkaWaktu();
        LocalDate now = LocalDate.now();
        LocalDate plus = now.plusMonths(deposito.getJangkaWaktu());
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "insert into latihan_2.kartu(bulan_ke, bunga_bulanan, jatuh_tempo_kartu) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, deposito.getNomorRegister().getNomorRegister());
        preparedStatement.setInt(2, deposito.getJangkaWaktu());
        preparedStatement.setBoolean(3, deposito.getPerpanjangOtomatis());
        preparedStatement.setInt(4, deposito.getNominal());
        preparedStatement.setFloat(5, deposito.getBungaPerAnum());
        preparedStatement.setFloat(6, (deposito.getBungaPerAnum()/100)*deposito.getNominal()*30/365);
        
        preparedStatement.setDate(7, Date.valueOf(plus));
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
        
    } 
    
}