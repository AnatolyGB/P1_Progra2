package prog2.model;

import java.time.LocalDate;

public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida){
        Allotjament.setId(id_);
        Client.setDni(dni_);
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }
    public Allotjament getAllotjament_();

    public Client getClient();

    public LocalDate getDataEntrada();

    public LocalDate getDataSortida();

    public void setAllotjament_(Allotjament allotjament_);

    public void setClient(Client client_);

    public void setDataEntrada(LocalDate dataEntrada_);

    public void setDataSortida(LocalDate dataSortida_);
}
