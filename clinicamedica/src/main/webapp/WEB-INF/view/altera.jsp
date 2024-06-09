<%@page import="modelo.Clinica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração Dados Clinica</title>
</head>
<body>

    <h1>Alteração Dados Clinica</h1>
    
    <form action="chamadaservlet" method="post">
        Id: <input type="text" name="txtra" value="${clinica.ra }" readonly><br><br>
        Nome: <input type="text" name="txtnome" value="${clinica.nome }"><br><br>
        Seg: <input type="text" name="txtpri" value="${clinica.prim }"><br><br>
        Ter: <input type="text" name="txtseg" value="${clinica.seg }"><br><br>
        Qua: <input type="text" name="txtter" value="${clinica.ter }"><br><br>
        Qui: <input type="text" name="txtqua" value="${clinica.qua }"><br><br>
        Sex: <input type="text" name="txtsex" value="${clinica.sex }"><br><br>
        Média: <input type="text" name="txtmedia" value="${clinica.media }" readonly><br><br>
        Faturamento: <input type="text" name="txtstatus" value="${clinica.faturamento }" readonly>
        <input type="hidden" name="acao" value="altera">
        <input type="submit" value="Alterar">
    </form>
    
</body>
</html>







