package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;
    private LlistaReserves llistaReserves;

    public Camping(String nom, ArrayList<Allotjament> allotjaments, ArrayList<Client> clients, LlistaReserves llistaReserves){
        this.nom = nom;
        this.allotjaments = allotjaments;
        this.clients = clients;
        this.llistaReserves = llistaReserves;
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
        return getLlistaReserves().size();
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
        for (Client c : clients) {
            if (dni_.equals(c.getDni())) {
                for (Allotjament a : allotjaments) {
                    if (id_.equals(a.getId())) {
                        LlistaReserves.afegirReserva(a, c, dataEntrada, dataSortida);
                        break;
                    }
                }
                break;
            }
        }
    }
    public int calculAllotjamentsOperatius(){
        return 0;
    }

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        return null;
    }
}
