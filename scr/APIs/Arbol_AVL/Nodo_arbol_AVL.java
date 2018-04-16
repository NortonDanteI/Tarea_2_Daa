/**
 * @author Dante
 */
package APIs.Arbol_AVL;

/**
 * Nodo del arbol AVL
 *
 */
public class Nodo_arbol_AVL {
	int Valor, FE;
	Nodo_arbol_AVL hijoizquierdo,hijoderecho;
	
	public Nodo_arbol_AVL (int Valor1) {
		this.Valor=Valor1;
		this.FE=0;
		this.hijoizquierdo=null;
		this.hijoderecho=null;
	}
}