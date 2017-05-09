package fr.unice.polytech.si3.reseaux.prog_reseaux.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui contient les informations d'une idée;
 * un étudiant propriétaire de l'idée, un libellé, une description ainsi qu'une liste
 * d'étudiants participant.
 *
 * @author Rachida, Elie
 */
public class Idee implements Serializable{
    private Etudiant proprio;
    private String libelle;
    private String description;
    private List<Etudiant> participants;

    public Idee(Etudiant proprio, String libelle, String description) {
        this.proprio = proprio;
        this.libelle = libelle;
        this.description = description;
        this.participants = new ArrayList<Etudiant>();
    }

    /**
     * @return propriétaire de l'idée
     */
    public Etudiant getProprio() {
        return proprio;
    }

    /**
     * @return libellé de l'idée
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @return description textuelle de l'idée
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return liste des participants
     */
    public List<Etudiant> getParticipants() {
        return participants;
    }

    /**
     * Ajoute un étudiant à la liste des particiopants
     * @param etudiant
     */
    public void addParticipant(Etudiant etudiant){
        participants.add(etudiant);
    }

    @Override
    public String toString() {
        return "fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Idee{" +
                "proprio=" + proprio +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", participants=" + participants +
                '}';
    }
}
