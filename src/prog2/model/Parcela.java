package prog2.model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        super(nom_, idAllotjament_, 4, 2);
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida() {
        return metres;
    }

    public void setMida(float metres) {
        this.metres = metres;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    @Override
    public String toString(){
        return super.toString() + ". Parcela{ Mida = " + metres + ", Connexió elèctrica = " + connexioElectrica + "}";
    }

    @Override
    public boolean correcteFuncionament() { return connexioElectrica; }
}
