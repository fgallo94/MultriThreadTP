package models;

public class BeerProducter extends Person {
	private BeerHouse 	beerHouse;
	
	public BeerProducter() {
		super();
		this.beerHouse=null;
	}
	
	public BeerProducter(String firstName, String address,String lastName, Integer age) {
		super(firstName,address,lastName,age);
		this.beerHouse=null;
	}
	
	public BeerProducter(BeerProducter beerProducter) {
		super(beerProducter.getFirstName(),beerProducter.getLastName(),beerProducter.getAddress(),beerProducter.getAge());
		this.beerHouse=null;
	}
	
	public void setBeerHouse(BeerHouse beerHouse) {
		this.beerHouse=beerHouse;
	}
	
	public BeerHouse getBeerHouse() {
		return this.beerHouse;
	}
	
}
