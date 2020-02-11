import java.util.*;
public class TableInformation {
	public int masaNo;
	ArrayList<String> ItemName = new ArrayList<String>();
	public double totalCost;
	public Customer customer;
	
	
	public TableInformation() 
	{
		Customer c1 = new Customer();
		this.customer = c1;
	}
	public int getMasaNo() {
		return masaNo;
	}
	public void setMasaNo(int masaNo) {
		this.masaNo = masaNo;
	}
	public ArrayList<String> getItemName() {
		return ItemName;
	}
	public void setItemName(ArrayList<String> itemName) {
		ItemName.addAll(itemName);
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double calculate(ArrayList<String> a,ItemList itemList)
	{
		double sum = 0;
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<itemList.getOrderList().size();j++)
			{
				if(a.get(i).equalsIgnoreCase(itemList.getOrderList().get(j).getOrderName()) ) 
				{
					sum = sum + itemList.getOrderList().get(j).getOrderCost();
					
				}
			}
		}
		return sum;
	}
	
}
