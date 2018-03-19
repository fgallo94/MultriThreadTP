package models;

public class BeerConsumer extends Person {
	private Beer favoriteBeer;

	public BeerConsumer() {
		super();
		this.favoriteBeer=null;
	}
	
	public BeerConsumer(String firstName, String address,String lastName, Integer age) {
		super(firstName,address,lastName,age);
		this.favoriteBeer=null;
	}
	
	public BeerConsumer(BeerConsumer BeerConsumer) {
		super(BeerConsumer.getFirstName(),BeerConsumer.getLastName(),BeerConsumer.getAddress(),BeerConsumer.getAge());
		this.favoriteBeer=null;
	}
	
	public void setFavoriteBeer(Beer favoriteBeer) {
		this.favoriteBeer=favoriteBeer;
	}
	
	public Beer getFavoriteBeer() {
		return this.favoriteBeer;
	}
}
