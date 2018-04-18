import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class abbTest {
	arbolBusquedaBinaria arbol = new arbolBusquedaBinaria();
	@Test
	void test() {
		arbol.insertar(10);
		arbol.insertar(2);
		arbol.insertar(33);
		arbol.insertar(41);
		arbol.insertar(55);
		arbol.insertar(6);
		arbol.insertar(47);
		arbol.insertar(28);
		arbol.insertar(20);
		System.out.println("in Orden :");
		arbol.inOrdenAbb();
		System.out.println("");
		System.out.println("pre Orden :");
		arbol.preOrdenAbb();
		System.out.println("");
		System.out.println("pos Orden :");
		arbol.posOrdenAbb();
		System.out.println("");
		//verifico si los valores maximos corresponden a los ingresados
		assertEquals(2,arbol.min());
		assertEquals(55,arbol.max());
		//verifico si la altura es la correcta
		assertEquals(4,arbol.alturaDelAbb());
	}

}
