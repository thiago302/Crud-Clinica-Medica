package teste;

import modelo.Clinica;
import modelo.ClinicaDao;

public class TesteCadastro {

	public static void main(String[] args) {
		
		Clinica aluno = new Clinica("Suzana Vieira",3,2,1,3,4);
		
		ClinicaDao alunoDao = new ClinicaDao();
		alunoDao.cadastra(aluno);

	}

}
