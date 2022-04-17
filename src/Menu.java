import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.util.XMLEventAllocator;

import oracle.net.aso.p;

public class Menu {

	/**
	 * 
	 * @author Bello
	 * 
	 */

	static Scanner teclado = new Scanner(System.in);

	// Método principal.
	public static void main(String[] args) {

		/**
		 * Conexion a la base de datos Oracle.
		 */
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jardineria",
					"jardineria");// Direccion de nuestra base de datos, usuario y pass.

			/**
			 * Pintar menu principal
			 */

			// variable menu.
			int menu = 0;
			System.out.println("Introduzca una opcion: \n" + "1. Genera pedidos entregados.\n" + "2. Genera detalles.\n"
					+ "3. Genera productos ('FR-102')\n" + "4. Genera informe: Productos perdidos.\n" + "5. Salir.\n"
					+ "");
			try {
				menu = teclado.nextInt();

				System.out.println("La opcion seleccionada es " + menu);

				// Sentencia switch con los diferentes case, dependiendo la opcion elegida
				// realizara un apartado u otro.
				
				switch (menu) {

				/**
				 * Generar pedidos entregados que crea un fichero pedidos.csv con codigo del
				 * pedido, el estado del pedido (entregado) y el codigo del cliente. (Recuerda
				 * que los campos van separados por ;).
				 */

				case 1:

					FileOutputStream fichero = new FileOutputStream("pedidos.csv");
					PrintWriter escritura = new PrintWriter(fichero);
					Statement stmt = conn.createStatement();
					ResultSet rset = stmt.executeQuery("select codigopedido, estado, codigocliente from PEDIDOS");// Consulta
																													// SQL.

					while (rset.next()) {

						// Datos a escribir en el fichero indicado.
						escritura.println(rset.getString(1) + ";" + rset.getString(2) + ";" + rset.getString(3));
						// Datos recibidos de la consulta y mostrados por pantalla.
						//System.out.println(rset.getString(1) + ";" + rset.getString(2) + ";" + rset.getString(3));

					}
					System.out.println("Archivo pedidos.csv creado correctamente");// Mensaje de advertencia.
					escritura.close();
					stmt.close();
					break;

				/**
				 * Generar detalle.csv:Crea otro llamado detalle.csv con todos los datos del
				 * detalle del pedido.
				 * 
				 */

				case 2:
					FileOutputStream fichero2 = new FileOutputStream("detalles.csv");
					PrintWriter escritura2 = new PrintWriter(fichero2);
					Statement stmt2 = conn.createStatement();
					ResultSet rset2 = stmt2.executeQuery(
							"select codigopedido, codigoproducto, cantidad, preciounidad, numerolinea from detallepedidos");// Consulta
																															// SQL.
					while (rset2.next()) {

						// Datos a escribir en el fichero indicado.
						escritura2.println(rset2.getString(1) + ";" + rset2.getString(2) + ";" + rset2.getString(3)
								+ ";" + rset2.getString(4) + ";" + rset2.getString(5));
						// Datos recibidos de la consulta y mostrados por pantalla.
						//System.out.println(rset2.getString(1) + ";" + rset2.getString(2) + ";" + rset2.getString(3)+ ";" + rset2.getString(4) + ";" + rset2.getString(5));

					}
					System.out.println("Archivo detalles.csv creado correctamente");// Mensaje de advertencia.
					escritura2.close();
					stmt2.close();
					break;

				/**
				 * Cargar productos: Crea una clase llamada productos.java que tenga tantos
				 * campos como la tabla productos (getters, setters, constructores, toString).
				 * Crea otro programa Java que realice una consulta de los productos y crea un
				 * arraylist de productos. Para que no haya muchos datos y no se cuelgue Eclipse
				 * filtrar por el codigo codigoproducto='FR-102'.
				 */
				case 3:
					Statement stmt3 = conn.createStatement();
					ResultSet rset3 = stmt3.executeQuery("Select * from productos where codigoproducto='FR-102'");// Consulta
																													// SQL
																													// con
																													// condicional.
					ArrayList<Productos> listaproductos = new ArrayList<>();
					while (rset3.next()) {
						// Datos desde la base de datos.
						// System.out.println(rset3.getString(1)+";"+rset3.getString(2)+";"+rset3.getString(3)+";"+rset3.getString(4)+";"+rset3.getString(5)+";"+rset3.getString(6)+";"+rset3.getString(7)+";"+rset3.getString(8));

						String codigo = rset3.getString(1);
						String nombre = rset3.getString(2);
						String gama = rset3.getString(3);
						String dimensiones = rset3.getString(4);
						String proveedor = rset3.getString(5);
						String descripcion = rset3.getString(6);
						int cantidad = Integer.parseInt(rset3.getString(7));
						int precioventa = Integer.parseInt(rset3.getString(8));
						int precioproveedor = Integer.parseInt(rset3.getString(9));
						listaproductos.add(new Productos(codigo, nombre, gama, dimensiones, proveedor, descripcion,
								cantidad, precioventa, precioproveedor));
					}

					// Datos desde el ArrayList creado.
					System.out.println("Datos en el ArrayList creado.");// Mensaje de advertencia.
					System.out.println(listaproductos);
					stmt3.close();

					break;

				/**
				 * Generar informe: Finalmente, crea un fichero llamado pedidos.txt donde
				 * muestres los productos que se han pedido y su detalle.
				 */
				case 4:

					// Introducimos todos los datos sobre la tabla productos en un ArrayList, el
					// ArrayList nos permitira poder selceccionar los datos que deseamos.
					Statement stmt4 = conn.createStatement();
					ResultSet rset4 = stmt4.executeQuery("Select * from productos");// Consulta SQL.
					ArrayList<Productos> ventaProductos = new ArrayList<>();
					while (rset4.next()) {

						String codigo = rset4.getString(1);
						String nombre = rset4.getString(2);
						String gama = rset4.getString(3);
						String dimensiones = rset4.getString(4);
						String proveedor = rset4.getString(5);
						String descripcion = rset4.getString(6);
						int cantidad = Integer.parseInt(rset4.getString(7));
						int precioventa = Integer.parseInt(rset4.getString(8));
						int precioproveedor = Integer.parseInt(rset4.getString(9));
						ventaProductos.add(new Productos(codigo, nombre, gama, dimensiones, proveedor, descripcion,
								cantidad, precioventa, precioproveedor));

					}

					// Introducimos todos los datos sobre los detalles de los pedidos en un
					// ArrayList, el ArrayList nos permitira seleccionar los datos que deseamos.
					// En mi caso usare el método toString creado en la clase detallePedidos.
					Statement stmt5 = conn.createStatement();
					ResultSet rset5 = stmt5.executeQuery("Select * from detallepedidos");// Consulta SQL.
					ArrayList<DetallePedidos> detallesProductos = new ArrayList<>();
					while (rset5.next()) {

						int codigopedido = Integer.parseInt(rset5.getString(1));
						String codigoproducto = rset5.getString(2);
						int cantidad = Integer.parseInt(rset5.getString(3));
						int preciounidad = Integer.parseInt(rset5.getString(4));
						int numerolinea = Integer.parseInt(rset5.getString(5));
						detallesProductos.add(
								new DetallePedidos(codigopedido, codigoproducto, cantidad, preciounidad, numerolinea));

					}
					// Una vez disponemos d elos datos que necesitamos dentro de los dos ArrayList
					// creado anteriormente, creamos un fichero con extension .txt
					FileOutputStream ficherotxt = new FileOutputStream("detallespedidos.txt");
					PrintWriter escriturafichero = new PrintWriter(ficherotxt);

					// Para comprobar los detalles d elos pedidos usaremos un bucle for, el primer
					// for para el codigo del producto y un segundo for para los detalles de los
					// pedidios donde dispongamos de ese producto.
					for (int i = 0; i < ventaProductos.size(); i++) {

						escriturafichero.println("El producto " + ventaProductos.get(i).getCodigoproducto() + " == "
								+ ventaProductos.get(i).getNombre());

						for (int j = 0; j < detallesProductos.size(); j++) {
							if (ventaProductos.get(i).getCodigoproducto()
									.equals(detallesProductos.get(j).getCodigoproducto())) {// Sentencia if, que nos
																							// permite comprobar si el
																							// codigo del producto esta
																							// en los dos ArrayList.

								escriturafichero.println(detallesProductos.get(j));
							}
						}
					}
					System.out.println("Fichero detallesPedidos.txt creado correctamente");// Mensaje de advertencia

					break;
				/**
				 * Salir.
				 */
				case 5:
					System.out.println("Adios, gracias por su confianza");// Mensaje de advertencia.
					System.exit(0);// Comando para salir de la ejecucion, salido con 0 que es una salida controlada
									// y sin fallos.
					break;

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
