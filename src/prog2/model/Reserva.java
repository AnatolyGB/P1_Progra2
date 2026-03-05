package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

    public Reserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida){
        Allotjament.setId(id_);
        Client.setDni(dni_);
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }
    public Allotjament getAllotjament_(){
        return allotjament;
    }

    public Client getClient(){
        return client;
    }

    public LocalDate getDataEntrada(){
        return dataEntrada;
    }

    public LocalDate getDataSortida(){
        return dataSortida;
    }

    public void setAllotjament_(Allotjament allotjament_){
        this.allotjament = allotjament_;
    }

    public void setClient(Client client_){
        this.client = client_;
    }

    public void setDataEntrada(LocalDate dataEntrada_){
        this.dataEntrada = dataEntrada_;
    }

    public void setDataSortida(LocalDate dataSortida_){
        this.dataSortida = dataSortida_;
    }
}
