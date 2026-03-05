package prog2.model;

public abstract class Casa extends Allotjament{
    private String nom_;
    private String idAllotjament_;
    private int mida;
    private int habitacions;
    private int placesPersones;
    private long EstadaMinimaBaixa;
    private long EstadaMinimaAlta;

    public Casa(String nom_, String idAllotjament_, int mida, int habitacions, int placesPersones, long EstadaMinimaBaixa, long EstadaMinimaAlta) {
        super(nom_, idAllotjament_, EstadaMinimaBaixa, EstadaMinimaAlta);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }
}
