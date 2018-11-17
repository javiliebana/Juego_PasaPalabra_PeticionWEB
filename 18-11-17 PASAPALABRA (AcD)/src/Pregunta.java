
public class Pregunta {
	private String letra;
	private String posicion;
	private String definicion;
	private String solucion;

	public Pregunta(String letra, String posicion, String definicion, String solucion) {
		super();
		this.letra = letra;
		this.posicion = posicion;
		this.definicion = definicion;
		this.solucion = solucion;
	}

	public String getLetra() {
		return letra;
	}

	public String getPosicion() {
		return posicion;
	}

	public String getDefinicion() {
		return definicion;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

}
