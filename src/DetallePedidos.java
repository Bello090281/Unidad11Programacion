/**
 * 
 * @author Bello
 *Clase para realizar el apartado 4 del menu, esta clase contiene las variables y metodos necesario.
 */
public class DetallePedidos {

	
	//Variables.
	int codigopedido;
	String codigoproducto;
	int cantidad;
	int preciounidad;
	int numerolinea;
	
	//Constructores.
	public DetallePedidos(int codigopedido, String codigoproducto, int cantidad, int preciounidad, int numerolinea) {
		super();
		this.codigopedido = codigopedido;
		this.codigoproducto = codigoproducto;
		this.cantidad = cantidad;
		this.preciounidad = preciounidad;
		this.numerolinea = numerolinea;
	}

	public DetallePedidos() {
		super();
	}
	//Métodos get y set de las variables.

	public int getCodigopedido() {
		return codigopedido;
	}

	public void setCodigopedido(int codigopedido) {
		this.codigopedido = codigopedido;
	}

	public String getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(int preciounidad) {
		this.preciounidad = preciounidad;
	}

	public int getNumerolinea() {
		return numerolinea;
	}

	public void setNumerolinea(int numerolinea) {
		this.numerolinea = numerolinea;
	}
	//Método toString.

	@Override
	public String toString() {
		return "\n"
			+ "********************************************************** Detalles Pedidos**********************************************************************"+"\n"
			+ "codigopedido = " + codigopedido + ", codigoproducto = " + codigoproducto + ", cantidad = "+ cantidad + ", preciounidad = " + preciounidad + ", numerolinea = " + numerolinea + "\n"
			+ "******************************************************************************************************************************************************";
	}
	
	
	
}
