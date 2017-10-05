/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.controller;

import com.gmail.regahruzty.dao.DepositoDao;
import com.gmail.regahruzty.model.Deposito;
import java.io.IOException;
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

@WebServlet (urlPatterns = {"/deposito/kartu"})
public class DepositoKartuController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
            
            DepositoDao depositoDao = new DepositoDao();
            List<Deposito> listDeposito = depositoDao.semuaDataDeposito();
            req.setAttribute("listDeposito", listDeposito);
            req.getRequestDispatcher("/pages/deposito/index.jsp").forward(req, resp);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DepositoKartuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
           
    
}
