package prog2.model;

import java.util.ArrayList;

public class Camping implements InCamping{

    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;

    public Camping(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }

    public LlistaReserves getLlistaReserves(){
        return new LlistaReserves();
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

    void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi){
        
    }
}
