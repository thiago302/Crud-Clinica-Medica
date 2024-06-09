package teste;

import java.util.List;

import modelo.Clinica;
import modelo.ClinicaDao;

public class TesteMostraTodosAlunos {

	public static void main(String[] args) {
		
		ClinicaDao alunoDao = new ClinicaDao();
		List<Clinica> alunos = alunoDao.mostraTodos();
		
		for(Clinica aluno:alunos) {
			System.out.println("RA: " + aluno.getRa());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("1º Bimestre: " + aluno.getPrim());
			System.out.println("2º Bimestre: " + aluno.getSeg());
			System.out.println("3º Bimestre: " + aluno.getTer());
			System.out.println("4º Bimestre: " + aluno.getQua());
			System.out.println("Média: " + aluno.getMedia());
			System.out.println("Faturamento: " + aluno.getFaturamento());
			System.out.println();
		}
		

	}

}
