package prog2.model;

public class MobilHome extends Allotjament {
    private String nom_;
    private String idAllotjament_;
    private String mida_;
    private int habitacions_;
    private int placesPersones_;
    private boolean terrassaBarbacoa;

    MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
              boolean terrassaBarbacoa){

        super(nom_, idAllotjament_, 4, 2);
        this.mida_ = mida;
        this.habitacions_ = habitacions;
        this.placesPersones_ = placesPersones;
        this.terrassaBarbacoa = terrassaBarbacoa;

    }


    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }+-
}
