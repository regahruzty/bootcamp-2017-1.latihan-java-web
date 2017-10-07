<%-- 
    Document   : kartuDeposito
    Created on : Oct 4, 2017, 5:44:30 PM
    Author     : Diani
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kartu Deposito</h1>
        <form action="${pageContext.servletContext.contextPath}/deposito/kartu" method="post">
            <input type="hidden" name="id" value="${d.id}"/>

           

                <div>
                    <label for="nomorRekening">Nomor Rekening : DEP<fmt:formatNumber type="number" minIntegerDigits="3" value="${d.nomorRegister.nomorRegister}"/></label>
                </div>    
                <div>
                    <label for="tanggalBuat">Tanggal Buat : ${d.tanggalBuat}</label>
                </div>    
                <div>
                    <label for="nomorRegisterNasabah">Nomor Register Nasabah : <fmt:formatNumber type="number" minIntegerDigits="3" value="${d.nomorRegister.nomorRegister}"/> a/n ${d.nomorRegister.namaNasabah}</label>
                </div>    
                <div>
                    <label for="jenisKelamin">Jenis Kelamin : ${d.nomorRegister.jenisKelamin}</label>
                </div>    
                <div>
                    <label for="jangkaWaktu">Jangka Waktu : ${d.jangkaWaktu} Bulan</label>
                </div>    
                <div>
                    <label for="nominal">Nominal : <fmt:formatNumber type="currency" minIntegerDigits="3" value="${d.nominal}"/></label>
                </div>    
                <table border="4">
                    <thead>
                        <tr>
                            <th>Bulan Ke</th>
                            <th>Bunga Bulanan</th>
                            <th>Jatuh Tempo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listKartu}" begin="1" end="${d.jangkaWaktu}" var="k">
                            <tr>
                                <td>${k.bulanke}</td>
                                <td>${k.bungaBulanan}</td>
                                <td>${k.jatuhTempo}</td>
                            </tr>
                         </c:forEach>    

                        </tbody>
                    </table>
                   <form action="${pageContext.servletContext.contextPath}/deposito/proses" method="post">
                    <button type="submit">Kembali</button> 

                </form>

        </body>
    </html>

