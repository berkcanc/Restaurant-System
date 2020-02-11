
public abstract class MasaBul {
	
public static int masabul(TableList t,int sayi) {
	for(int i=0;i<t.tableList.size();i++)
	{
		if(t.tableList.get(i).masaNo == sayi)
			return i;
	}
	return -1;
}

}
