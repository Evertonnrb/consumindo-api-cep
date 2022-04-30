import model.entity.Endereco;
import model.service.CEPService;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe seu cep : ");
        String cep = in.next();

        Endereco endereco = CEPService.buscarEnderecoPeloCep(cep);
        if (endereco != null) {
            System.out.println("CEP não encontrado");
        } else {
            System.out.println("CEP :" + endereco.toString());
        }
    }
}
