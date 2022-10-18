package com.zubiri.app.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Direccion {
	public Direccion(String calle, String CP, String ciudad, String pais) {   	
		this.calle = calle;
		this.CP = CP;
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public Direccion() {   							
	}
	
	@NotNull   
    @Column(nullable = false) 
    private String pais;
	
	@NotNull   								
    @Column(nullable = false)   						
    private String calle;

    @NotNull
    @Column(nullable = false, length = 5)   					
    private String CP;

    @NotNull   								
    @Column(nullable = false)
    private String ciudad;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

    

}
