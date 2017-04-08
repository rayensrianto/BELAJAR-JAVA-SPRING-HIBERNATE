<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tampil</title>
        <style type="text/css">
            .even {
                background-color: orange    ;
            }
        </style>
    </head>
    <body>
        <h1>Data Dvd</h1>
        <h3> <a href="nameView.htm">Tambah DVD</a> </h3>
        <br>
        
        <table>
            <tr>
                <td>Kode Dvd</td>
                <td>Nama Dvd</td>
                <td>Jenis Dvd</td>
                <td>Harga</td>
                <td>Keterangan</td>
            </tr>
            <c:forEach items="${dataDvd}" var="dvd" varStatus="status">
                <tr class="<c:if test="${status.count % 2==0}">even</c:if>"> 
                    <td><c:out value="${dvd.kdDvd}"></c:out></td>
                    <td><c:out value="${dvd.namaDvd}"></c:out></td>
                    <td><c:out value="${dvd.jenisDvd}"></c:out></td>
                    <td><c:out value="${dvd.harga}"></c:out></td>
                    <td> 
                        <a href="FormEdit.htm?kode=${dvd.kdDvd}">Edit</a>
                        <a href="delete.htm?kode=${dvd.kdDvd}">Hapus</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
