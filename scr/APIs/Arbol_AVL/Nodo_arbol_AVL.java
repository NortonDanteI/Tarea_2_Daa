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
	
	public int obtener_valor(){
		return Valor;
	}
	public Nodo_arbol_AVL obtener_hijoderecho(){
		return hijoderecho;
	}
	public Nodo_arbol_AVL obtener_hijoizquierdo(){
		return hijoizquierdo;
	}
}