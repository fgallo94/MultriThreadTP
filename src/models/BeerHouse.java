package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BeerHouse contiene atributos que son datos del mismo(name y address),una
 * lista de cervezas, state que es si esta abierto o cerrado,avaible es la flag
 * para los threads y fullStock es cuando esta lleno y no quiero que se produzca
 * cerveza
 * 
 * @author Fede
 *
 */
public class BeerHouse {
	private String name;
	private String address;
	private ArrayList<Beer> stock;
	private Boolean state;
	private Boolean available;
	private Boolean fullStock;

	public BeerHouse() {
		this.name = "";
		this.address = "";
		this.stock = new ArrayList<Beer>();
		this.state = false;
		this.available = true;
		this.fullStock = false;
	}

	public BeerHouse(String name, String address) {
		this.name = name;
		this.address = address;
		this.stock = null;
		this.state = false;
		this.available = true;
		this.fullStock = false;
	}

	public BeerHouse(BeerHouse beerHouse) {
		this.name = beerHouse.getName();
		this.address = beerHouse.getAddress();
		this.stock = beerHouse.getStock();
		this.state = beerHouse.getState();
		this.available = beerHouse.getAvailable();
		this.fullStock = beerHouse.getFullStock();
	}

	/**
	 * Metodo sincronizado que de primera parte identifica al Thread, si es tipo
	 * BeerProducter hace el ciclo del productor, si no lo es ejecuta el ciclo del
	 * consumidor, el ciclo del productor pregunta si la lista esta inicializada, en
	 * caso de no estarlo la instancia, si el recurso no esta disponible espera, si
	 * el recurso esta disponible, pone que no esta disponible, ejecuta su metodo,
	 * pone el recurso en disponible y llama a los demás Threads. El ciclo del
	 * consumidor consta de preguntar si la lista no es null y si el bar esta
	 * abierto, si el bar esta sin stock emite un mensaje y setea la variable que
	 * frena el ciclo de ejecución del thread. Si tiene stock y el recurso no esta
	 * disponible espera, si esta disponible pone el recurso en no
	 * disponible,ejecuta su tarea y notifica al resto
	 * 
	 * @param person
	 * @throws InterruptedException
	 */
	public synchronized void sale(Object person) throws InterruptedException {
		if (person.getClass().equals(BeerProducter.class)) {
			if (this.stock == null) {
				this.stock = new ArrayList<Beer>();
			}
			if (!this.getAvailable()) {
				wait();
			} else {
				this.setAvailable(false);
				reloadBeer((BeerProducter) person);
				this.setAvailable(true);
				notifyAll();
			}
		} else {
			if (stock != null && this.getState().equals(true)) {
				if (stock.size() <= 0) {
					System.out.println(((BeerConsumer) person).getFirstName() + " se encuentra que " + this.getName()
							+ " se quedó sin cervezas y decide irse");
					((BeerConsumer) person).setGoTime(true);
				} else {

					try {
						while (getAvailable().equals(false)) {
							wait();
						}

						this.setAvailable(false);
						saleBeer((BeerConsumer) person);
						this.setAvailable(true);
						notifyAll();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}

	}

	/**
	 * Metodo que pregunta si el stock de cervezas esta lleno, en caso de no estar
	 * lleno hace la acción, si esta lleno emite un mensaje en pantalla, la acción
	 * consta de añadir la cerveza que produce este productor hasta que llega a 100
	 * que es la capacidad maxima, en caso de que llegue setea el stock en full y
	 * abre las puertas del bar
	 * 
	 * @param producter
	 * @throws InterruptedException
	 */
	private synchronized void reloadBeer(BeerProducter producter) throws InterruptedException {
		if (this.getFullStock().equals(false)) {
			stock.add(producter.produceBeer());
			System.out.println("El productor " + producter.getFirstName() + " " + producter.getLastName()
					+ " produce una: \n " + producter.getBeerType().toString());
			System.out.println("El stock es de " + this.stock.size() + "\n");
			if (stock.size() == 100) {
				this.setFullStock(true);
				this.open();
			}
		} else {
			System.out.println("El productor " + producter.getFirstName() + " " + producter.getLastName()
					+ " encuentra que el bar tiene la capacidad llena y no produce cerveza \n ");
		}

	}

	/**
	 * Metodo sincronizado, inicializa una bandera para saber si contiene la cerveza
	 * favorita del BeerConsumer, recorre la lista en busca de la cerveza favorita,
	 * si la contiene no consume en este ciclo y cierra la ejecucion, en caso de no
	 * tener la favorita consume la primera que encuentra.
	 * 
	 * @param consumer
	 * @throws InterruptedException
	 */
	private synchronized void saleBeer(BeerConsumer consumer) throws InterruptedException {
		int flag = 0;
		for (Beer beer : stock) {
			if (beer.getName().equals(consumer.getFavoriteBeer().getName())) {
				stock.remove(beer);
				System.out.println("El bar " + this.getName() + " tiene la cerveza favorita de "
						+ consumer.getFirstName() + " una " + consumer.getFavoriteBeer().getName()
						+ ", entonces se toma una de estas \n Luego de consumir esta cerveza quedan "
						+ this.stock.size() + " cervezas en el bar\n");
				flag = 1;
				break;
			}

		}
		if (flag == 0) {
			Beer choice = stock.remove(0);
			System.out.println(consumer.getFirstName() + " se bebe una " + choice.getName() + " que es una "
					+ choice.getType() + " y su ibu es de " + choice.getIbu()
					+ "\n Luego de consumir esta cerveza quedan " + this.stock.size() + " cervezas en el bar\n");
		}

	}

	public void close() {
		this.setState(false);
	}

	public void open() {
		this.setState(true);
	}

	public boolean isEmpty() {
		if (this.stock.size() == 0 || this.stock == null) {
			return true;
		} else {
			return false;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStock(ArrayList<Beer> stock) {
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

	public ArrayList<Beer> getStock() {
		return this.stock;
	}

	public Boolean getState() {
		return this.state;
	}

	public Boolean getFullStock() {
		return this.fullStock;
	}

	public void setFullStock(boolean bool) {
		this.fullStock = bool;
	}

	public Boolean getAvailable() {
		return this.available;
	}
}
