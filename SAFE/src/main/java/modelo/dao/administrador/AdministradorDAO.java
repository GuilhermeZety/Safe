package modelo.dao.administrador;

import java.util.List;

import modelo.entidade.administrador.Administrador;

public interface AdministradorDAO {

	void inserirAdministrador(Administrador admin);
	
	void atualizarAdministrador(Administrador admin);
	
	void deletarAdministrador(Administrador admin);
	
	List<Administrador> recuperarAdministradores();
	
	Administrador recuperarAdministradorPeloId(Administrador admin);
	
	Administrador recuperarAdministradorPeloCpf(Administrador admin);
}
