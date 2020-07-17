package recursion;


//*****************************passing output in parameter*************************

public class RemoveCharacFromString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(remove("bello",'l',""));
		

	}
	
	static String remove(String str, char remove,String output) {
		
		if(str.length() == 0) {return output;}
		
		if(str.charAt(0) != remove) {
			output += str.charAt(0);
		}
		System.out.println(output.getBytes());
		return remove(str.substring(1),'l',output);
	}
	
	

}
