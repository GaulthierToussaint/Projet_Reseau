package model;

public enum Requetes {

    LIST(0),
    HELP(0),
    EXIT(0),
    ADD(4);

    int quantiteArg;

    Requetes(int quantiteArg){
        this.quantiteArg = quantiteArg;
    }

    public static String getFailureString(String requete){
        for (Requetes c : Requetes.values()) {
            if (c.name().equals(requete.split(";")[0].toUpperCase())) {
                return requete.split(";")[0]+";failure";
            }
        }
        return "";
    }

    public static String getSuccessString(String requete){
        for (Requetes c : Requetes.values()) {
            if (c.name().equals(requete.split(";")[0].toUpperCase())) {
                return requete.split(";")[0]+";success";
            }
        }
        return "";
    }

    public static boolean contains(String requete) {
        for (Requetes c : Requetes.values()) {
            if (c.name().equals(requete.split(";")[0].toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String requete){
        for (Requetes c : Requetes.values()) {
            if (c.name().equals(requete.split(";")[0].toUpperCase())) {
                return requete.split(";").length-1 == c.quantiteArg;
            }
        }
        return false;
    }

    public static String getAction(String requete){
        return requete.split(";")[0].toLowerCase();
    }


}
