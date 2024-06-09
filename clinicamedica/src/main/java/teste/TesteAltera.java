package teste;

import modelo.Clinica;
import modelo.ClinicaDao;

public class TesteAltera {

	public static void main(String[] args) {
		
		Clinica aluno = new Clinica(3,"Ilma Santos",6.0,7.0,5.0,5.0,6.0);
		
		ClinicaDao alunoDao = new ClinicaDao();
		alunoDao.altera(aluno);

	}

}
