package fr.unice.polytech.si3.reseaux.prog_reseaux.protocol;

import java.io.Serializable;

/**
 * Classe servant à la communication.
 * Utilisée lorsque l'on souhaite renvoyer une erreur.
 */
public class Erreur implements Serializable {
    private String nom;
    private String desc;

    /**
     * Constructeur.
     * @param nom nom de l'erreur
     * @param desc description de l'erreur
     */
    public Erreur(String nom, String desc) {
        this.nom = nom;
        this.desc = desc;
    }

    /**
     * @return nom de l'erreur
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return description de l'erreur
     */
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Erreur{" +
                "nom='" + nom + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
