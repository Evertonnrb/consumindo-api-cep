package model.util;

import java.io.BufferedReader;
import java.io.IOException;

public class EnderecoUtil {
    public static String convertJsonToString(BufferedReader resp) throws IOException {
        String resposta, jsonString = "";
        while ((resposta = resp.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }
}
