package PruebasDeUnidad;
import org.junit.Before;
import org.junit.Test;

import APIs.Arbol_AVL.API_AVL;
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
	//	for(int numerodato = 1;numerodato<=6;numerodato++) {	
	//		dato= (int) Math.floor(Math.random()*990+1);
	//		System.out.print(dato+"|");
	//		arbol_avl.insertar(dato);
	//	}
		arbol_avl.insertar(10);
		arbol_avl.insertar(5);
		arbol_avl.insertar(13);
		arbol_avl.insertar(1);
		arbol_avl.insertar(6);
		arbol_avl.insertar(17);
		arbol_avl.insertar(16);
		
		arbol_avl.Preorden(arbol_avl.obtener_raiz());
		

		try{
			Thread.sleep(900000);
		}catch(Exception e){System.out.println("Error.");}	
	}
}
