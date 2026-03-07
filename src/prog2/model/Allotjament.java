package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String Id;
    private long EstadaMinimaBaixa;
    private long EstadaMinimaAlta;

    public Allotjament(String nom, String Id, long EstadaMinimaBaixa, long EstadaMinimaAlta) {
        this.nom = nom;
        this.Id = Id;
        this.EstadaMinimaBaixa = EstadaMinimaBaixa;
        this.EstadaMinimaAlta = EstadaMinimaAlta;
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
        this.EstadaMinimaAlta = estadaMinimaALTA_;
        this.EstadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    public String toString(){
        return "Nom=" + nom + ", Id=" + Id + ", estada mínima en temp ALTA: " + EstadaMinimaAlta + ", estada mínima en temp BAIXA: " + EstadaMinimaBaixa + ".";
    }

    public abstract boolean correcteFuncionament();
}