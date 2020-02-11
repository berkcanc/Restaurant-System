import java.util.*;

public class Waiter 
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

	@SuppressWarnings("resource")
	public void masaAc(TableList t) 
	{
		TableInformation tableInfo = new TableInformation();
		System.out.println("Yeni açýlacak olan masanýn numarasý giriniz : ");
		Scanner yeniMasa2 = new Scanner(System.in);
		int masaNo2 = yeniMasa2.nextInt();
		tableInfo.setMasaNo(masaNo2);
		Customer c1 = new Customer();
		tableInfo.setCustomer(c1);
		
		t.tableList.add(tableInfo);
	}
	
	@SuppressWarnings("resource")
	public void SiparisEkle(TableList t,ItemList newItem)
	{
		System.out.println("Sipariþ eklemek istediðiniz masanýn numarasýný giriniz : ");
		Scanner yeniMasa3 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Scanner selectionscan = new Scanner(System.in);
		
		
		
		int masaNo3 = yeniMasa3.nextInt();
		int sayi=0,selection=2 ;
		for(int i=0;i<t.tableList.size();i++)
		{
			if(t.tableList.get(i).masaNo == masaNo3)
				sayi=i;
		}
		
		
		do
		{
			
			System.out.println("MENU");
			   for(int i=0;i<newItem.getOrderList().size();i++) 
					System.out.println("Ürün: "+newItem.getOrderList().get(i).getOrderName()+
							" -- "+newItem.getOrderList().get(i).getOrderCost()+" TL");
			   
			   	System.out.println("Ürün giriniz : ");
				String urun = sc.nextLine();
				t.tableList.get(sayi).ItemName.add(urun);
				System.out.println("Sipariþ eklemeye devam etmek için 1,çýkmak için 0");
				selection = selectionscan.nextInt();
				
			
		}while(selection != 0);
		
		t.tableList.get(sayi).totalCost = t.tableList.get(sayi).calculate(t.tableList.get(sayi).ItemName, newItem);
		
	}
	
	
	
	
	
	
	
	
}
