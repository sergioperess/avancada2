package Projeto4;

import java.util.ArrayList;
import java.util.List;

public class ReleaseJitterAnalysis {



    public static void main(String[] args) {
        // Criando as tarefas periódicas (Período, Release Jitter)
        TarefaPeriodica tarefa1 = new TarefaPeriodica(10, 11);
        TarefaPeriodica tarefa2 = new TarefaPeriodica(5, 7);
        TarefaPeriodica tarefa3 = new TarefaPeriodica(20, 4);

        // Adicionando as tarefas em uma lista
        List<TarefaPeriodica> tarefas = new ArrayList<>();
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefas.add(tarefa3);

        // Definindo a janela de tempo para análise
        int janela = 50;

        // Verificando se as tarefas são escalonáveis dentro da janela de tempo
        boolean escalonaveis = verificaEscalonabilidade(tarefas, janela);
        System.out.println("As tarefas são escalonáveis dentro da janela de tempo? " + escalonaveis);
    }
    
        public static boolean verificaEscalonabilidade(List<TarefaPeriodica> tarefas, int janela) {
        double limite = 0;
        for (TarefaPeriodica tarefa : tarefas) {
            limite += (double) (janela + tarefa.getReleaseJitter()) / tarefa.getPeriodo();
        }
        return limite <= 1;
    }
    
    static class TarefaPeriodica {
    private int periodo;
    private int releaseJitter;

    public TarefaPeriodica(int periodo, int releaseJitter) {
        this.periodo = periodo;
        this.releaseJitter = releaseJitter;
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getReleaseJitter() {
        return releaseJitter;
    }
}
    
}
