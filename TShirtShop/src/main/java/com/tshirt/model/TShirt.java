package com.tshirt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TShirt {

public static enum Colour{WHITE, BLACK, YELLOW, GREEN, BLUE};

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
Long id;
String name;
String size;
Colour colour;
Double price;
String image;
public TShirt(){};
public TShirt(	Long id,
				String name,
				String size,
				Colour colour,
				Double price,
				String image){
	
	
	this.id = id;
	this.name = name;
	this.size = size;
	this.colour = colour;
	this.image = image;
	
	
}



public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public Colour getColour() {
	return colour;
}
public void setColour(Colour colour) {
	this.colour = colour;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}





}
