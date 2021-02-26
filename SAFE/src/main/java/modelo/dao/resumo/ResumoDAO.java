package modelo.dao.resumo;

import java.util.List;

import modelo.entidade.resumo.Resumo;

public interface ResumoDAO {

	void inserirResumo(Resumo resumo);
	
	void atualizarResumo(Resumo resumo);
	
	void deletarResumo(Resumo resumo);
	
	List<Resumo> recuperarResumos();
	
	Resumo recuperarResumoPeloId(Resumo resumo);
}
