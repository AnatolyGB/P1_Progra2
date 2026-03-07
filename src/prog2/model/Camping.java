package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{
    private final String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;
    private LlistaReserves llistaReserves;

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
        int i = 0;
        while (!clients.get(i).getDni().equals(dni_) || i >= getNumClients()){
            i++;
        }
        int k = 0;
        while (!allotjaments.get(k).getId().equals(id_) || i >= getNumReserves()){
            k++;
        }
        if (clients.get(i).getDni().equals(dni_) && allotjaments.get(k).getId().equals(id_)){
            Reserva reserva = new Reserva(allotjaments.get(k), clients.get(i), dataEntrada, dataSortida);
        }else{
            throw new ExcepcioReserva("L'allotjament o el client no existeixen.");
        }
    }
    public int calculAllotjamentsOperatius(){
        return 0;
    }

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        return null;
    }
}
