package TestesUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.management.ValueExp;
import org.junit.Test;
import br.com.clientes.dao.ContatoDAO;
import br.com.clientes.model.contato.Contato;

public class TestesJunit {

	
	@Test
	public void testSave() throws Exception {
		Contato contato = new Contato();
		contato.setId(29);
		contato.setNome("Clarice");
		contato.setInscricao(230);
		contato.setEmail("clarice@host.com.br");
		
		}
	
	@Test (expected = IndexOutOfBoundsException.class)
      public void empty() {
		List<Contato> contatos = new ArrayList<Contato>();
		
		contatos.get(0);
	}
	
	@Test 
	public void testAssertArrayEquals() {
		String esperado = "teste".toString(); 
		String atual = "teste".toString();
		assertArrayEquals(esperado, atual); 
		
	}

	private void assertArrayEquals(String esperado, String atual) {
		
		
	}
	  }
	
