package models;

import java.util.List;

public class BeerHouse {
	private String name;
	private String address;
	private List<Beer> stock;
	private Boolean state;
	private Boolean available;

	public BeerHouse() {
		this.name = "";
		this.address = "";
		this.stock = null;
		this.state = false;
		this.available = true;
	}

	public BeerHouse(String name, String address) {
		this.name = name;
		this.address = address;
		this.stock = null;
		this.state = false;
		this.available = true;
	}

	public BeerHouse(BeerHouse beerHouse) {
		this.name = beerHouse.getName();
		this.address = beerHouse.getAddress();
		this.stock = beerHouse.getStock();
		this.state = beerHouse.getState();
		this.available = beerHouse.getAvailable();
	}

	public synchronized void sale(Person person) throws InterruptedException {
		if (stock.isEmpty() && this.getState().equals(false)) {
			if (person.getClass().equals(BeerProducter.class)) {
				reloadBeer((BeerProducter) person);
			} else {
				wait();
			}
		} else if (stock.isEmpty() && this.getState().equals(true) && person.getClass().equals(BeerProducter.class)) {
			System.out.println(person.getFirstName() + " da una vuelta por " + this.getName()
			+ " pero ahí le dicen que aun tienen stock");
		} else if (stock.isEmpty() && this.getState().equals(true)) {
			System.out.println(person.getFirstName() + " se encuentra que " + this.getName()
					+ " se quedó sin cervezas y decide irse");
		} else {
			while (stock.size() > 0) {
				if (!getAvailable()) {
					wait();
				} else {
					if (person.getClass().equals(BeerConsumer.class)) {
						saleBeer((BeerConsumer) person);
						this.setAvailable(true);
						notifyAll();
					}
				}
			}
		}
	}

	private void reloadBeer(BeerProducter producter) throws InterruptedException {
		while (stock.size() < 20) {
			if (this.getAvailable().equals(true)) {
				stock.add(producter.produceBeer());
				System.out.println("El productor " + producter.getFirstName() + " " + producter.getLastName()
						+ " produce una: \n " + producter.getBeerType().toString());
				this.setAvailable(true);
				notifyAll();
			} else {
				wait();
			}
		}
	}

	private void saleBeer(BeerConsumer consumer) throws InterruptedException {
		if (stock.contains(consumer.getFavoriteBeer())) {
			stock.remove(consumer.getFavoriteBeer());
			System.out.println("El bar " + this.getName() + "tiene la cerveza favorita de " + consumer.getFirstName()
					+ " una " + consumer.getFavoriteBeer().getName() + ", entonces se toma una de estas");
		} else {
			Beer choise = stock.remove(0);
			System.out.println(consumer.getFirstName() + " se bebe una " + choise.getName() + " que es una "
					+ choise.getType() + " y su ibu es de " + choise.getIbu());
		}
	}

	public void close() {
		this.setState(false);
	}
	
	public void open() {
		this.setState(true);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStock(List<Beer> stock) {
		this.stock = stock;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public List<Beer> getStock() {
		return this.stock;
	}

	public Boolean getState() {
		return this.state;
	}

	public Boolean getAvailable() {
		return this.available;
	}
}
