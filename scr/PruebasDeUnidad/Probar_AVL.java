package PruebasDeUnidad;

/**
 * @author Dante
 *
 */

import Modelo.API_AVL;
import org.junit.Before;
import org.junit.Test;
/** Clase testeadora para probar arbol AVL.
 *  Crear registro en el arbol AVL
 *  Leer registro en el arbol AVL
 *  Borrar registro en el arbol AVL
 * */
public class Probar_AVL {
	//parametros y clases
	int dato;
	API_AVL arbol_avl;
	
	@Before	
	public void before(){
	   //inicializar parametros y clase
	      arbol_avl = new API_AVL();
	}
			
	@Test
	public void test() {
		

		for(int numerodato = 1;numerodato<100;numerodato++) {	
			dato= (int) Math.floor(Math.random()*10000+1);
			System.out.print(dato+"|");
	//		arbol_avl.Insertar_registro_arbol_avl(dato);
		}
		
		try{
			Thread.sleep(900000);
		}catch(Exception e){System.out.println("Error.");}	
	}
}
