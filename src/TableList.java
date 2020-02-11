import java.util.*;
public class TableList {
	
	ArrayList<TableInformation> tableList;
	
	public TableList()
	{	
		tableList=new ArrayList<TableInformation>();
	}
	
	public ArrayList<TableInformation> getTableList()
	{
		return tableList;
	}
	
	public void addTableList(TableInformation tableList)
	{
		this.tableList.add(tableList);
	}
	
}
