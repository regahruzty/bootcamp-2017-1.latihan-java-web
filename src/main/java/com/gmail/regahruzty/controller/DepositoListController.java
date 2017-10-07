/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.controller;

import com.gmail.regahruzty.dao.DepositoDao;
import com.gmail.regahruzty.dao.KartuDao;
import com.gmail.regahruzty.model.Deposito;
import com.gmail.regahruzty.model.Kartu;
import com.gmail.regahruzty.model.Registrasi;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/deposito/list"})
public class DepositoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

            DepositoDao depositoDao = new DepositoDao();

            List<Deposito> listDeposito = depositoDao.semuaDataDeposito();

            req.setAttribute("listDeposito", listDeposito);
            req.getRequestDispatcher("/pages/deposito/index.jsp").forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(DepositoListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
            
            Deposito deposito = new Deposito();
            KartuDao kartuDao = new KartuDao();
            String depString = req.getParameter("id");
            deposito.setId(Integer.valueOf(depString));
            
            String registrasi = req.getParameter("nomorRegister");
            Registrasi registrasi1 = new Registrasi();
            registrasi1.setNomorRegister(Integer.valueOf(registrasi));
            deposito.setNomorRegister(registrasi1);
            
            Kartu kartu = new Kartu();
            kartu.setBulanKe(Integer.valueOf(req.getParameter("bulanKe")));
            kartu.setBungaBulanan(Float.valueOf(req.getParameter("bungaBulanan")));
            kartu.setJatuhTempo(Date.valueOf(req.getParameter("jatuhTempo")));
            kartuDao.save(kartu);
        } catch (SQLException ex) {
            Logger.getLogger(DepositoListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
