package gestionnairedetache;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testClasseTache {

	@Parameter (value = 0)
	public int idTache;
	
	@Parameter (value = 1)
	public String nomTache;
	
	@Parameter (value = 2)
	public String descriptionTache;
	
	@Parameter (value = 3)
	public String statusTache;
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][] {{1, "tache", "Description1", "nouveau"}, {2, "Tache2", "Description2", "terminer"}};
		return Arrays.asList(data);
	}
	
	@Test
	public void testSetIdTache() {
		Tache tache = new Tache();
		assertEquals(idTache, tache.getId());
	}
	
	@Test
	public void testSetNomTache() {
		Tache tache = new Tache();
		assertEquals(nomTache, tache.getNom());
	}
	
	@Test
	public void testSetDescriptionTache() {
		Tache tache = new Tache();
		assertEquals(descriptionTache, tache.getDescription());
	}
	
	@Test
	public void testSetStatusTache() {
		Tache tache = new Tache();
		assertEquals(statusTache, tache.getStatus());
	}


}
