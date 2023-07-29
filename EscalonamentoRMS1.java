package Projeto4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class EscalonamentoRMS1 {

    public static boolean verificaEscalonabilidade(List<TarefaPeriodica> tarefas) {
        int n = tarefas.size();
        double utilizacaoTotal = 0.0;
        for (TarefaPeriodica tarefa : tarefas) {
            utilizacaoTotal += (double) tarefa.getTempoExecucao() / tarefa.getPeriodo();
        }

        double limiteUtilizacao = n * (Math.pow(2, 1.0 / n) - 1);

        return utilizacaoTotal <= limiteUtilizacao;
    }

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

        // Verificando se as tarefas são escalonáveis
        boolean escalonaveis = verificaEscalonabilidade(tarefas);
        System.out.println("As tarefas são escalonáveis? " + escalonaveis);
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
