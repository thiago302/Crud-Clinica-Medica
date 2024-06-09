<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mostra Consulta</title>
</head>
<body>
    <h1>Consulta Marcada</h1>

    <c:if test="${not empty consultas}">
        <table border="1" style="width: 90%">
            <thead>
                <tr style="color: white; background-color: black">
                    <th>ID</th>
                    <th>Nome do Paciente</th>
                    <th>Data</th>
                    <th>Hora</th>
                    <th>Diagnóstico</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="consulta" items="${consultas}">
                    <tr>
                        <td>${consulta.id}</td>
                        <td>${consulta.nomePaciente}</td>
                        <td>${consulta.dataConsulta}</td>
                        <td>${consulta.horarioConsulta}</td>
                        <td>${consulta.diagnostico}</td>
                        <td><a href="chamadaservlet?acao=alteraconsulta&id=${consulta.id}">ALTERAR</a></td>
                        <td><a href="chamadaservlet?acao=excluiConsulta&id=${consulta.id}">EXCLUIR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty consultas}">
        <h1>Nenhuma Consulta Marcada!!!</h1>
    </c:if>
</body>
</html>

