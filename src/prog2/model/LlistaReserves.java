package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class  LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> llistaReserves = new ArrayList<>();

    public ArrayList<Reserva> getLlistaReserves() {
        return llistaReserves;
    }

    public void setLlistaReserves(ArrayList<Reserva> LlistaReserves) {
        this.llistaReserves = LlistaReserves;
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        boolean allotjamentDisponible = true;
        for (Reserva reserva : this.llistaReserves) {
            if (allotjament.getId().equals(reserva.getAllotjament_().getId())) {
                if (!dataEntrada.isAfter(reserva.getDataSortida()) &&
                        !reserva.getDataEntrada().isAfter(dataSortida)) {
                    allotjamentDisponible = false;
                    break;
                }
            }
        }
        return allotjamentDisponible;
    }

    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        int dia = dataEntrada.getDayOfMonth();
        int mes = dataEntrada.getMonthValue();
        long estadaMinima;
        if (mes < 3 || mes > 9){
            estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.BAIXA);
        }else if (mes == 3){
            if (dia < 21){
                estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.BAIXA);
            }else{
                estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.ALTA);
            }
        }else if (mes == 9){
            if (dia < 21){
                estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.ALTA);
            }else{
                estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.BAIXA);
            }
        }else{
            estadaMinima = allotjament.getEstadaMinima(Allotjament.Temp.ALTA);
        }
        return (estadaMinima <= estada);
    }

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        if (allotjamentDisponible(allotjament, dataEntrada, dataSortida)){
            if (isEstadaMinima(allotjament, dataEntrada, dataSortida)){
                llistaReserves.add(reserva);
            }else{
                throw new ExcepcioReserva("Les dates solicitades pel client " + client.getNom() + " amb DNI:" + client.getDni() +
                        " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
            }
        }else{
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada "
                    + dataEntrada + " pel client  " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        }
    }

    public int getNumReserves(){
        return llistaReserves.size();
    }
}
