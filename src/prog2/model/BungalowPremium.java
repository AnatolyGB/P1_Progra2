package prog2.model;

public class BungalowPremium extends Bungalow{
    private String nom;
    String idAllotjament;
    String mida;
    int habitacions;
    int placesPersones;
    int placesParquing;
    boolean terrassa;
    boolean tv;
    boolean aireFred;
    boolean serveisExtra;
    String codiWifi;

    BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                    boolean serveisExtra, String codiWifi){

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public String toString(){
        return super.toString() + "A més és premium{ Serveis = " + serveisExtra + ", Codi Wifi =  " + codiWifi + "}.";
    }
    @Override
    public boolean correcteFuncionament() { return (aireFred && codiWifi.length() > 7 && codiWifi.length() < 17); }
}
