package models;

public class BeerProducter extends Person implements Runnable {
	private BeerHouse beerHouse;
	private Beer beerType;

	public BeerProducter() {
		super();
		this.beerHouse = null;
		this.beerType = null;
	}

	public BeerProducter(String firstName, String address, String lastName, Integer age) {
		super(firstName, address, lastName, age);
		this.beerHouse = null;
		this.beerType = null;
	}

	public BeerProducter(BeerProducter beerProducter) {
		super(beerProducter.getFirstName(), beerProducter.getLastName(), beerProducter.getAddress(),
				beerProducter.getAge());
		this.beerHouse = null;
		this.beerType = null;
	}

	public Beer produceBeer() {
		return new Beer(getBeerType());
	}

	public void setBeerType(Beer beerType) {
		this.beerType = beerType;
	}

	public void setBeerHouse(BeerHouse beerHouse) {
		this.beerHouse = beerHouse;
	}

	public BeerHouse getBeerHouse() {
		return this.beerHouse;
	}

	public Beer getBeerType() {
		return this.beerType;
	}

	@Override
	public void run() {
		try {
			while (beerHouse.getState().equals(false) || beerHouse.getFullStock().equals(false)) {
				beerHouse.sale(this);
				 try {
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
			}
		} catch (InterruptedException e) {
			System.out.println("Debes ingresar donde se encuentra " + this.getFirstName() + " " + this.getLastName());
		}
	}

}
