package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> LlistaReserves;

    public LlistaReserves(ArrayList<Reserva> LlistaReserves) {
        this.LlistaReserves = LlistaReserves;
    }

    public ArrayList<Reserva> getLlistaReserves() {
        return LlistaReserves;
    }

    public void setLlistaReserves(ArrayList<Reserva> LlistaReserves) {
        this.LlistaReserves = LlistaReserves;
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        boolean allotjamentDisponible = true;
        for (Reserva reserva : this.LlistaReserves) {
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
        return (estadaMinima > estada);
    }

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        if (allotjamentDisponible(allotjament, dataEntrada, dataSortida) && isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            LlistaReserves.add(reserva);
        }
    }

    public int getNumReserves(){
        return LlistaReserves.size();
    }
}
