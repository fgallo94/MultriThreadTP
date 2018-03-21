import java.util.ArrayList;
import java.util.List;

import models.Beer;
import models.BeerConsumer;
import models.BeerHouse;
import models.BeerProducter;
import models.Person;

public class Main {

		public static void main(String [] args) {
			BeerHouse beerHouse= new BeerHouse("BrewHouse", "Guemes 3251");
			
			Beer type1 =new Beer("Best Barley","Barley Wine",53.0);
			Beer type2 =new Beer("Honey Moon","Honey",14.5);
			Beer type3 =new Beer("Indiana Jones","Indian Pale Ale",200.0);
			
			//beerProducter.getFirstName(), beerProducter.getLastName(), beerProducter.getAddress(),beerProducter.getAge()
			BeerProducter producter1 = new BeerProducter("Pedro","Aznar","Tulipanes 1234",35);
			producter1.setBeerType(type1);
			producter1.setBeerHouse(beerHouse);
			
			BeerProducter producter2 = new BeerProducter("Luis","Majul","Asder 1476",35);
			producter2.setBeerType(type2);
			producter2.setBeerHouse(beerHouse);
			
			BeerProducter producter3 = new BeerProducter("Ace","Ventura","Selva 4875",35);
			producter3.setBeerType(type3);
			producter3.setBeerHouse(beerHouse);
			
			BeerConsumer consumer1 = new BeerConsumer("Luke","Skywalker","Galaxia 3756",21);
			consumer1.setFavoriteBeer(type1);
			consumer1.setUbication(beerHouse);
			
			BeerConsumer consumer2 = new BeerConsumer("Obi Wan","Kenobi","Galaxia 4573",45);
			consumer2.setFavoriteBeer(type2);
			consumer2.setUbication(beerHouse);
			
			
//			producter1.run();
//			producter2.run();
//			producter3.run();
			beerHouse.setState(true);
			ArrayList<Beer> lista=new ArrayList<Beer>();
			lista.add(type1);
			lista.add(type2);
			lista.add(type3);
			lista.add(type1);
			lista.add(type2);
			lista.add(type3);
			lista.add(type1);
			lista.add(type2);
			lista.add(type3);
			lista.add(type1);
			lista.add(type2);
			lista.add(type3);
			beerHouse.setStock(lista);
			consumer1.run();
			consumer2.run();
			
		}
}
