package br.com.clientes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.clientes.factory.ConnectionFactory;
import br.com.clientes.model.contato.*;

public class ContatoDAO {
	
	private static final String Nome = null;
	private static final int Inscricao = 0;
	private static final String Email = null;
	private static final int Id = 0;

	public static void save(Contato contato) {
		
		//método para inserir cliente
		String sql = "INSERT INTO Contato(Nome, Inscricao, Email) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getInscricao());
			pstm.setString(3, contato.getEmail());
			
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try { 
				if(pstm!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public List<Contato> getContatos() {
    	
    	//método para visualiar clientes
    	String sql = "SELECT * FROM contato";
    	
    	List<Contato> contatos = new ArrayList<Contato>();
    	
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	
    	ResultSet rset = null;
    	
    	try { 
    		conn = ConnectionFactory.createConnectionToMySQL();
    		
    		pstm = (PreparedStatement) conn.prepareStatement(sql);
    		
    		rset = pstm.executeQuery();
    		
    		while (rset.next()) {
    			Contato contato = new Contato();
    			
    			contato.setId(rset.getInt("Id"));
    			
    			contato.setNome(rset.getString("Nome"));
    			
    			contato.setInscricao(rset.getInt("Inscricao"));
    			
    			contato.setEmail(rset.getString("Email"));
    			
    			contatos.add(contato);
    		}
    		
    		}catch (Exception e) {
    			e.printStackTrace();
    		}finally {
    				try {
    					if(rset!=null) {
    						rset.close();
    					}
    					
    					if(pstm!=null) {
    						pstm.close();
    					}
    					
    					if(conn!=null) {
    						conn.close();
    				}
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    	
    		return contatos;
    	
    }
	
    //método para alterar dados do usuário
    
    public void update(Contato contato) throws SQLException {
    	
    	String sql = "UPDATE contato SET Nome=?,Inscricao=?,Email=? where id=?";
    	
    	Connection conn = null; 
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	
    	try {
    		conn = ConnectionFactory.createConnectionToMySQL();
    		
    		pstm = (PreparedStatement) conn.prepareStatement(sql);
    		pstm.setInt(1, contato.getId());
    		pstm.setString(2, contato.getNome());
    		pstm.setInt(3, contato.getInscricao());
    		pstm.setString(4, contato.getEmail());
    		
    		int rows = pstm.executeUpdate();
    		
    		if (rows > 0) {
    		System.out.println("Dados alterados com sucesso!");
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		
    		try { 
    			if(pstm!=null) {
    				pstm.close(); }
    
    		}finally {
    			
    		}
    		}
    			
    		}
  //Método para deletar usuário
    		public  void apaga(Contato contato) throws SQLException{
    			
    			String sql = "Delete contato where Id=?";
    			
    			Connection conn = null; 
    			PreparedStatement pstm = null;
    			ResultSet rset = null;
    			
    			try {
    				conn = ConnectionFactory.createConnectionToMySQL();
    				
    				pstm = (PreparedStatement) conn.prepareStatement(sql);
    				pstm.setInt(1, contato.getId());
    				
    			}catch (Exception e) {
    				e.printStackTrace();
    			}finally {
    				if(pstm!=null) {
    					pstm.close(); }
    			}		
    	}		
	}
