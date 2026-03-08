package prog2.model;

public class Glamping extends Casa{  // Serveix per a crear glampings, un tipus de casa.
    private String material;
    private boolean casaMascota;

    Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
             String material, boolean casaMascota) { // El constructor
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3); // Cridant al super per accedir al constructor de casa.
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() {
        return material;
    }  // Setters i getters

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }  // Comprova si funciona correctament.
}
