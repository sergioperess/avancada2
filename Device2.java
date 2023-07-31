package Projeto3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Device2 {
    public static void main(String[] args) {
        final String enderecoIP = "localhost"; // Ou substitua pelo endereço IP do Device1
        final int porta = 3333;

        try (Socket socket = new Socket(enderecoIP, porta);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream out = socket.getOutputStream()) {

            // Cria uma nova thread para receber e processar a mensagem do Device1
            Thread receiverThread = new Thread(() -> {
                try {
                    // Recebe a mensagem JSON do Device1
                    String mensagemRecebida = in.readLine();

                    // Simula um processamento bem-sucedido da mensagem
                    JSONParser parser = new JSONParser();
                    JSONObject mensagemJSON = (JSONObject) parser.parse(mensagemRecebida);

                    // Exibe a mensagem do Device1
                    System.out.println("Mensagem recebida do Device1: " + mensagemJSON.get("mensagem"));

                    // Envia confirmação de recebimento ao Device1
                    out.write(1);
                    out.flush();
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            });

            // Inicia a thread para recebimento e processamento
            receiverThread.start();

            // Aguarda o término da thread de recebimento antes de fechar a conexão
            receiverThread.join();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
