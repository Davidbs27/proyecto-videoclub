/**
 * 
 */
package gui;


public enum TiposOrdenacion {

	OPCION1("Opcion1"),
	OPCION2("Opcion2"),
	OPCION3("Opcion3");
	
	private String literal;

	/**
	 * @param literal
	 */
	private TiposOrdenacion(String literal) {
		this.literal = literal;
	}

	/**
	 * @return the literal
	 */
	public String getLiteral() {
		return literal;
	}
	
	
	
	
}
