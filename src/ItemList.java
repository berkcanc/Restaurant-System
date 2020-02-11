import java.util.ArrayList;

public class ItemList {
	
	public ArrayList<ItemType> itemList;
	
	
	public ItemList() {
		itemList =new ArrayList<ItemType>();
		
	}

	public ArrayList<ItemType> getOrderList() {
		return itemList;
	}

	public void setOrderList(ItemType orderType) {
		itemList.add(orderType);
	}
	

}
