package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String Id;
    private long EstadaMinima;
    private enum Temp {ALTA, BAIXA};

    public String getNom(){
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id = Id;
    }

    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA) {
            return EstadaMinima;
        }else {
            return EstadaMinima;
        }
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        Temp.ALTA = estadaMinimaALTA_;
        Temp.BAIXA = estadaMinimaBAIXA_;
    }

    public abstract boolean correcteFuncionament();



