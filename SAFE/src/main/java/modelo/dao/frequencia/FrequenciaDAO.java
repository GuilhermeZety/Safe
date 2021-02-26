package modelo.dao.frequencia;

import java.util.List;

import modelo.entidade.frequencia.Frequencia;

public interface FrequenciaDAO {

void inserirFrequencia(Frequencia frequencia);
	
	void atualizarFrequencia(Frequencia frequencia);
	
	void deletarFrequencia(Frequencia frequencia);
	
	List<Frequencia> recuperarFrequencias();
	
	Frequencia recuperarFrequenciaPeloId(Frequencia frequencia);
	
}
