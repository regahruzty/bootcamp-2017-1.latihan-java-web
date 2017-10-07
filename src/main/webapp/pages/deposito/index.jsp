<%-- 
    Document   : index
    Created on : Oct 4, 2017, 5:44:05 PM
    Author     : Diani
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Deposito</h1>
        <a href="${pageContext.servletContext.contextPath}/deposito/proses" style="color: yellowgreen" style="">Tambah</a>
        <table border="3">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nomor Registrasi Nasabah</th>
                    <th>Nama Nasabah</th>
                    <th>Jenis Kelamin</th>
                    <th>Jangka Waktu</th>
                    <th>Perpanjang Otomatis</th>
                    <th>Nominal</th>
                    <th>Bunga per Anum</th>
                    <th>Bunga Bulanan</th>
                    <th>Tanggal Buat</th>
                    <th>Jatuh Tempo</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDeposito}" var="d" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${d.nomorRegister.nomorRegister}</td>
                        <td>${d.nomorRegister.namaNasabah}</td>
                        <td>${d.nomorRegister.jenisKelamin}</td>
                        <td>${d.jangkaWaktu}</td>
                        <td>${d.perpanjangOtomatis}</td>
                        <td>${d.nominal}</td>
                        <td>${d.bungaPerAnum}</td>
                        <td>${d.bungaBulanan}</td>
                        <td>${d.tanggalBuat}</td>
                        <td>${d.jatuhTempo}</td>
                        <td> 
                            <a href="${pageContext.servletContext.contextPath}/deposito/kartu?id=${d.id}">Detail Kartu</a>
                        </td>
                        <td><button type="submit">Detail Kartu</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>    
    </body>
</html>
