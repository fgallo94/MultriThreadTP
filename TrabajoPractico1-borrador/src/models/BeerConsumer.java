package models;

public class BeerConsumer extends Person implements Runnable {
	private Beer favoriteBeer;
	private BeerHouse ubication;

	public BeerConsumer() {
		super();
		this.favoriteBeer = null;
		this.ubication=null;
	}

	public BeerConsumer(String firstName, String address, String lastName, Integer age) {
		super(firstName, address, lastName, age);
		this.favoriteBeer = null;
		this.ubication=null;
	}

	public BeerConsumer(BeerConsumer BeerConsumer) {
		super(BeerConsumer.getFirstName(), BeerConsumer.getLastName(), BeerConsumer.getAddress(),
				BeerConsumer.getAge());
		this.favoriteBeer = null;
		this.ubication=null;
	}

	public void setFavoriteBeer(Beer favoriteBeer) {
		this.favoriteBeer = favoriteBeer;
	}

	public Beer getFavoriteBeer() {
		return this.favoriteBeer;
	}
	
	public void setUbication(BeerHouse ubication) {
		this.ubication = ubication;
	}

	public BeerHouse getUbication() {
		return this.ubication;
	}

	@Override
	public void run() {
			try {
				ubication.sale(this);
			} catch (InterruptedException e) {
				System.out.println("Debes ingresar donde se encuentra "+this.getFirstName() +" "+ this.getLastName());
			}			
	}
}
