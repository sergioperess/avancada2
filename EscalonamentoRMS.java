package Projeto4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class EscalonamentoRMS {

    public static void main(String[] args) {
        // Criando as tarefas periódicas (ID, Período, Deadline, Tempo de Execução)
        TarefaPeriodica tarefa1 = new TarefaPeriodica(1, 10, 8, 3);
        TarefaPeriodica tarefa2 = new TarefaPeriodica(2, 5, 4, 2);
        TarefaPeriodica tarefa3 = new TarefaPeriodica(3, 20, 18, 6);

        // Adicionando as tarefas em uma lista
        List<TarefaPeriodica> tarefas = new ArrayList<>();
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefas.add(tarefa3);

        // Ordenando as tarefas de acordo com o período (ordem crescente)
        Collections.sort(tarefas, Comparator.comparingInt(TarefaPeriodica::getPeriodo));

        // Realizando o escalonamento RMS
        int tempo = 0;
        for (TarefaPeriodica tarefa : tarefas) {
            while (tempo < tarefa.getDeadline()) {
                // Executando a tarefa
                System.out.println("Tempo " + tempo + ": Executando Tarefa " + tarefa.getId());

                tempo += tarefa.getTempoExecucao();

                // Verificando se a tarefa atendeu ao deadline
                if (tempo > tarefa.getDeadline()) {
                    System.out.println("Tarefa " + tarefa.getId() + " não atendeu ao deadline!");
                }

                // Incrementando o tempo para o próximo ciclo da tarefa
                tempo += tarefa.getPeriodo() - tarefa.getTempoExecucao();
            }
        }
    }


static class TarefaPeriodica {
    private int id;
    private int periodo;
    private int deadline;
    private int tempoExecucao;

    public TarefaPeriodica(int id, int periodo, int deadline, int tempoExecucao) {
        this.id = id;
        this.periodo = periodo;
        this.deadline = deadline;
        this.tempoExecucao = tempoExecucao;
    }

    public int getId() {
        return id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }
}
}

