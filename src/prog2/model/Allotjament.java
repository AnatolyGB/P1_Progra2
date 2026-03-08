package prog2.model;

public abstract class Allotjament implements InAllotjament {      // Classe abstracta que defineix els allotjaments. (Crearem objctes de les seves subclasses).
    private String nom;
    private String Id;
    private long EstadaMinimaBaixa;
    private long EstadaMinimaAlta;

    public Allotjament(String nom, String Id, long EstadaMinimaBaixa, long EstadaMinimaAlta) {    // El seu constructor.
        this.nom = nom;
        this.Id = Id;
        this.EstadaMinimaBaixa = EstadaMinimaBaixa;
        this.EstadaMinimaAlta = EstadaMinimaAlta;
    }

    public String getNom() {                       // Setters i getters.
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public long getEstadaMinima(Temp temp) {        // Getter que retorna l'estada mínima en funció de la temporada.
        if (temp == Temp.ALTA) {
            return EstadaMinimaAlta;
        } else {
            return EstadaMinimaBaixa;
        }
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {   // Setter que canvia les estades mínimes.
        this.EstadaMinimaAlta = estadaMinimaALTA_;
        this.EstadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    public String toString(){               // Imprimeix les dades de l'alllotjament (serà cridat mitjançant el super a les subclasses.)
        return "Nom=" + nom + ", Id=" + Id + ", estada mínima en temp ALTA: " + EstadaMinimaAlta + ", estada mínima en temp BAIXA: " + EstadaMinimaBaixa + ".";
    }

    public abstract boolean correcteFuncionament();   // Funció abstracta que serà diferent en cada subclasse.
}