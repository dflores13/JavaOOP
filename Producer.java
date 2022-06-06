import java.util.Random;
public class Producer extends Entity implements Seller {
	Random r = new Random();
	private double costOfProduct;
	
	public Producer() {
		
	}
	public Producer(String nameProducer, double budgetProducer, double amountOfProductProducer, double costOfProductProducer) {
		name = nameProducer;
		budget = budgetProducer;
		amountOfProduct = amountOfProductProducer;
		costOfProduct = costOfProductProducer;
	}
	public double getCostOfProduct() {
		return costOfProduct;
	}
	public void setCostOfProduct(double costOfProductProducer) {
		costOfProduct = costOfProductProducer;
	}

	@Override
	public void sell(Entity sellEntity) {
		if(amountOfProduct <= 0) {
			System.out.println(name + " fails to sell because out of stock");
			return;
		}
		if(sellEntity.budget - costOfProduct <= 0) {
			System.out.println(sellEntity.name + " fails to buy from " + name + " cause no money");
			return;
		}
		if(sellEntity instanceof Buyer) {
			--amountOfProduct;
			++sellEntity.amountOfProduct;
		}
		if(sellEntity instanceof MiddleMan) {
			budget = budget + ((MiddleMan) sellEntity).getCostToBuyProduct();
			sellEntity.budget = sellEntity.budget - ((MiddleMan) sellEntity).getCostToBuyProduct();
		}
		if(sellEntity instanceof Consumer) {
			budget = costOfProduct + budget;
			sellEntity.budget = sellEntity.budget - costOfProduct;
		}
		System.out.println(sellEntity.getName() + " buys from " + name +". " + name + " has " +amountOfProduct +" product(s) left and " + budget + " budget." + sellEntity.name + " has " + sellEntity.amountOfProduct + " product(s) and " + sellEntity.budget + " budget.");
		
	}

	@Override
	public double getCost(Entity costEntity) {
		return costOfProduct;
	}

	@Override
	public void changeCost(double newCost) {
		costOfProduct += newCost;
		
	}

	@Override
	public void negotiate(Entity entity) {
		if(!(entity instanceof Entity)) {
			System.out.println("Is not an Entity");
		}
		else {
			if (r.nextBoolean() == false) {
				System.out.println("Negotiating has failed");
			}
			else if (r.nextBoolean() == true) {
				System.out.println("Negotiating is successful");
			}
			else if(entity instanceof Consumer) { // nice
				costOfProduct += 1;
				
			}
			else if(entity instanceof MiddleMan) {
				costOfProduct += 1;
				((MiddleMan) entity).setCostToBuyProduct(((MiddleMan) entity).getCostToBuyProduct() + 1);
				
			}
			System.out.println("new cost of product " + costOfProduct);
			
		}
		
	}

	

}
