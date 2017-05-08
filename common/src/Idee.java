/**
 * Classe représentant une idée.
 */
public class Idee {
    private StringBuffer description;
    private String[] technologies;
    private String nom;
    private String email;

    public Idee(StringBuffer description,String[] technologies,String nom,String email){
        this.description  = description;
        this.technologies = technologies;
        this.nom          = nom;
        this.email        = email;
    }

    private StringBuffer buildString(){
        StringBuffer str = new StringBuffer();
        str.append("Nom : ");
        str.append(nom);
        str.append("\n");
        str.append("eMail : ");
        str.append(email);
        str.append("\n");
        for (int i=0;i<technologies.length;i++){
            str.append("Technologie n°");
            str.append(i);
            str.append(": ");
            str.append(technologies[i]);
            str.append("\n");
        }
        str.append(description);
        return str;
    }

    @Override
    public String toString(){
        return buildString().toString();
    }
}