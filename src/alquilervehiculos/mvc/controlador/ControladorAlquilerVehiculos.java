package alquilervehiculos.mvc.controlador;

import java.util.List;

import alquilervehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dao.Alquileres;
import alquilervehiculos.mvc.modelo.dao.Clientes;
import alquilervehiculos.mvc.modelo.dao.Vehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.IVistaAlquilerVehiculos;

public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos{
	
	private IModeloAlquilerVehiculos modelo;
	private IVistaAlquilerVehiculos vista;
	
	/**
	 * Constructor que crea un controlador y recibe dos parámetros
	 * @param modelo
	 * @param vista
	 */
	public ControladorAlquilerVehiculos(IModeloAlquilerVehiculos modelo, IVistaAlquilerVehiculos vista) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#comenzar()
	 */
	@Override
	public void comenzar() {
		//modelo.anadirDatosPrueba();
		
		modelo.leerClientes();
		modelo.leerVehiculos();
		modelo.leerAlquileres();
		vista.comenzar();
	}
	
	@Override
	public void salir() {
		modelo.escribirVehiculos();
		modelo.escribirClientes();
		modelo.escribirAlquileres();
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#anadirVehiculo(AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo, AlquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo)
	 */
	@Override
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		modelo.anadirVehiculo(vehiculo, tipoVehiculo);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#borrarVehiculo(java.lang.String)
	 */
	@Override
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#buscarVehiculo(java.lang.String)
	 */
	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#obtenerVehiculos()
	 */
	@Override
	public List<Vehiculo> obtenerVehiculos() {
		return modelo.obtenerVehiculos();
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#anadirCliente(AlquilerVehiculos.mvc.modelo.dominio.Cliente)
	 */
	@Override
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#borrarCliente(java.lang.String)
	 */
	@Override
	public void borrarCliente (String dni) {
		modelo.borrarCliente(dni);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#buscarCliente(java.lang.String)
	 */
	@Override
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}
	
	@Override
	public List<Cliente> obtenerClientes(){
		return modelo.obtenerClientes();
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#abrirAlquiler(AlquilerVehiculos.mvc.modelo.dominio.Cliente, AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#cerrarAlquiler(AlquilerVehiculos.mvc.modelo.dominio.Cliente, AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.cerrarAlquiler(cliente, vehiculo);
	}
	
	/* (non-Javadoc)
	 * @see AlquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculos#obtenerAlquileres()
	 */
	@Override
	public List<Alquiler> obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}
	
	@Override
	public List<Alquiler> obtenerAlquileresAbiertos() {
		return modelo.obtenerAlquileresAbiertos();
	}
	
	@Override
	public List<Alquiler> obtenerAlquileresCliente(String dni){
		return modelo.obtenerAlquileresCliente(dni);
	}
	
	@Override
	public List<Alquiler> obtenerAlquileresVehiculo(String matricula){
		return modelo.obtenerAlquileresVehiculo(matricula);
	}
	
	/**
	 * Método que llama al método que añade los datos de prueba
	 * para comprobar el funcionamiento de la aplicación
	 */
	/**public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
	}*/
	
}
