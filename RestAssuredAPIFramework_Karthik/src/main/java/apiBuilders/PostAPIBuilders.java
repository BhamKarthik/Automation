package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilders {

	
	public Map<String,String> PostRequestBody(){
		Map<String,String> body= new HashMap<String, String>();
		body.put("cart_key", "271237");
		body.put("portal_id", "103");
		body.put("cart_type", "normal");
		body.put("pin_code", "410210");
		return body;
	}
	
}
