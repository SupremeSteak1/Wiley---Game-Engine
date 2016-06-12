package game;

import java.util.ArrayList;

public class Inventory {
	
	//For sorting
	//0 is unassigned for error avoidance
	public static final int ITEM_TYPE = 1;
	public static final int ITEM_ID = 2;
	public static final int ITEM_NAME = 3;

	private ArrayList<Item> items;
	private Player player;
	
	public Inventory(Player player){
		this.player = player;
		items = new ArrayList<>();
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void sort(int sortBy){
		ArrayList<Item> sorted = new ArrayList<Item>();
		ArrayList<Item> itemsCopy = items;
		Item min;
		switch(sortBy){
		//InsertionSort ftw on small lists
		case 1:
			for(int i = 0; i < items.size(); i++){
				min = itemsCopy.get(0);
				for(Item it : itemsCopy){
					if(it.getType().ordinal() < min.getType().ordinal()){
						min = it;
					}
				}
				sorted.add(itemsCopy.remove(itemsCopy.indexOf(min)));
			}
			break;
		case 2:
			for(int i = 0; i < items.size(); i++){
				min = itemsCopy.get(0);
				for(Item it : itemsCopy){
					if(it.getItemID() < min.getItemID()){
						min = it;
					}
				}
				sorted.add(itemsCopy.remove(itemsCopy.indexOf(min)));
			}
			break;
		case 3:
			for(int i = 0; i < items.size(); i++){
				min = itemsCopy.get(0);
				for(Item it : itemsCopy){
					if(it.getName().compareTo(min.getName()) < 0){
						min = it;
					}
				}
				sorted.add(itemsCopy.remove(itemsCopy.indexOf(min)));
			}
			break;
		default:
			System.err.println("Bad input on inventory sorting");
		}
		items = sorted;
	}
	
}
