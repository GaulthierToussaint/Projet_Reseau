package model;

public final class TranslatorIdee {

    public static String execute(String request, DataBase dataBase){
        if(!Requetes.contains(request) ){
            return "fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Requete inconnue, essayer \"help\"";
        }
        if(!Requetes.isValid(request)){
            return "Format de la requete invalide, essayer \"help\"";
        }
        if(Requetes.getAction(request).equals("list")){
            return Requetes.getSuccessString(request) + ";" + dataBase.list();
        }
        if(Requetes.getAction(request).equals("add")){
            int id = dataBase.addIdee(request);
            return Requetes.getSuccessString(request) + ";" + "#" + id;
        }
        if(Requetes.getAction(request).equals("help")){
            return "model.Requetes possibles : \n 1.  list \n 2.  add;description_textuelle;technologies_envisagees;nom_etudiant;email \n 3.  add;drone volant;bluetooth infrarouge;dupont;d@gmail.com \n 4.  exit";
        }
        if(Requetes.getAction(request).equals("exit")){
            return "Vous etes maintenant deconnecte du serveur";
        }
        return "fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Requete inconnue, essayer \"help\"";
    }
}
