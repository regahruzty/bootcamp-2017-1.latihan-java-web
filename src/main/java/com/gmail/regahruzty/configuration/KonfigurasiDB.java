/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.configuration;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Diani
 */
public class KonfigurasiDB {
    
    private final static String url= "jdbc:postgresql://localhost:5433/postgres";
    private final static String username= "postgres";
    private final static String password= "postgres";
    
    public static DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    public static void main(String[] args) throws SQLException{
        KonfigurasiDB.getDataSource().getConnection();
    }
}
