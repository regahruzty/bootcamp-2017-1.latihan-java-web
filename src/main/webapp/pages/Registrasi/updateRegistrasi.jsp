<%-- 
    Document   : updateRegistrasi
    Created on : Oct 3, 2017, 10:54:41 AM
    Author     : Diani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Form Registrasi</h1>
        <form action="${pageContext.servletContext.contextPath}/registrasi/update" method="post">

            <input type="hidden" name="nomorRegister" value="${s.nomorRegister}"/>
            <div>
                <label for="nomorRegister">Nomor Register</label>
                <input type="text" name="nomorRegister" value="${s.nomorRegister}" readonly="readonly"/>        
            </div>


            <div>
                <label for="namaNasabah">Nama Nasabah</label>
                <input type="text" name="namaNasabah" value="${s.namaNasabah}"/>
            </div>
            <div>
                <label for="jenisKelamin">Jenis Kelamin</label>
                <input type="radio" name="jenisKelamin" value="Laki-Laki">Laki-Laki
                <input type="radio" name="jenisKelamin" value="Perempuan">Perempuan
            </div>
            <div>
                <button type="submit">Update</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
