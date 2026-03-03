package prog2.model;

public class Glamping extends Allotjament{
    private String nom_;
    private String idAllotjament_;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private String material;
    private boolean casaMascota;

    Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
             String material, boolean casaMascota) {
        this.nom_ = nom_;
        this.idAllotjament_ = idAllotjament_;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.material = material;
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
