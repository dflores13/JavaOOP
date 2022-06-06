
public interface Seller {
	public abstract void sell(Entity sellEntity);
	public abstract double getCost(Entity costEntity);
	public abstract void changeCost(double newCostOfEntity);
}
