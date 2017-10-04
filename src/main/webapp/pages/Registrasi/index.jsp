<%-- 
    Document   : Index
    Created on : Oct 3, 2017, 10:54:12 AM
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
        <h1>Daftar Nasabah</h1>
        <table border="3">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nomor Registrasi</th>
                    <th>Nama Nasabah</th>
                    <th>Jenis Kelamin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRegistrasi}" var="a" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td><fmt:formatNumber type="number" minIntegerDigits="3" value="${a.nomorRegister}"/></td>
                        <td>${a.namaNasabah}</td>
                        <td>${a.jenisKelamin}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>    
    </body>
</html>
