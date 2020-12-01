package jsoncucc;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ObjectENZ1AT {
	public static void main(String[] args) {
		
		String s = "{\"nev\":\"Sara\",\"fizetes\":600000.0,\"kor\":27}";
		Object object = JSONValue.parse(s);
		JSONObject jsonObject = (JSONObject) object;
		
		String nev = (String) jsonObject.get("nev");
		double fizetes = (Double) jsonObject.get("fizetes");
		Integer kor = (Integer) jsonObject.get("kor");
		System.out.println(nev + " " + fizetes + " " + kor);
	}
}