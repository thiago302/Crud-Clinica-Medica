package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Clinica;
import modelo.ClinicaDao;
import modelo.Consulta;

@WebServlet("/chamadaservlet")
public class MeuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao.equals("cadastro")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastro.html");
            rd.forward(request, response);
        } else if (acao.equals("mostratodos")) {
            ClinicaDao clinicaDao = new ClinicaDao();
            List<Clinica> clinicas = clinicaDao.mostraTodos();
            request.setAttribute("clinicas", clinicas);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
            rd.forward(request, response);
        } else if (acao.equals("mostraconsulta")) {
            ClinicaDao clinicaDao = new ClinicaDao();
            List<Consulta> consultas = clinicaDao.mostraTodasConsultas();
            request.setAttribute("consultas", consultas);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostraconsulta.jsp");
            rd.forward(request, response);
        } else if (acao.equals("excluiClinica")) {  // Nome da ação ajustado
            int ra = Integer.parseInt(request.getParameter("ra"));
            ClinicaDao clinicaDao = new ClinicaDao();
            clinicaDao.excluiPorRa(ra);
            response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostratodos");
        } else if (acao.equals("altera")) {
            int ra = Integer.parseInt(request.getParameter("ra"));
            ClinicaDao clinicaDao = new ClinicaDao();
            Clinica clinica = clinicaDao.mostraPorRa(ra);
            request.setAttribute("clinica", clinica);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/altera.jsp");
            rd.forward(request, response);
        } else if (acao.equals("alteraconsulta")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ClinicaDao clinicaDao = new ClinicaDao();
            Consulta consulta = clinicaDao.mostraConsultaPorId(id);
            request.setAttribute("consulta", consulta);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alteraconsulta.jsp");
            rd.forward(request, response);
        } else if (acao.equals("excluiConsulta")) {  // Nome da ação ajustado
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                ClinicaDao clinicaDao = new ClinicaDao();
                clinicaDao.excluirConsulta(id);
                response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostraconsulta");
            } else {
                System.out.println("erro: id não fornecido ou vazio.");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao.equals("cadastro")) {
            String nome = request.getParameter("txtnome");
            double pri = Double.parseDouble(request.getParameter("txtpri"));
            double seg = Double.parseDouble(request.getParameter("txtseg"));
            double ter = Double.parseDouble(request.getParameter("txtter"));
            double qua = Double.parseDouble(request.getParameter("txtqua"));
            double sex = Double.parseDouble(request.getParameter("txtsex"));

            Clinica clinica = new Clinica(nome, pri, seg, ter, qua, sex);

            ClinicaDao clinicaDao = new ClinicaDao();
            clinicaDao.cadastra(clinica);

            response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostratodos");
        } else if (acao.equals("altera")) {
            int ra = Integer.parseInt(request.getParameter("txtra"));
            String nome = request.getParameter("txtnome");
            double pri = Double.parseDouble(request.getParameter("txtpri"));
            double seg = Double.parseDouble(request.getParameter("txtseg"));
            double ter = Double.parseDouble(request.getParameter("txtter"));
            double qua = Double.parseDouble(request.getParameter("txtqua"));
            double sex = Double.parseDouble(request.getParameter("txtsex"));

            Clinica clinica = new Clinica(ra, nome, pri, seg, ter, qua, sex);

            ClinicaDao clinicaDao = new ClinicaDao();
            clinicaDao.altera(clinica);

            response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostratodos");
        } else if (acao.equals("marcarconsulta")) {
            String nomePaciente = request.getParameter("nomePaciente");
            String dataConsultaStr = request.getParameter("dataConsulta");
            String horarioConsulta = request.getParameter("horarioConsulta");
            int gravidade = Integer.parseInt(request.getParameter("gravidade")); 
            String diagnostico = processarDiagnostico(gravidade);
            // Nova linha para obter a gravidade
            // Processar diagnóstico com base na gravidade
            
            Date dataConsulta = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dataConsulta = sdf.parse(dataConsultaStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Consulta consulta = new Consulta();
            consulta.setNomePaciente(nomePaciente);
            consulta.setDataConsulta(dataConsulta);
            consulta.setHorarioConsulta(horarioConsulta);
            consulta.setDiagnostico(diagnostico);
            ClinicaDao clinicaDao = new ClinicaDao();
            clinicaDao.adicionarConsulta(consulta);
         // Enviar diagnóstico para a página JSP
            request.setAttribute("diagnostico", diagnostico);

            response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostraconsulta");
        } else if (acao.equals("alteraconsulta")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nomePaciente = request.getParameter("nomePaciente");
            String dataConsultaStr = request.getParameter("dataConsulta");
            String horarioConsulta = request.getParameter("horarioConsulta");
            Date dataConsulta = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dataConsulta = sdf.parse(dataConsultaStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Consulta consulta = new Consulta();
            consulta.setId(id);
            consulta.setNomePaciente(nomePaciente);
            consulta.setDataConsulta(dataConsulta);
            consulta.setHorarioConsulta(horarioConsulta);
            ClinicaDao clinicaDao = new ClinicaDao();
            clinicaDao.alteraConsulta(consulta);
            response.sendRedirect("http://localhost:8080/clinicamedica/chamadaservlet?acao=mostraconsulta");
        }
        
    }private String processarDiagnostico(int gravidade) {
        String diagnosticoText = "";
        switch (gravidade) {
            case 1:
                diagnosticoText = "Tomar medicamento";
                break;
            case 2:
                diagnosticoText = "Fazer exames periodicamente e tomar medicamento";
                break;
            case 3:
                diagnosticoText = "Internação e tratamento específico";
                break;
           
            default:
                diagnosticoText = "Diagnóstico indeterminado";
                break;
        }
        return diagnosticoText;
    }
    
}






