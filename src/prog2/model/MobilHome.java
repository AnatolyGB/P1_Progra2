package prog2.model;

public class MobilHome extends Casa {  // Un altre tipus de casa, i per tant, d'allotjament.
    private boolean terrassaBarbacoa;

    MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
              boolean terrassaBarbacoa){  // El constructor

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 5);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean getTerrassaBarbacoa(){  // Getters i setters
        return terrassaBarbacoa;
    }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() { return terrassaBarbacoa; } // Comprova si l'allotjament està operatiu
}
