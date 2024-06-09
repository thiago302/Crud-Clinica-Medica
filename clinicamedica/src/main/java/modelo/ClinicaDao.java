package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class ClinicaDao {
    
    public void cadastra(Clinica aluno) {
        Connection con = Conexao.obterConexao();
        String sql = "INSERT INTO Aluno(nome,pri,seg,ter,qua,media,faturamento,sex) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, aluno.getNome());
            preparador.setDouble(2, aluno.getPrim());
            preparador.setDouble(3, aluno.getSeg());
            preparador.setDouble(4, aluno.getTer());
            preparador.setDouble(5, aluno.getQua());
            preparador.setDouble(6, aluno.getMedia());
            preparador.setDouble(7, aluno.getFaturamento());
            preparador.setDouble(8, aluno.getSex());
            
            preparador.execute();
            preparador.close();
            System.out.println("CLINICA CADASTRADO COM SUCESSO!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Clinica> mostraTodos() {
        Connection con = Conexao.obterConexao();
        List<Clinica> clinicas = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet resultado = preparador.executeQuery();
            
            while (resultado.next()) {
                Clinica clinica = new Clinica();
                clinica.setRa(resultado.getInt("ra"));
                clinica.setNome(resultado.getString("nome"));
                clinica.setPrim(resultado.getDouble("pri"));
                clinica.setSeg(resultado.getDouble("seg"));
                clinica.setTer(resultado.getDouble("ter"));
                clinica.setQua(resultado.getDouble("qua"));
                clinica.setMedia(resultado.getDouble("media"));
                clinica.setFaturamento(resultado.getDouble("faturamento"));
                clinica.setSex(resultado.getDouble("sex"));
                
                clinicas.add(clinica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clinicas;
    }

    public Clinica mostraPorRa(int ra) {
        Connection con = Conexao.obterConexao();
        Clinica clinica = null;
        String sql = "SELECT * FROM Aluno WHERE ra=?";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, ra);
            
            ResultSet resultado = preparador.executeQuery();
            
            if (resultado.next()) {
            	clinica = new Clinica();
            	clinica.setRa(resultado.getInt("ra"));
            	clinica.setNome(resultado.getString("nome"));
            	clinica.setPrim(resultado.getDouble("pri"));
            	clinica.setSeg(resultado.getDouble("seg"));
            	clinica.setTer(resultado.getDouble("ter"));
            	clinica.setQua(resultado.getDouble("qua"));
            	clinica.setMedia(resultado.getDouble("media"));
            	clinica.setFaturamento(resultado.getDouble("faturamento"));
            	clinica.setSex(resultado.getDouble("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clinica;
    }

    public void excluiPorRa(int ra) {
        Connection con = Conexao.obterConexao();
        String sql = "DELETE FROM Aluno WHERE ra=?";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, ra);
            
            preparador.execute();
            preparador.close();
            System.out.println("Clinica Excluído Com Sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void altera(Clinica clinica) {

        Connection con = Conexao.obterConexao();
        String sql = "UPDATE Aluno SET nome=?,pri=?,seg=?,ter=?,qua=?,media=?,faturamento=?,sex=? WHERE ra=?";
        
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, clinica.getNome());
            preparador.setDouble(2, clinica.getPrim());
            preparador.setDouble(3, clinica.getSeg());
            preparador.setDouble(4, clinica.getTer());
            preparador.setDouble(5, clinica.getQua());
            preparador.setDouble(6, clinica.getMedia());
            preparador.setDouble(7, clinica.getFaturamento());
            preparador.setDouble(8, clinica.getSex());
            preparador.setInt(9, clinica.getRa());
            
            preparador.execute();
            preparador.close();
            System.out.println("Clinica Alterado Com Sucesso!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // Método para adicionar uma nova consulta

    public void adicionarConsulta(Consulta consulta) {
        try (Connection con = Conexao.obterConexao()) {
            String sql = "INSERT INTO consulta (nome_paciente, data_consulta, horario_consulta, diagnostico) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, consulta.getNomePaciente());
            stmt.setDate(2, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setString(3, consulta.getHorarioConsulta());
            stmt.setString(4, consulta.getDiagnostico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> mostraTodasConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        try (Connection con = Conexao.obterConexao()) {
            String sql = "SELECT * FROM consulta";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setNomePaciente(rs.getString("nome_paciente"));
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHorarioConsulta(rs.getString("horario_consulta"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
    
    // Método para atualizar uma consulta existente
    public Consulta mostraConsultaPorId(int id) {
        Connection con = Conexao.obterConexao();
        Consulta consulta = null;
        String sql = "SELECT * FROM Consulta WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);

            ResultSet resultado = preparador.executeQuery();

            if (resultado.next()) {
                consulta = new Consulta();
                consulta.setId(resultado.getInt("id"));
                consulta.setNomePaciente(resultado.getString("nome_paciente"));
                consulta.setDataConsulta(resultado.getDate("data_consulta"));
                consulta.setHorarioConsulta(resultado.getString("horario_consulta"));
                consulta.setDiagnostico(resultado.getString("diagnostico"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta;
    }
  
  public void alteraConsulta(Consulta consulta) {
        Connection con = Conexao.obterConexao();
        String sql = "UPDATE Consulta SET nome_paciente = ?, data_consulta = ?, horario_consulta = ? WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, consulta.getNomePaciente());
            preparador.setDate(2, new java.sql.Date(consulta.getDataConsulta().getTime()));
            preparador.setString(3, consulta.getHorarioConsulta());
            preparador.setInt(4, consulta.getId());

            preparador.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir uma consulta existente
    public void excluirConsulta(int idConsulta) {

        Connection con = Conexao.obterConexao();
        String sql = "DELETE FROM Consulta WHERE id=?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, idConsulta);

            preparador.execute();
            preparador.close();
            System.out.println("Consulta excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarDiagnostico(Consulta consulta) {
        try (Connection con = Conexao.obterConexao()) {
            String sql = "INSERT INTO consulta (nome_paciente, data_consulta, horario_consulta, sintomas, diagnostico) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, consulta.getNomePaciente());
            stmt.setDate(2, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setString(3, consulta.getHorarioConsulta());
            stmt.setString(4, consulta.getDiagnostico());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}














