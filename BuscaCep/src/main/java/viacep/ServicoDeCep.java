package viacep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import dominio.Endereco;

public class ServicoDeCep {
	public static Endereco buscaEnderecoPelo(String cep) {

		try {
			URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != 200) {
				throw new RuntimeException("Erro: " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

			String jsonEmSring = Conversor.converteJsonEmString(resposta);

			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(jsonEmSring, Endereco.class);

			return endereco;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
