package Projeto3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;

public class Device1 {
    public static void main(String[] args) {
        final int porta = 3333;

        try (ServerSocket servidor = new ServerSocket(porta)) {
            System.out.println("Device1 esperando conexão na porta " + porta);

            while (true) {
                // Aguarda a conexão do Device2
                Socket clienteSocket = servidor.accept();
                System.out.println("Device1 conectado a " + clienteSocket.getInetAddress());

                // Cria a mensagem JSON
                JSONObject mensagemJSON = new JSONObject();
                mensagemJSON.put("mensagem", "Olá, dispositivo 2 xxxx!");

                // Cria uma nova thread para enviar a mensagem JSON para o Device2
                Thread senderThread = new Thread(() -> {
                    try {
                        PrintWriter out = new PrintWriter(clienteSocket.getOutputStream());

                        // Tenta enviar a mensagem 3 vezes em caso de falha
                        int tentativas = 0;
                        boolean enviado = false;
                        while (tentativas < 3 && !enviado) {
                            out.println(mensagemJSON.toJSONString());
                            out.flush();

                            // Espera a confirmação de recebimento do Device2
                            if (clienteSocket.getInputStream().read() == 1) {
                                enviado = true;
                                System.out.println("Mensagem enviada com sucesso para Device2.");
                            } else {
                                System.out.println("Falha no envio. Tentando novamente...");
                                tentativas++;
                                Thread.sleep(1000); // Aguarda 1 segundo antes de reenviar
                            }
                        }

                        // Fecha apenas o stream de saída (não fecha a conexão completa)
                        out.close();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                // Inicia a thread para envio
                senderThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
