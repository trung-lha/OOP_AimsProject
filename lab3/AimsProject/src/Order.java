
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	int qtyOrder = 0;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrder < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrder] = disc;
			qtyOrder++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The order is almost full");
			System.exit(0);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i=0;
		for (i=0;i<qtyOrder;i++) {
			if(itemsOrdered[i] == disc) {
				if(i == qtyOrder -1){
					itemsOrdered[i] = null;
					qtyOrder--;
					System.out.println("The disc name "+ disc.getTitle()+ " has removed");
					return;
				}
				for(int j = i; j< qtyOrder; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				break;
			}
		}
		i++;
		if(i > qtyOrder) {
			System.out.println("Cann't find the disc that you want to remove");
		}
		else {
			itemsOrdered[i-1] = null;
			qtyOrder--;
			System.out.println("The disc name "+ disc.getTitle()+ " has removed");
		}
		
	}
	public float totalCost(){
		int i=0;
		float total = 0,cost;
		for(i = 0; i< qtyOrder;i++) {
			cost = itemsOrdered[i].getCost();
			total = total+cost;
		}
		return total;
	}
}
