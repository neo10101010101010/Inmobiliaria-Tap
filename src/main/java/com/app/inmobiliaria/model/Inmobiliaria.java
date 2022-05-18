package com.app.inmobiliaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table (name= "inmobiliaria")
public class Inmobiliaria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String Municipio;
	private String Colonia;
	private Long CodigoPostal;
	private double Precio;
	private String Imagen;
	
	public Inmobiliaria() {
		
	}
	
	public Inmobiliaria(Long id, String municipio, String colonia, Long codigoPostal, double precio, String imagen) {
		this.Id = id;
		this.Municipio = municipio;
		this.Colonia = colonia;
		this.CodigoPostal = codigoPostal;
		this.Precio = precio;
		this.Imagen = imagen;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		this.Municipio = municipio;
	}
	public String getColonia() {
		return Colonia;
	}
	public void setColonia(String colonia) {
		this.Colonia = colonia;
	}
	public Long getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(Long codigoPostal) {
		this.CodigoPostal = codigoPostal;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		this.Precio = precio;
	}
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		this.Imagen = imagen;
	}
}
