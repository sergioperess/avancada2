package Projeto1;

public class Main {
    public static void main(String[] args) {
        int tempoDeslocamentoVeiculo1 = 30;
        int tempoDeslocamentoVeiculo2 = 25;
        ServicoTransporte servico = new ServicoTransporte(1, "2023-07-26 09:00", tempoDeslocamentoVeiculo1, tempoDeslocamentoVeiculo2);

        Passageiro passageiro1 = new Passageiro("João");
        Passageiro passageiro2 = new Passageiro("Maria");
        Carga carga1 = new Carga("Caixas");
        Carga carga2 = new Carga("Encomendas");
        Motorista motorista1 = new Motorista("Carlos");
        Motorista motorista2 = new Motorista("Ana");

        servico.adicionarPassageiro(passageiro1);
        servico.adicionarPassageiro(passageiro2);
        servico.adicionarCarga(carga1);
        servico.adicionarCarga(carga2);
        servico.adicionarMotorista(motorista1);
        servico.adicionarMotorista(motorista2);

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
