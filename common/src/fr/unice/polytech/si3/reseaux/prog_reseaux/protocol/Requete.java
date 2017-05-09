package fr.unice.polytech.si3.reseaux.prog_reseaux.protocol;

import java.io.Serializable;

/**
 * Classe servant à la communication.
 * C'est la Classe qui servira à toutes requêtes.
 *
 * @author Rachida, Elie
 */
public class Requete implements Serializable {
    private String type;
    private Object data;

    /**
     * Constructeur.
     * @param type Chaîne de caractères indiquant le type de requête
     * @param data Objet à envoyer. Peut être null.
     */
    public Requete(String type, Object data){
        this.type = type;
        this.data = data;
    }

    /**
     * @return Chaîne de caractères indiquant le type de requête
     */
    public String getType() {
        return type;
    }

    /**
     * @return Objet à envoyer. Peut être null.
     */
    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        String dataStr = "null";
        if(data != null)
            dataStr = data.toString();

        return "fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Requete{" +
                "type='" + type + '\'' +
                ", data=" + dataStr +
                '}';
    }
}
