package Projeto3;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Device1 {
    public static void main(String[] args) {
        final int porta = 12345;

        try (ServerSocket servidor = new ServerSocket(porta)) {
            System.out.println("Device1 esperando conexão na porta " + porta);

            // Aguarda a conexão do Device2
            Socket clienteSocket = servidor.accept();
            System.out.println("Device1 conectado a " + clienteSocket.getInetAddress());

            // Cria a mensagem JSON
            JSONObject mensagemJSON = new JSONObject();
            mensagemJSON.put("mensagem", "Olá, dispositivo 2!");

            // Envia a mensagem JSON para o Device2
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream());
            out.println(mensagemJSON.toJSONString());
            out.flush();

            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
