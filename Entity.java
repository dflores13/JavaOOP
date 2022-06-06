
public abstract class Entity {
	public String name;
	public double budget;
	public double amountOfProduct;
	
	public Entity(){
		
	}
	public Entity(String nameEntity, double budgetEntity, double amountOfProductEntity) {
		name = nameEntity;
		budget = budgetEntity;
		amountOfProduct = amountOfProductEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameEntity) {
		this.name = nameEntity;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budgetEntity) {
		this.budget = budgetEntity;
	}
	public double getAmountOfProduct() {
		return amountOfProduct;
	}
	public void setAmountOfProduct(double amountOfProductEntity) {
		this.amountOfProduct = amountOfProductEntity;
	}
	public abstract void negotiate(Entity entity);
	
}
