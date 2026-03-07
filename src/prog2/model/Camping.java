package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{
    private final String nom;
    private ArrayList<Allotjament> allotjaments = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private LlistaReserves llistaReserves = new LlistaReserves();

    public Camping(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }

    public LlistaReserves getLlistaReserves(){
        return llistaReserves;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return allotjaments;
    }

    public ArrayList<Client> getLlistaClients(){
        return clients;
    }

    public int getNumAllotjaments(){
        return getLlistaAllotjaments().size();
    }

    public int getNumReserves(){
        return getLlistaReserves().getNumReserves();
    }

    public int getNumClients(){
        return getLlistaClients().size();
    }

    public void afegirClient(String nom, String dni){
        Client client = new Client(nom, dni);
        clients.add(client);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        allotjaments.add(parcela);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        allotjaments.add(bungalow);
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi){
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjaments.add(bungalowPremium);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjaments.add(glamping);
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                           boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjaments.add(mobilHome);
    }

    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }
    public int calculAllotjamentsOperatius(){
        int allotjamentsOperatius = 0;
        for (Allotjament a: allotjaments){
            if (a.correcteFuncionament()){
                allotjamentsOperatius++;
            }
        }
        return allotjamentsOperatius;
    }

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        long estadaMinima = 6767;
        int k = 0;
        for (int i = 0; i < allotjaments.size(); i++) {
            if (allotjaments.get(i).getEstadaMinima(temp) <= estadaMinima){
                estadaMinima = allotjaments.get(i).getEstadaMinima(temp);
                k = i;
            }
        }
        return allotjaments.get(k);
    }

    public Allotjament buscarAllotjament(String id_) throws ExcepcioReserva{
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id_)) {
                return a;
            }
        }
        throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
    }

    public Client buscarClient(String dni_) throws ExcepcioReserva{
        for (Client c: clients){
            if (c.getDni().equals(dni_)){
                return c;
            }
        }
        throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
    }

    public static InAllotjament.Temp getTemporada(LocalDate data){
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        if (mes < 3 || mes > 9){
            return InAllotjament.Temp.BAIXA;
        }else if (mes == 3){
            if (dia < 21){
                return InAllotjament.Temp.BAIXA;
            }else{
                return InAllotjament.Temp.ALTA;
            }
        }else if (mes == 9){
            if (dia < 21){
                return InAllotjament.Temp.ALTA;
            }else{
                return InAllotjament.Temp.BAIXA;
            }
        }else{
            return InAllotjament.Temp.ALTA;
        }
    }
}
