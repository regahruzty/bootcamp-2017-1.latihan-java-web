<%-- 
    Document   : addRegistrasi
    Created on : Oct 3, 2017, 10:54:22 AM
    Author     : Diani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/registrasi" method="post">
            <div>
                <label for="nomorRegister">Nomor Register</label>
                <input type="text" name="nomorRegister" id="nomorRegister" disabled="${registrasi.nomorRegister}">
            </div>
            <div>
                <label for="namaNasabah">Nama Nasabah</label>
                <input type="text" name="namaNasabah" id="namaNasabah"
            </div>
            <div>
                <label for="jenisKelamin">Jenis Kelamin</label>
                <input type="radio" name="jenisKelamin" value="Laki-Laki"/>Laki-Laki
                <input type="radio" name="jenisKelamin" value="Perempuan"/>Perempuan
            </div>
            <button type="submit">Simpan</button>
            <button type="reset">Reset</button>        
        </form>    
    </body>
</html>
