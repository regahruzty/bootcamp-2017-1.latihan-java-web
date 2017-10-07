/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.dao;

import com.gmail.regahruzty.configuration.KonfigurasiDB;
import com.gmail.regahruzty.model.Deposito;
import com.gmail.regahruzty.model.Kartu;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diani
 */
public class KartuDao {
    
    public List<Kartu> semuaDataKartu() throws SQLException {
       List<Kartu> listKartu = new ArrayList<>();
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "select * from latihan_2.kartu order by id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Kartu kartu = new Kartu();
            kartu.setBulanKe(Integer.valueOf("bulan_ke"));
            kartu.setBungaBulanan(Float.valueOf("bunga_bulanan"));
            kartu.setJatuhTempo(Date.valueOf("bulan_ke"));
            listKartu.add(kartu);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listKartu;
    }
    
    public void save(Kartu kartu) throws SQLException {
        
        Deposito deposito = new Deposito();
        
        Connection connection = KonfigurasiDB.getDataSource().getConnection();
        String sql = "insert into latihan_2.kartu (bulan_ke, bunga_bulanan, jatuh_tempo) values (?, ?, ?) where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, deposito.getJangkaWaktu());
        preparedStatement.setFloat(2, deposito.getBungaBulanan()/12);
        preparedStatement.setDate(3, Date.valueOf(deposito.getJatuhTempo()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
    }
    
}