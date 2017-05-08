/**
 * Classe représentant une idée.
 */
public class Idee {
    private String description;
    private String technologies;
    private String nom;
    private String email;

    public Idee(String description,String technologies,String nom,String email){
        this.description  = description;
        this.technologies = technologies;
        this.nom          = nom;
        this.email        = email;
    }

    @Override
    public String toString(){
        return description+" "+technologies+" "+nom+ " "+email;
    }
}