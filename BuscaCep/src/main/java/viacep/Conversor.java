package viacep;

import java.io.BufferedReader;
import java.io.IOException;

public class Conversor{
	public static String converteJsonEmString(BufferedReader json) throws IOException {
		String resposta, jsonString = "";
		
		while((resposta = json.readLine()) != null)
			jsonString += resposta;
		
		return jsonString;
	}
}
