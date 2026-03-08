package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping{ // Aquesta classe ens permet crear campings i té mooolts mètodes per a reservar, crear clients, allotjaments, etc.
    private final String nom;
    private ArrayList<Allotjament> allotjaments = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private LlistaReserves llistaReserves = new LlistaReserves();

    public Camping(String nom){  // El constructor del camping.
        this.nom = nom;
    }

    public String getNom(){   // Retorna el nom del camping
        return nom;
    }

    public LlistaReserves getLlistaReserves(){  // Torna la llista de reserves del camping
        return llistaReserves;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments(){  // Torna la llista d'allotjaments del camping
        return allotjaments;
    }

    public ArrayList<Client> getLlistaClients(){ // Torna la llista de clients del camping
        return clients;
    }

    public int getNumAllotjaments(){ // Torna el número d'allotjaments del camping
        return getLlistaAllotjaments().size();
    }

    public int getNumReserves(){  // Torna el número de reserves
        return getLlistaReserves().getNumReserves();
    }

    public int getNumClients(){  // Torna el número de clients
        return getLlistaClients().size();
    }

    public void afegirClient(String nom, String dni){  // Afegeix un client a la llista de clients del camping
        Client client = new Client(nom, dni);
        clients.add(client);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){ // Afegeix una parcela als allotjaments.
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        allotjaments.add(parcela);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred){   // Afeigeix un bungalow als allotjaments
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        allotjaments.add(bungalow);
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi){ // Afegeix un bungalow premium als allotjaments
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjaments.add(bungalowPremium);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota){  // Afegeix un glamping als allotjaments
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjaments.add(glamping);
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                           boolean terrassaBarbacoa){  // Afegeix un mobileHome als allotjaments
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjaments.add(mobilHome);
    }

    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{  // Afegeix una nova reserva a la llista de reserves si no hi ha cap inconvenient. Si hi és, llença una excepció.
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    public int calculAllotjamentsOperatius(){  // Retorna el número d'allotjaments operatius del camping.
        int allotjamentsOperatius = 0;
        for (Allotjament a: allotjaments){
            if (a.correcteFuncionament()){
                allotjamentsOperatius++;
            }
        }
        return allotjamentsOperatius;
    }

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){ // Retorna l'allotjament amb l'estada mínima més curta en la temporada que s'especifiqui.
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

    public Allotjament buscarAllotjament(String id_) throws ExcepcioReserva{  // Busca un allotjament sabent-ne l'ID. Llença una excepcio si no el troba.
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id_)) {
                return a;
            }
        }
        throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
    }

    public Client buscarClient(String dni_) throws ExcepcioReserva{ // Busca un client sabent-ne el DNI. Si no el troba llença una excepció reserva, ja que s'utilitza al mètode afegir reserva.
        for (Client c: clients){
            if (c.getDni().equals(dni_)){
                return c;
            }
        }
        throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
    }

    public static InAllotjament.Temp getTemporada(LocalDate data){  // Aconsegueix la temporada (ALTA o BAIXA) a partir d'una data d'entrada, mitjançant una sèrie de condicionals.
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
