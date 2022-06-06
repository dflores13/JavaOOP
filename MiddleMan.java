import java.util.Random;

public class MiddleMan extends Entity implements Buyer, Seller {
	Random r = new Random();
	private double costToBuyProduct;
	private double costToSellProduct;
	
	public MiddleMan() {
		
	}
	
	public MiddleMan(String nameMiddleMan, double budgetMiddleMan, double amountOfProductMiddleMan, double costToBuyProductMidMan, double costToSellProductMidMan) {
		costToBuyProduct = costToBuyProductMidMan;
		costToSellProduct = costToSellProductMidMan;
		name = nameMiddleMan;
		budget = budgetMiddleMan;
		amountOfProduct = amountOfProductMiddleMan;
	}
	
	public double getCostToBuyProduct() {
		return costToBuyProduct;
	}
	public void setCostToBuyProduct(double costToBuyProductMidMan) {
		costToBuyProduct = costToBuyProductMidMan;
	}
	public double getCostToSellProduct() {
		return costToSellProduct;
	}
	public void setCostToSellProduct(double costToSellProductMidMan) {
		costToSellProduct = costToSellProductMidMan;
	}

	@Override
	public void sell(Entity sellEntity) {
		if (getAmountOfProduct() <= 0) {
			System.out.println(sellEntity.name +" fails to sell because out of stock");
			return;
		}
		if(sellEntity.getBudget() - costToSellProduct <= 0) {
			System.out.println(sellEntity.name + " fails to sell because " + name + " has no money");
			return;
		}
		if(sellEntity instanceof Consumer) {
			setAmountOfProduct(getAmountOfProduct() - 1);
			sellEntity.setAmountOfProduct(sellEntity.getAmountOfProduct() + 1); 
		}
		if(sellEntity instanceof Consumer) {
			setBudget(getBudget() + costToSellProduct);
			sellEntity.setBudget(sellEntity.getBudget() - costToSellProduct);
		}
		System.out.println(sellEntity.name +" buys from " + name + ". " + name + " has " + amountOfProduct + " product(s) left and " + budget + " budget." + sellEntity.name + " has " + sellEntity.amountOfProduct + " product(s) and " + sellEntity.budget + " budget." );
		
	}

	@Override
	public double getCost(Entity costEntity) {
		if(Consumer.class.isInstance(costEntity)) {
			return costToSellProduct;
		}
		else if(Producer.class.isInstance(costEntity)) {
			return costToBuyProduct;
		}
		else {
			return 0;
		}
	}

	@Override
	public void changeCost(double newCost) {
		costToSellProduct += newCost;
		costToBuyProduct += newCost;
		
	}

	@Override
	public void buy(Entity buyEntity) {
		if(budget - costToBuyProduct <= 0) {
			System.out.println(name + " fails to buy because of no budget");
			return;
		}
		if(buyEntity.amountOfProduct <=0) {
			System.out.println(name + " fails to buy because " + buyEntity.name + " out of stock");
			return;
		}
		if(buyEntity instanceof Producer) {
			amountOfProduct = amountOfProduct +1 ;
		}
		if(buyEntity instanceof Producer){
			buyEntity.amountOfProduct = buyEntity.amountOfProduct - 1;
		}
		if(buyEntity instanceof Producer) {
			budget = budget - costToBuyProduct;
		}
		if(buyEntity instanceof Producer) {
			buyEntity.budget = buyEntity.budget + costToBuyProduct;
		}
		System.out.println(name + " buys from " + buyEntity.name + ". "+ buyEntity.name + " has " + buyEntity.amountOfProduct + " product(s) left and " + buyEntity.budget + " budget. " + name + " has " + amountOfProduct + " product(s) and " + budget + " budget.");
		
		
	}

	@Override
	public void negotiate(Entity entity) {
		if (r.nextBoolean() == false) {
			System.out.println("Negotiating has failed");
			return;
		}
		else if(r.nextBoolean() == true){
			((Producer) entity).changeCost(-1.0);
			System.out.println("Negotiating is successful");
		}
		if(entity instanceof Producer) {
			costToBuyProduct = costToBuyProduct -1 ;
		}
		if(entity instanceof Consumer){
			costToSellProduct = costToSellProduct +1 ;
		}
		if(costToBuyProduct < 0) {
			System.out.println("Cannot negotiate cost to be less than 0");
		}
		System.out.println("Cost to sell product " + costToBuyProduct);
		
		
		
	}
	

}
