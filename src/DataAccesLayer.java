import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataAccesLayer 
{
	public void readingFromFile(ItemList itemList ) 
	{

		try 
		{
			Scanner items = new Scanner(new File("itemList.txt"));
	
			while (items.hasNextLine()) 
			{
				ItemType itemType = new ItemType();	
				String line = items.nextLine();
				StringTokenizer st = new StringTokenizer(line, ", ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				double cost = Double.parseDouble(st.nextToken());
				String itemName = name1 +" "+ name2;
				
				itemType.setOrderName(itemName);
				itemType.setOrderCost(cost);
				itemList.setOrderList(itemType);
				
			}
			items.close();
		} 
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}

	}

}
