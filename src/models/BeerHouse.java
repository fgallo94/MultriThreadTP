package models;

import java.util.List;

public class BeerHouse {
	private String name;
	private String address;
	private List<Beer> stock;
	
	public BeerHouse() {
		this.name		="";
		this.address	="";
		this.stock		=null;
	}
	
	public BeerHouse(String name, String address,List<Beer> stock) {
		this.name	=name;
		this.address=address;
		this.stock	=stock;
	}
	
	public BeerHouse(BeerHouse beerHouse) {
		this.name	=beerHouse.getName();
		this.address=beerHouse.getAddress();
		this.stock	=beerHouse.getStock();
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public void setStock(List<Beer> stock) {
		this.stock=stock;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public List<Beer> getStock(){
		return this.stock;
	}
	
}
