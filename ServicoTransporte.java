package Projeto1;

import java.util.ArrayList;
import java.util.List;

class ServicoTransporte {
    private int id;
    private String dataHoraInicio;
    private int tempoDeslocamentoVeiculo1;
    private int tempoDeslocamentoVeiculo2;
    private List<Passageiro> passageiros;
    private List<Carga> cargas;
    private List<Motorista> motoristas;
    private final Object passageirosLock = new Object();

    public ServicoTransporte(int id, String dataHoraInicio, int tempoDeslocamentoVeiculo1, int tempoDeslocamentoVeiculo2) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.tempoDeslocamentoVeiculo1 = tempoDeslocamentoVeiculo1;
        this.tempoDeslocamentoVeiculo2 = tempoDeslocamentoVeiculo2;
        this.passageiros = new ArrayList<>();
        this.cargas = new ArrayList<>();
        this.motoristas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public int getTempoDeslocamentoVeiculo1() {
        return tempoDeslocamentoVeiculo1;
    }

    public int getTempoDeslocamentoVeiculo2() {
        return tempoDeslocamentoVeiculo2;
    }

    public List<Passageiro> getPassageiros() {
        synchronized (passageirosLock) {
            return passageiros;
        }
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void adicionarPassageiro(Passageiro passageiro) {
      synchronized (passageirosLock) {
            passageiros.add(passageiro);
        }
    }

    public void adicionarCarga(Carga carga) {
        cargas.add(carga);
    }

    public void adicionarMotorista(Motorista motorista) {
        motoristas.add(motorista);
    }

    public String getDataHoraFim() {
        int tempoEsperaCrossDocking = Math.abs(tempoDeslocamentoVeiculo1 - tempoDeslocamentoVeiculo2);
        return dataHoraInicio + " + " + tempoEsperaCrossDocking + " minutos";
    }
}
