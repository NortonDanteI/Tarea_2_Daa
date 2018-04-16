/**
 * @author Dante
 *
 */
package APIs.Arbol_AVL;

public class API_AVL{
	/**
	 * parametros
	 */
	private Nodo_arbol_AVL raiz;
	
	public API_AVL() {
		raiz=null;
	}
	
	// getter
	public Nodo_arbol_AVL obtener_raiz(){
		return raiz;
	}
	/**
	 * Buscar y Leer un dato en el arbol AVL
	 *
	 */
	public  Nodo_arbol_AVL Buscar_registro_en_AVL(int dato,Nodo_arbol_AVL un_nodo1){
		
		if(raiz==null) {
			return null;
		}
		else {
			if(un_nodo1.Valor==dato){
				return un_nodo1;
			}
			else {
				if(un_nodo1.Valor<dato) {
					return Buscar_registro_en_AVL(dato,un_nodo1.hijoderecho);
				}
				else {
						return Buscar_registro_en_AVL(dato,un_nodo1.hijoizquierdo);
				}
			}
		}
	}
	
	/**
	 * Obtener factor de equilibrio
	 *
	 */
	public int Obtener_FE(Nodo_arbol_AVL un_nodo2) {
		if(un_nodo2==null) {
			return -1;
		}
		else {
			return un_nodo2.FE;
		}
	}
	/**
	 * Rotar a la izquierda
	 *
	 */
	public Nodo_arbol_AVL rotacion_a_izquierda(Nodo_arbol_AVL un_nodo3) {
		Nodo_arbol_AVL auxiliar = un_nodo3.hijoizquierdo;
		un_nodo3.hijoizquierdo = auxiliar.hijoderecho;
		auxiliar.hijoderecho = un_nodo3;
		
		un_nodo3.FE = Math.max(Obtener_FE(un_nodo3.hijoizquierdo),Obtener_FE(un_nodo3.hijoderecho))+1;
		
		auxiliar.FE = Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotar a la derecha
	 *
	 */
	public Nodo_arbol_AVL rotacion_a_derecha(Nodo_arbol_AVL un_nodo4) {
		
		Nodo_arbol_AVL auxiliar = un_nodo4.hijoderecho;
		un_nodo4.hijoderecho = auxiliar.hijoizquierdo;
		auxiliar.hijoizquierdo = un_nodo4;
		
		un_nodo4.FE=Math.max(Obtener_FE(un_nodo4.hijoizquierdo),Obtener_FE(un_nodo4.hijoderecho))+1;
		
		auxiliar.FE=Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotacion doble izquierda = rotacion izquierda + rotacion derecha
	 *
	 */
	public Nodo_arbol_AVL rotacion_doble_izquierda(Nodo_arbol_AVL un_nodo5) {
		Nodo_arbol_AVL temporal;
		
		un_nodo5.hijoizquierdo = rotacion_a_derecha(un_nodo5.hijoizquierdo);
		
		temporal = rotacion_a_izquierda(un_nodo5);
		
		return temporal;
	}
	/**
	 * Rotacion doble derecha = rotacion derecha + rotacion izquierda
	 *
	 */
	public Nodo_arbol_AVL rotacion_doble_derecha(Nodo_arbol_AVL un_nodo6) {
		Nodo_arbol_AVL temporal;
		
		un_nodo6.hijoderecho=rotacion_a_izquierda(un_nodo6.hijoderecho);
		
		temporal = rotacion_a_derecha(un_nodo6);
		
		return temporal;
	}
	/**
	 * Insertar dato en AVL
	 *
	 */
	public Nodo_arbol_AVL insertar_AVL(Nodo_arbol_AVL nuevo,Nodo_arbol_AVL sub_arbol) {
		Nodo_arbol_AVL Nuevo_padre = sub_arbol;
		
		//condicion 1
		if(nuevo.Valor<sub_arbol.Valor) {
			if( sub_arbol.hijoizquierdo==null) {
				sub_arbol.hijoizquierdo=nuevo;
			}
			else {
				sub_arbol.hijoizquierdo=insertar_AVL(nuevo,sub_arbol.hijoizquierdo);
				if((Obtener_FE(sub_arbol.hijoizquierdo) - Obtener_FE(sub_arbol.hijoderecho)==2)) {
					if(nuevo.Valor<sub_arbol.hijoizquierdo.Valor) {
						Nuevo_padre = rotacion_a_izquierda(sub_arbol);
					}
					else {
						Nuevo_padre = rotacion_doble_izquierda(sub_arbol);
					}
				}
			}		
		}
		//caso 2
		else {
			if(nuevo.Valor>sub_arbol.Valor) {
				if( sub_arbol.hijoderecho==null) {
					sub_arbol.hijoderecho=nuevo;
				}
				else {
					sub_arbol.hijoderecho = insertar_AVL(nuevo,sub_arbol.hijoderecho);
					if((Obtener_FE(sub_arbol.hijoderecho) - Obtener_FE(sub_arbol.hijoizquierdo)==2)) {
						if(nuevo.Valor>sub_arbol.hijoderecho.Valor) {
							Nuevo_padre = rotacion_a_derecha(sub_arbol);
						}
						else {
							Nuevo_padre = rotacion_doble_derecha(sub_arbol);
						}
					}
				}
			}
			//caso 3
			else {
				System.out.println("Nodo duplicado");
			}	
		}
		// actualizar altura
		if(	(sub_arbol.hijoizquierdo==null)&&(sub_arbol.hijoderecho!=null)	){
			sub_arbol.FE=sub_arbol.hijoderecho.FE+1;
		}else {
			if(	(sub_arbol.hijoderecho==null)&&(sub_arbol.hijoizquierdo!=null)	) {
				sub_arbol.FE = sub_arbol.hijoizquierdo.FE+1;
			}
			else {
				sub_arbol.FE = Math.max(Obtener_FE(sub_arbol.hijoizquierdo), Obtener_FE(sub_arbol.hijoderecho))+1;
			}
		}
		return Nuevo_padre;
	}
	/**
	 * insertar
	 *
	 */
	public void insertar(int dato) {
		Nodo_arbol_AVL nuevo = new Nodo_arbol_AVL(dato);
		if(raiz==null) {
			raiz=nuevo;
		}
		else {
			raiz=insertar_AVL(nuevo,raiz);
		}
	}
	
	/**
	 * Recorrer arbol Inorden
	 *
	 */
	public void Inorden(Nodo_arbol_AVL un_nodo7) {
		if(un_nodo7!=null) {
			Inorden(un_nodo7.hijoizquierdo);
			System.out.print(un_nodo7.Valor+"|");
			Inorden(un_nodo7.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol en preorden
	 *
	 */
	public void Preorden(Nodo_arbol_AVL un_nodo8) {
		if(un_nodo8!=null) {
			System.out.print(un_nodo8.Valor+"|");
			Preorden(un_nodo8.hijoizquierdo);
			Preorden(un_nodo8.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol en postorden
	 *
	 */
	public void Postorden(Nodo_arbol_AVL un_nodo9) {
		if(un_nodo9!=null) {
			Postorden(un_nodo9.hijoizquierdo);
			Postorden(un_nodo9.hijoderecho);
			System.out.print(un_nodo9.Valor+"|");
		}
	}
/**
 * borrar registro en arbol AVL
 *
 */
	public boolean Eliminar_registro_en_AVL() {
		return false;

	}	
}