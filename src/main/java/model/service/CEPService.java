package model.service;

import com.google.gson.Gson;
import model.entity.Endereco;
import model.exception.ConsultaException;
import model.util.EnderecoUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CEPService {
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    private static Endereco endereco = null;

    public static Endereco buscarEnderecoPeloCep(String cep) {
        //viacep.com.br/ws/cep/json
        String formatUrl = webService + cep + "/json";
        try {
            URL url = new URL(formatUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == codigoSucesso) {
                BufferedReader resp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String jsonToString = EnderecoUtil.convertJsonToString(resp);
                Gson gson = new Gson();
                endereco = gson.fromJson(jsonToString, Endereco.class);
                return endereco;
            }
            throw new ConsultaException("Http response code " + connection.getResponseCode() + "" +
                    ": Erro ao consultar cep ");


        } catch (Exception e) {
            throw new ConsultaException(e.getMessage());
        }
    }

    public static Endereco consultarEnderecoPelaRua(String uf, String cidade, String logradouro) {
        //viacep.com.br/ws/RS/Porto Alegre/Domingos+Jose/json/

        return null;
    }
}
