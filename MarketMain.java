import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class MarketMain {

	public static void main(String[] args) {
		Random r = new Random();
		
		List <Entity> entities = new ArrayList<Entity>();
		Consumer c1 = new Consumer("Chelsey", 1000.0, 4.0);
		MiddleMan m1 = new MiddleMan("Amazon", 200, 100.0, 50.0, 50.0);
		Producer p1 = new Producer("Purell", 150, 310.0, 50.0);
		
		entities.add(c1);
		entities.add(m1);
		entities.add(p1);
		
		
		
		
		while(c1.budget > 50 && p1.amountOfProduct > 0 && m1.amountOfProduct >0) {
			
			
			c1.negotiate(m1);
			c1.buy(m1);

			
			m1.negotiate(p1);
			m1.buy(p1);
			
			p1.negotiate(m1);
			p1.sell(m1);
			
		}
	}

}
