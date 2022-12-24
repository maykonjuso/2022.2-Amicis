package br.com.amicis.main;

import java.util.Date;

import br.com.amicis.dao.PerfilDAO;
import br.com.amicis.model.Perfil;

public class Main {

	public static void main(String[] args) {
		Perfil perfil = new Perfil();
		PerfilDAO perfilDAO = new PerfilDAO();
		
		perfil.setNome("maykon");
		perfil.setUsuario("maiiko_n");
		perfil.setMelhorAmigo(false);
		perfil.setDataNascimento(new Date());
		perfil.setDataIngresso(new Date());
		
		perfilDAO.save(perfil);
	}
}
