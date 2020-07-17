package recursion;


//*****************************using substring*************************

public class RemoveCharacFromString3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(remove("Hellol",2));

	}
	
	static String remove(String str, int index) {
		
		if(!str.contains("l")) {return str;}
		
		//System.out.println("Index: " + index + " String: "+str);
		
		str = str.substring(0,index) + str.substring(index+1);
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == 'l') {
				index = i;
			}
		}
		
		//System.out.println("After Index: " + index + " After String: "+str + " length: " + str.length());

		
		return remove(str,index);
	}

}
