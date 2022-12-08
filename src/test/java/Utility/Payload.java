package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Payload {
	
	public static String jsonPath = "vcbshdhdvchevbhfbvfhvbjdshbhjv.json";
	
	//Enter the query params valuein the below list
	//public List<String> list = new ArrayList<String>(Arrays.asList("api-key","test" ,"host","hostvalue","value1"));

//	//if query params have 3 set of values or more
	public static Map<String,String> setQueryParams(List<String> list) {
			
			
			Map<String,String> map = new HashMap<String, String>();
			int size = list.size();
				if(size>4) {
				for(int i=0;i<size;i++) {
					
					map.put(list.get(i*2), list.get((i*2)+1));
				}
				}else if (size==4){
				map.put(list.get(0), list.get(1));
				map.put(list.get(2), list.get(3));	
				}
			return map;	
		}
		
///////////////////////////////////////***************enter the body parameter in the body string**********///////////////////
	public static String payload() {
		
		//paste the request body in b/w the quotes
		String body="{\n"
				+ "    \"user_id\": 96479162\n"
				+ "}";
		return body;
	}
	
//////////////////////*******************************Json file as Payload ******************///////////////////////////////////
	
	public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(jsonPath)));

	}
	
	
	
	
	
	
	

	

}
