package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva implements InReserva{  // Classe reserva per a crear objectes que siguin reserves amb uns mètodes associats.
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {  // El constructor
        this.client = client;
        this.allotjament = allotjament;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
        if (dataSortida.isBefore(dataEntrada)) {   // Si la data de sortida és anterior a la d'entrada llença una excepció.
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
    }
    public Allotjament getAllotjament_(){  // Getters i setters.
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
