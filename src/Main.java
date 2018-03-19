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
			BeerProducter producter1 = new Person("Pedro","Aznar","Tulipanes 1234",35);
			producter1.setBeerType(type1);
			
			BeerProducter producter2 = new Person("Luis","Majul","Asder 1476",35);
			producter2.setBeerType(type2);
			
			BeerProducter producter3 = new Person("Ace","Ventura","Selva 4875",35);
			producter3.setBeerType(type3);
			
			BeerConsumer consumer1 = new Person("Luke","Skywalker","Galaxia 3756",21);
			consumer1.setFavoriteBeer(type1);
			
			BeerConsumer consumer2 = new Person("Obi Wan","Kenobi","Galaxia 4573",45);
			consumer2.setFavoriteBeer(type2);
			
			consumer1.start();
			consumer2.start();
			producter1.start();
		}
}
