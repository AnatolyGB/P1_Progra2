package prog2.model;

public class BungalowPremium extends Bungalow{   // Classe que ens permet crear Bungalows Premium, tipus de bungalow, i per tant de casa i per tant de allotjament......(ja s'entén).
    boolean serveisExtra;
    String codiWifi;

    BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                    boolean serveisExtra, String codiWifi){    // Constructor de la classe

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean correcteFuncionament() { return (super.isAireFred() && codiWifi.length() > 7 && codiWifi.length() < 17); }  // En comprova el funcionament.
}
