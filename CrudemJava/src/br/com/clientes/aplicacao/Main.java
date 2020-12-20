package br.com.clientes.aplicacao;

import java.sql.SQLException;

import com.mysql.jdbc.UpdatableResultSet;

import br.com.clientes.dao.ContatoDAO;
import br.com.clientes.model.contato.Contato;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Perola");
		contato.setInscricao(27);
		contato.setEmail("perola@host.com.br");
		
		contatoDao.save(contato);
		
		for(Contato c : contatoDao.getContatos())
			System.out.println("Contato: "+c.getNome());
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		contato.setId(4);
		contato.setNome("Lucas Porto");
		contato.setInscricao(101);
		contato.setEmail("lporto@host.com.br");
		
		ContatoDAO dao=new  ContatoDAO();
		
		dao.update(contato);
		System.out.println("Dados alterados com sucesso!");
		
		ContatoDAO contatoDAO1 = new ContatoDAO();
		
		contato.setId(30);
		
		ContatoDAO dao1=new ContatoDAO();
		
		dao.apaga(contato);
		System.out.println("Contato deletado com sucesso!");
	}   
        }
        	
        