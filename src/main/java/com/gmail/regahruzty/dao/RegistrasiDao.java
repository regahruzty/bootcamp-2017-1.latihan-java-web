/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.dao;

/**
 *
 * @author Diani
 */
import com.gmail.regahruzty.configuration.KonfigurasiDB;
import com.gmail.regahruzty.model.Registrasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RegistrasiDao {

    public List<Registrasi> semuaDataRegistrasi() throws SQLException {
        List<Registrasi> listRegistrasi = new ArrayList<>();
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "select nomor_register, nama_nasabah, jenis_kelamin from latihan_2.registrasi_view3 order by nomor_register";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Registrasi registrasi = new Registrasi();
            registrasi.setNomorRegister(resultSet.getInt("nomor_register"));
            registrasi.setNamaNasabah(resultSet.getString("nama_nasabah"));
            registrasi.setJenisKelamin(resultSet.getString("jenis_kelamin"));
            listRegistrasi.add(registrasi);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listRegistrasi;
    }
    
    public Integer dataNomorRegister() throws SQLException {
        Integer value = 0;
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "select nextval('latihan_2.registrasi_nomor_register_seq')";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            value = resultSet.getInt(1);
    }
        resultSet.close();
        statement.close();
        connection.close();
        return value;
    }
    
    public void save(Registrasi registrasi) throws SQLException {
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "insert into latihan_2.registrasi(nomor_register, nama_nasabah, jenis_kelamin) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, registrasi.getNomorRegister());
        preparedStatement.setString(2, registrasi.getNamaNasabah());
        preparedStatement.setString(3, registrasi.getJenisKelamin());
        preparedStatement.executeUpdate();
        
        
        
        preparedStatement.close();
        connection.close();
                
        
    }

    public Registrasi cariRegisterDenganNomorRegister(Integer nomorRegister) throws SQLException {
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "select * from latihan_2.registrasi where nomor_register = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, nomorRegister);
        ResultSet resultSet = preparedStatement.executeQuery();
        Registrasi registrasi = new Registrasi();
        if(resultSet.next()) {
            registrasi.setNomorRegister(resultSet.getInt("nomor_register"));
            registrasi.setNamaNasabah(resultSet.getString("nama_nasabah"));
            registrasi.setJenisKelamin(resultSet.getString("jenis_kelamin"));
        }
        return registrasi;
    }

    public void update(Registrasi registrasi) throws SQLException {

        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "update latihan_2.registrasi set nama_nasabah = ?, jenis_kelamin = ? where nomor_register = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, registrasi.getNamaNasabah());
        preparedStatement.setString(2, registrasi.getJenisKelamin());
        preparedStatement.setInt(3, registrasi.getNomorRegister());
        
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
        
    }

}

    
    
    

