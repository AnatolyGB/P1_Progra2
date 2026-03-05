package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;

    MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
              boolean terrassaBarbacoa){

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 5);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean getTerrassaBarbacoa(){
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public String toString() {
        return super.toString() + ". MobilHome{Terrassa amb barbacoa = " + terrassaBarbacoa + "}.";
    }

    @Override
    public boolean correcteFuncionament() { return terrassaBarbacoa; }
}
