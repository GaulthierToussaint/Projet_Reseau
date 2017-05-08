public final class TranslatorIdee {

    public static String execute(String request, DataBase dataBase){
        if(!Requetes.contains(request) ){
            return "Requete inconnue, essayer \"help\"";
        }
        if(!Requetes.isValid(request)){
            return "Format de la requete invalide, essayer \"help\"";
        }
        if(Requetes.getAction(request).equals("list")){
            return Requetes.getSuccessString(request) + ";" + dataBase.list();
        }
        if(Requetes.getAction(request).equals("add")){
            int id = dataBase.addIdee(request);
            return Requetes.getSuccessString(request) + ";" + id;
        }
        if(Requetes.getAction(request).equals("help")){
            return "Requetes possibles : \n 1.  list \n 2.  add;description_textuelle;technologies_envisagees;nom_etudiant;email";
        }
        if(Requetes.getAction(request).equals("exit")){
            return "Vous etes maintenant deconnecte du serveur";
        }
        return "Requete inconnue, essayer \"help\"";
    }
}
