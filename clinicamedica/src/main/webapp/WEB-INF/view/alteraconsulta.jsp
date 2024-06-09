<%@page import="modelo.Consulta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração Consulta</title>
</head>
<body>

    <h1>Alteração Consulta</h1>
    
    <form action="chamadaservlet" method="post">
        Id: <input type="text" name="id" value="${consulta.id }" readonly><br><br>
        Nome do Paciente: <input type="text" name="nomePaciente" value="${consulta.nomePaciente }"><br><br>
        Data da Consulta: <input type="date" name="dataConsulta" value="${consulta.dataConsulta }"><br><br>
        Horário da Consulta: <input type="time" name="horarioConsulta" value="${consulta.horarioConsulta }"><br><br>
        <input type="hidden" name="acao" value="alteraconsulta">
        <input type="submit" value="Alterar">
    </form>
    
</body>
</html>
