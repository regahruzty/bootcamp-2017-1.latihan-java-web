/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.controller;

import com.gmail.regahruzty.dao.DepositoDao;
import com.gmail.regahruzty.dao.RegistrasiDao;
import com.gmail.regahruzty.model.Deposito;
import com.gmail.regahruzty.model.Registrasi;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet (urlPatterns = {"/deposito/proses"})
public class DepositoAddController extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
            
            
            RegistrasiDao registrasiDao = new RegistrasiDao();
            List<Registrasi> listRegister = registrasiDao.semuaDataRegistrasi();
            req.setAttribute("listRegister", listRegister);
            
            
            req.getRequestDispatcher("/pages/deposito/addDeposito.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(DepositoAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    
        
        
        Registrasi registrasi = new Registrasi();
        Deposito deposito = new Deposito();
               
        deposito.setJangkaWaktu(Integer.valueOf(req.getParameter("jangkaWaktu")));
        deposito.setPerpanjangOtomatis(Boolean.valueOf(req.getParameter("perpanjangOtomatis")));
        deposito.setNominal(Integer.valueOf(req.getParameter("nominal")));
        deposito.setBungaPerAnum(Float.valueOf(req.getParameter("bungaPerAnum")));
        
        registrasi.setNomorRegister(Integer.valueOf(req.getParameter("nomorRegister")));
        deposito.setNomorRegister(registrasi);
        
        DepositoDao depositoDao = new DepositoDao();
        try {
            depositoDao.save(deposito);
        } catch (SQLException ex) {
            Logger.getLogger(DepositoAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/deposito/list");

        
    }
    
        
}
