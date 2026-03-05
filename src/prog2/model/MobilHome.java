package prog2.model;

public class MobilHome extends Casa {
    private String nom_;
    private String idAllotjament_;
    private int mida;
    private int habitacions;
    private int placesPersones;
    private boolean terrassaBarbacoa;

    MobilHome(String nom_, String idAllotjament_, int mida, int habitacions, int placesPersones,
              boolean terrassaBarbacoa){

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 5);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }
}
