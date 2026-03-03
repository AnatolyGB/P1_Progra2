package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String Id;
    private long EstadaMinimaAlta;
    private long EstadaMinimaBaixa;


    public Allotjament(String nom, String Id, long EstadaMinimaAlta, long EstadaMinimaBaixa) {
        this.nom = nom;
        this.Id = Id;
        this.EstadaMinimaAlta = EstadaMinimaAlta;
        this.EstadaMinimaBaixa = EstadaMinimaBaixa;
    }

    public String getNom() {
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

    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) {
            return EstadaMinimaAlta;
        } else {
            return EstadaMinimaBaixa;
        }
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

    }

    public abstract boolean correcteFuncionament();


}