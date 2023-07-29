import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Device2 {
    public static void main(String[] args) {
        final String enderecoIP = "localhost"; // Ou substitua pelo endereço IP do Device1
        final int porta = 12345;

        try (Socket socket = new Socket(enderecoIP, porta);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Recebe a mensagem JSON do Device1
            String mensagemRecebida = in.readLine();

            // Analisa a mensagem JSON recebida
            JSONParser parser = new JSONParser();
            JSONObject mensagemJSON = (JSONObject) parser.parse(mensagemRecebida);

            // Exibe a mensagem do Device1
            System.out.println("Mensagem recebida do Device1: " + mensagemJSON.get("mensagem"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
