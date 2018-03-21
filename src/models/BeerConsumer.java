package models;

public class BeerConsumer extends Person implements Runnable {
	private Beer favoriteBeer;
	private BeerHouse ubication;
	private boolean goTime;

	public BeerConsumer() {
		super();
		this.favoriteBeer = null;
		this.ubication=null;
		this.goTime=false;
	}

	public BeerConsumer(String firstName, String address, String lastName, Integer age) {
		super(firstName, address, lastName, age);
		this.favoriteBeer = null;
		this.ubication=null;
		this.goTime=false;
	}

	public BeerConsumer(BeerConsumer BeerConsumer) {
		super(BeerConsumer.getFirstName(), BeerConsumer.getLastName(), BeerConsumer.getAddress(),
				BeerConsumer.getAge());
		this.favoriteBeer = null;
		this.ubication=null;
		this.goTime=false;
	}

	public void setFavoriteBeer(Beer favoriteBeer) {
		this.favoriteBeer = favoriteBeer;
	}

	public Beer getFavoriteBeer() {
		return this.favoriteBeer;
	}
	
	public void setGoTime(boolean bool) {
		this.goTime = bool;
	}

	public boolean getGotime() {
		return this.goTime;
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
				while(this.goTime==false) {
				ubication.sale(this);
				 try {
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
			} catch (InterruptedException e) {
				System.out.println("Debes ingresar donde se encuentra "+this.getFirstName() +" "+ this.getLastName());
			}			
	}
}
