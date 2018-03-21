import java.util.ArrayList;
import java.util.List;

import models.Beer;
import models.BeerConsumer;
import models.BeerHouse;
import models.BeerProducter;
import models.Person;

public class Main {
	/**
	 * Main: 1-Inicializó el bar. 2-Creo los tipos de cervezas. 3-Inizializo 3
	 * productores. 4-le seteo el tipo de cerveza que produce y a que bar abastece,
	 * en este caso siempre al mismo. 5-Creo los consumidores. 6-Seteo la cerveza
	 * favorita de cada consumido y a que bar acuden a beber. 7-Cierro el bar
	 * 8-Instancio los Threads y comienza la ejecución
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 1
		BeerHouse beerHouse = new BeerHouse("BrewHouse", "Guemes 3251");
		// 2
		Beer type1 = new Beer("Best Barley", "Barley Wine", 53.0);
		Beer type2 = new Beer("Honey Moon", "Honey", 14.5);
		Beer type3 = new Beer("Indiana Jones", "Indian Pale Ale", 200.0);
		// 3
		BeerProducter producter1 = new BeerProducter("Pedro", "Aznar", "Tulipanes 1234", 35);
		// 4
		producter1.setBeerType(type1);
		producter1.setBeerHouse(beerHouse);

		BeerProducter producter2 = new BeerProducter("Luis", "Majul", "Asder 1476", 35);
		producter2.setBeerType(type2);
		producter2.setBeerHouse(beerHouse);

		BeerProducter producter3 = new BeerProducter("Ace", "Ventura", "Selva 4875", 35);
		producter3.setBeerType(type3);
		producter3.setBeerHouse(beerHouse);
		// 5
		BeerConsumer consumer1 = new BeerConsumer("Luke", "Skywalker", "Galaxia 3756", 21);
		// 6
		consumer1.setFavoriteBeer(type1);
		consumer1.setUbication(beerHouse);

		BeerConsumer consumer2 = new BeerConsumer("Obi Wan", "Kenobi", "Galaxia 4573", 45);
		consumer2.setFavoriteBeer(type2);
		consumer2.setUbication(beerHouse);
		// 7
		beerHouse.setState(false);

		// 8
		Thread t1 = new Thread(consumer1);
		Thread t2 = new Thread(consumer2);
		Thread t3 = new Thread(producter1);
		Thread t4 = new Thread(producter2);
		Thread t5 = new Thread(producter3);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}
}
