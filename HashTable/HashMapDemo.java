package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create
		Map<String, Integer> phoneMap = new HashMap<>();
		//putting key values
		phoneMap.put("ram",101);
		phoneMap.put("shyam",202);
		phoneMap.put("tim", 303);
		phoneMap.put("bhim", 404);
		
		System.out.println(phoneMap.get("ram")); //to get the value of the key
		
		System.out.println("**************Set Method*******************");
		
		//traverse
		//legacy method
		//not sequential
		Set<String> keys = phoneMap.keySet();
		
		for(String key : keys) {
			System.out.println(key + " => " + phoneMap.get(key));
		}
		
		System.out.println("**************After Remove******************");
		System.out.println();

		
		//remove
		phoneMap.remove("shyam");
		
		System.out.println(phoneMap);
		System.out.println();
		
		System.out.println("**************Map Method*********************");
		
		
		//Map.Entry both are interface which will give a sub-map i.e. key & value
		//entrySet() will give both key, value
		for(Map.Entry<String, Integer> map : phoneMap.entrySet()) {
			System.out.println(map.getKey() + " => " + map.getValue());
		}
		
		
		System.out.println("**************Search Method*********************");

		String result = phoneMap.containsKey("tim")?"Found":"Not Found";
		
		System.out.println(result);
		

	}

}
