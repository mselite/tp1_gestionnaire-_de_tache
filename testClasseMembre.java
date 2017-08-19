package gestionnairedetache;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestJunitAjoutMembre { 
	
	@Parameter (value = 0)
	public int idMembre;
	
	@Parameter (value = 1)
	public String nomMembre;
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][] {{1, "Maman"}, {2, "Sani"}};
		return Arrays.asList(data);
	}
	
	@Test
	public void testSetIdMembre() {
		Membre membre = new Membre();
		assertEquals(idMembre, membre.getId());
	}
	
	@Test
	public void testSetNomMembre() {
		Membre membre = new Membre();
		assertEquals(nomMembre, membre.getNom());
	}

}
