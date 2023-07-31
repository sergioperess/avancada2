package Projeto1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tempoDeslocamentoVeiculo1 = 30;
        int tempoDeslocamentoVeiculo2 = 25;
        ServicoTransporte servico = new ServicoTransporte(1, "2023-07-26 09:00", tempoDeslocamentoVeiculo1, tempoDeslocamentoVeiculo2);

        // Utilizamos uma lista para armazenar as threads para posteriormente aguardar a conclusão de todas
        List<Thread> threads = new ArrayList<>();

        Passageiro passageiro1 = new Passageiro("João");
        Passageiro passageiro2 = new Passageiro("Maria");
        Carga carga1 = new Carga("Caixas");
        Carga carga2 = new Carga("Encomendas");
        Motorista motorista1 = new Motorista("Carlos");
        Motorista motorista2 = new Motorista("Ana");

        // Threads para adicionar passageiros, cargas e motoristas
        threads.add(new Thread(() -> servico.adicionarPassageiro(passageiro1)));
        threads.add(new Thread(() -> servico.adicionarPassageiro(passageiro2)));
        threads.add(new Thread(() -> servico.adicionarCarga(carga1)));
        threads.add(new Thread(() -> servico.adicionarCarga(carga2)));
        threads.add(new Thread(() -> servico.adicionarMotorista(motorista1)));
        threads.add(new Thread(() -> servico.adicionarMotorista(motorista2)));

        // Iniciamos todas as threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Aguardamos a conclusão de todas as threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Serviço de Transporte " + servico.getId() + ":");
        System.out.println("Data/Hora de Início: " + servico.getDataHoraInicio());
        System.out.println("Data/Hora de Fim: " + servico.getDataHoraFim());

        System.out.println("\nPassageiros:");
        for (Passageiro passageiro : servico.getPassageiros()) {
            System.out.println("Nome: " + passageiro.getNome());
        }

        System.out.println("\nCargas:");
        for (Carga carga : servico.getCargas()) {
            System.out.println("Descrição: " + carga.getDescricao());
        }

        System.out.println("\nMotoristas:");
        for (Motorista motorista : servico.getMotoristas()) {
            System.out.println("Nome: " + motorista.getNome());
        }
    }
}