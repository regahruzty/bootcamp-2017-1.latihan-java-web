/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.regahruzty.controller;

/**
 *
 * @author Diani
 */
import com.gmail.regahruzty.dao.RegistrasiDao;
import com.gmail.regahruzty.model.Registrasi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/registrasi/addnasabah", "/registrasi/proses"})
public class RegistrasiAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

            RegistrasiDao registrasiDao = new RegistrasiDao();
            Integer dataNomorRegister = registrasiDao.dataNomorRegister();
            req.setAttribute("dataNomorRegister", dataNomorRegister);

            req.getRequestDispatcher("/pages/registrasi/addRegistrasi.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrasiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Registrasi registrasi = new Registrasi();
        registrasi.setNomorRegister(Integer.valueOf(req.getParameter("dataNomorRegister")));
        registrasi.setNamaNasabah(req.getParameter("namaNasabah"));
        registrasi.setJenisKelamin(req.getParameter("jenisKelamin"));

        RegistrasiDao registrasiDao = new RegistrasiDao();
        try {
            registrasiDao.save(registrasi);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrasiAddController.class.getName()).log(Level.SEVERE, null, ex);
        }

        resp.sendRedirect(req.getServletContext().getContextPath() + "/registrasi/list");

        System.out.println("nomor registrasi: " + registrasi.getNomorRegister() + " ,nama nasabah: " + registrasi.getNamaNasabah() + " ,jenis kelamin: " + registrasi.getJenisKelamin());
    }

}
