import java.util.ArrayList;

/**
 * 
 * @author Bello
 * Clase Productos con las variables de los productos, los constructores y métodos que nos solicitan en el enunciado.
 */


public class Productos {

	//Variables
	String codigoproducto;
	String nombre;
	String gama;
	String dimensiones;
	String prroveedor;
	String descripcion;
	int cantidadenstock;
	int precioventa;
	int precioproveedor;
	
	

	//Constructor con parámetros y sin parámetros.
	public Productos(String codigoproducto, String nombre, String gama, String dimensiones, String prroveedor,
			String descripcion, int cantidadenstock, int precioventa, int precioproveedor) {
		super();
		this.codigoproducto = codigoproducto;
		this.nombre = nombre;
		this.gama = gama;
		this.dimensiones = dimensiones;
		this.prroveedor = prroveedor;
		this.descripcion = descripcion;
		this.cantidadenstock = cantidadenstock;
		this.precioventa = precioventa;
		this.precioproveedor = precioproveedor;
	}

	public Productos(String codigo, String nombre2) {
		super();
	}
	//Métodos get y set de las variables.

	public String getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getPrroveedor() {
		return prroveedor;
	}

	public void setPrroveedor(String prroveedor) {
		this.prroveedor = prroveedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidadenstock() {
		return cantidadenstock;
	}

	public void setCantidadenstock(int cantidadenstock) {
		this.cantidadenstock = cantidadenstock;
	}

	public int getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(int precioventa) {
		this.precioventa = precioventa;
	}

	public int getPrecioproveedor() {
		return precioproveedor;
	}

	public void setPrecioproveedor(int precioproveedor) {
		this.precioproveedor = precioproveedor;
	}
	//Método toString.

	@Override
	public String toString() { //Le damos este formato para mejorar la vision de las variables. 
		return "Productos" +"\n"
				+ "---------------------------------------------------"+"\n"
				+ ""
				+ "codigoproducto=" + codigoproducto + "\n"
				+ "nombre=" + nombre + "\n"
				+ "gama=" + gama + "\n"
				+ "dimensiones=" + dimensiones + "\n"
				+ "prroveedor=" + prroveedor + "\n"
				+ "descripcion=" + descripcion	+ "\n"
				+ "cantidadenstock=" + cantidadenstock + "\n"
				+ "precioventa=" + precioventa + "\n"
				+ "precioproveedor="+ precioproveedor + "\n"
				+ ""
				+ "----------------------------------------------------";
	}
	
	
	
	
	
	
}
