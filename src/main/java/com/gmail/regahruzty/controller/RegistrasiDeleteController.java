/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.controller;

import com.gmail.regahruzty.dao.RegistrasiDao;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/registrasi/delete"})
public class RegistrasiDeleteController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        try {
        Integer noRegister = Integer.valueOf(req.getParameter("nomorRegister"));
        RegistrasiDao registrasiDao = new RegistrasiDao();
            registrasiDao.hapusRegistrasiByNomorRegistrasi(noRegister);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrasiDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/registrasi/list");
    }
    
    
    
}
