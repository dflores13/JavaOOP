import java.util.Random;
public class Consumer extends Entity implements Buyer{
	Random r = new Random();

	public Consumer() {
		
	}
	public Consumer(String nameConsumer, double budgetConsumer, double amountOfProductConsumer) {
		name = nameConsumer;
		budget = budgetConsumer;
		amountOfProduct = amountOfProductConsumer;
		
	}

	@Override
	public void buy(Entity mm) {
		if (budget - ((MiddleMan)mm).getCostToBuyProduct() <= 0) {
			System.out.println( name +" cannot buy because consumer have no money");
			return;
		}
		 if (mm.amountOfProduct <= 0 ) {
			System.out.println(name + " cannot buy because " + mm.name + "is out of stock");
			return;
		}
		if(mm instanceof Seller) {
			
			amountOfProduct += 1;
		}
		if(mm instanceof Seller) {
			mm.amountOfProduct = mm.amountOfProduct - 1;
		}
		if(mm instanceof Seller) {
			budget =  budget - ((MiddleMan) mm).getCostToSellProduct();
			mm.budget = mm.budget + ((MiddleMan) mm).getCostToSellProduct();
		}
		System.out.println(name + " buys from " + mm.name + ". " + mm.name + " has " + mm.amountOfProduct + " product(s) left and " + mm.budget + " budget. " + name + " has " + amountOfProduct + " product(s) and " + budget + " budget."  );
		
	}

	@Override
	public void negotiate(Entity mm)	{
		if(!(mm instanceof Entity)) { 
			System.out.println("Is not an Entity");
			return;
		}
		if (r.nextBoolean() == false) {
				System.out.println("Negotiating has failed");
				return;
		}
		else if(r.nextBoolean() == true){
			((MiddleMan) mm).changeCost(-1.0);
			System.out.println("Negotiating is successful");
		}
		if (((MiddleMan) mm).getCostToBuyProduct()== 0) {
			System.out.println("Cannot negotiate the cost is already 0, Negotiating successful doe");
		}
		
	}

}
