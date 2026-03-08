package prog2.model;

public abstract class Casa extends Allotjament{   // La classe casa és un tipus d'allotjament però segueix sent abstracta.
    private String mida;                      // Serveix d'impàs entre allotjament i certes subclasses que tenen característiques comunes.
    private int habitacions;
    private int placesPersones;

    public Casa(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, long EstadaMinimaBaixa, long EstadaMinimaAlta) {  // El constructor de casa.
        super(nom_, idAllotjament_, EstadaMinimaBaixa, EstadaMinimaAlta);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    public String getMida(){ // Getters i setters
        return mida;
    }

    public void setMida(String mida){
        this.mida = mida;
    }

    public int getHabitacions(){
        return habitacions;
    }

    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }

    public int getPlacesPersones(){
        return placesPersones;
    }

    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }
}
