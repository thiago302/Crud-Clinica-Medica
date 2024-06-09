<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Mostra Alunos e Consultas</title>
</head>
<body>
   <h1>Clínicas cadastradas</h1>
   <a href="http://localhost:8080/clinicamedica/chamadaservlet?acao=cadastro"><button>Cadastrar Clínica</button></a>
   <br><br>
   <c:if test="${not empty clinicas}">
       <table border="1" style="width: 90%">
           <thead>
               <tr style="color: white; background-color: black">
                   <th>ID</th>
                   <th>Nome da clínica</th>
                   <th>Seg</th>
                   <th>Ter</th>
                   <th>Qua</th>
                   <th>Qui</th>
                   <th>Sex</th>
                   <th>Taxa de Ocupação</th>
                   <th>Faturamento</th>
                   <th colspan="2">Ação</th>
               </tr>
           </thead>
           <tbody>
               <c:forEach var="clinica" items="${clinicas}">
                   <tr>
                       <td>${clinica.ra}</td>
                       <td>${clinica.nome}</td>
                       <td>${clinica.prim}</td>
                       <td>${clinica.seg}</td>
                       <td>${clinica.ter}</td>
                       <td>${clinica.qua}</td>
                       <td>${clinica.sex}</td>
                       <td>${clinica.media}</td>
                       <td>${clinica.faturamento}</td>
                       <td><a href="chamadaservlet?acao=altera&ra=${clinica.ra}">ALTERAR</a></td>
                       <td><a href="chamadaservlet?acao=excluiClinica&ra=${clinica.ra}">EXCLUIR</a></td>
                   </tr>
               </c:forEach>
           </tbody>
       </table>
   </c:if>
   <c:if test="${empty clinicas}">
       <h1>Nenhuma Clínica Cadastrada!!!</h1>
   </c:if>
   <br><br><br><br>
   <h1>Marcar Consulta</h1>
   <a href="http://localhost:8080/clinicamedica/chamadaservlet?acao=cadastro"><button>Marcar Consulta</button></a>
   <br><br>
  
  
</body>
</html>









