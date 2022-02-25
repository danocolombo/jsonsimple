package jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonsimplemain {

	public static void main(String[] args) throws ParseException, IOException {
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader("./jsonfiles/user.json");
		
		Object obj=jsonparser.parse(reader);
		/* obj is java object, now need to cast to JSON object */
		JSONObject userjsonobj = (JSONObject)obj;
		
		String uid = (String) userjsonobj.get("uid");
		String fname = (String) userjsonobj.get("firstName");
		String lname = (String) userjsonobj.get("lastName");
		
		// get JSON array of children
		JSONArray kids = (JSONArray) userjsonobj.get("children");
		for(int i=0; i < kids.size(); i++){
			JSONObject kid = (JSONObject)kids.get(i);
			String kName = (String) kid.get("name");
			long age = (long) kid.get("age");
			System.out.println(kName + " is " + age + " years old");
		}
		System.out.println("\nparent info:");
		System.out.println("id:" + uid);
		System.out.println("name: " + fname + " " + lname);
		

	}

}
