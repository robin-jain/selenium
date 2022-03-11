package orange;

import java.util.Arrays;

public class test {
	public static void main(String []args) {
		test j=new test();
		String uu= "( Username : Admin | Password : admin123 )";
		String [] arr=j.getuserPass(uu);
		System.out.println(Arrays.toString(arr));
		String a=arr[0];
		
	}		

public  String [] getuserPass(String m) {
	int iCount=0;
	String[] strAr3= new String[2];
		 	 String[] t =m.split(" ");
	 for (int i=0;i<t.length;i++) {
		//System.out.println(t[i]);
		if (t[i].equalsIgnoreCase(":")) {
			 if(iCount==0) {
				 strAr3[0]=t[i+1];
				 iCount=iCount+1;
			 }else {
				 strAr3[1]=t[i-1]; 
			 	}
			}

	 	}
	return strAr3;

	}
}
