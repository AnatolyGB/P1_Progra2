package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
             String material, boolean casaMascota) {
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() {
        return material;
    }

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
    public String toString(){
        return super.toString() + ". Glamping{ Material = " + material + ", casaMascota = " + casaMascota + "}.";
    }
    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }
}
