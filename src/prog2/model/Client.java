package prog2.model;

public class Client implements InClient{             // Aquesta classe ens permet crear clients, amb un nom i un DNI.
    private String nom;
    private String dni;

    public Client(String nom, String dni){           // Constructor de la classe client
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom(){                       // Setters i getters (encapsulament dels atributs)
        return nom;
    }

    public String getDni(){
        return dni;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String toString(){                          // Imprimeix les dades del client.
        return nom + " amb DNI: " + dni + ".";
    }
}
