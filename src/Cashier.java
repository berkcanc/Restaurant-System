
public class Cashier extends MasaBul implements IKisiBilgileri,ICalisanBilgileri
{
	private String adSoyad;
	private String ePosta;
	private String telefon;
	private String departman;
	private String gorev;
	
	public String getAdSoyad() {
		return adSoyad;
	}


	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}


	public String getePosta() {
		return ePosta;
	}


	public void setePosta(String ePosta) {
		this.ePosta = ePosta;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getDepartman() {
		return departman;
	}


	public void setDepartman(String departman) {
		this.departman = departman;
	}


	public String getGorev() {
		return gorev;
	}


	public void setGorev(String gorev) {
		this.gorev = gorev;
	}


	public void fisBas(TableInformation tableInfo,ItemList newItem)
	{
		for(int a=0;a<tableInfo.ItemName.size();a++)
		{
			System.out.print(tableInfo.ItemName.get(a)+" ");
			for(int i=0;i<newItem.getOrderList().size();i++)
			{
				if(tableInfo.ItemName.get(a).equals(newItem.itemList.get(i).getOrderName()) )
					System.out.println(newItem.getOrderList().get(i).orderCost);
			}
		}
		System.out.println("Müþteri bilgileri : "+ tableInfo.customer.getAdSoyad() + " "
				+tableInfo.customer.getePosta() + " " + 
				tableInfo.customer.getTelefon() );
		System.out.println("Toplam ücret : " + tableInfo.getTotalCost());
		
	}
	
	
	@SuppressWarnings("resource")
	public void odemeYap(TableList tableList,ItemList newItem,int masaNumarasi)
	{
		   int sayi2 = 0;
		   sayi2=masabul(tableList,masaNumarasi);
				   
		   fisBas(tableList.tableList.get(sayi2),newItem);
		  
		   tableList.tableList.remove(sayi2);
		   
	}


	
	
	
}
