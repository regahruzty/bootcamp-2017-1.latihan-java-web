<%-- 
    Document   : addDeposito
    Created on : Oct 4, 2017, 5:35:10 PM
    Author     : Diani
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/deposito/proses" method="post">
            <div>
                <label for="nomorRegister">Nomor Register Nasabah</label>
                <select name="nomorRegister" id="nomorRegister">
                    <c:forEach items="${listRegister}" var="p">
                        <option value="${p.nomorRegister}">${p.nomorRegister}││${p.namaNasabah}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for ="jangkaWaktu">Jangka Waktu</label>
                <input type="radio" name="jangkaWaktu" value="3" id="jangkaWaktu1"> 3 Bulan
                <input type="radio" name="jangkaWaktu" value="6" id="jangkaWaktu2"> 6 Bulan
                <input type="radio" name="jangkaWaktu" value="9" id="jangkaWaktu3"> 9 Bulan
            </div>
            <div>
                <label for="perpanjangOtomatis">Perpanjang Otomatis</label>
                <input type="checkbox" name="perpanjangOtomatis" value="true" id="perpanjangOtomatis"> Automatic Rollover
            </div>
            <div>
                <label for="nominal">Nominal</label>
                <input type="text" name="nominal" id="nominal">
            </div>
            <div>
                <label for ="bungaPerAnum">Bunga per Anum</label>
                <input type="text" name="bungaPerAnum" id="bungaPerAnum">
            <button type="submit">Simpan</button>
            
        </form>    
    </body>
</html>
