/**
 * Classe représentant une idée.
 */
public class Idee {
    private String description;
    private String technologies;
    private String nom;
    private String email;
    private static int idCounter = 0;
    private int id = 0;

    public Idee(String description,String technologies,String nom,String email){
        this.description    = description;
        this.technologies   = technologies;
        this.nom            = nom;
        this.email          = email;
        idCounter++;
        this.id             = idCounter;

    }

    public String getDescri(){
        return description;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return description+" "+technologies+" "+nom+ " "+email;
    }
}