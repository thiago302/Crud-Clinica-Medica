package teste;

import modelo.ClinicaDao;

public class TesteExcluiPorId {

	public static void main(String[] args) {
		
		
		ClinicaDao clinicaDao = new ClinicaDao();
		clinicaDao.excluirConsulta(10);
		

	}

}