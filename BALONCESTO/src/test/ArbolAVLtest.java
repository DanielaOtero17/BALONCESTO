package test;

import junit.framework.TestCase;
import model.Player;
import model.Programm_NBA;

public class ArbolAVLtest extends TestCase{ 
	
	private Programm_NBA pro;

	public void stage(){
		pro = new Programm_NBA();
	}
	
	public void escenario1(){
		 stage();
		 Player p1 = new Player("Arturo",24,"NOB",1,34,54,65,34,30);
		 Player p2 = new Player("Camilo",26,"NOB",2,34,54,65,34,30);
		 Player p3 = new Player("Andres",27,"NOB",3,34,54,65,34,30);
		 Player p4 = new Player("Santiago",28,"NOB",4,34,54,65,34,30);
		 Player p5 = new Player("Juan",22,"NOB",5,34,54,65,34,30);
		 
		 pro.insert(p1);
		 pro.insert(p2);
		 pro.insert(p3);
		 pro.insert(p4);
		 pro.insert(p5);
		 
		 assertEquals(5,pro.getCantidad());
		 
	}
}
