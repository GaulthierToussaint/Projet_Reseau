import java.util.ArrayList;

public class DataBase {

    private ArrayList<Idee> tabIdee;

    public DataBase(){
        tabIdee = new ArrayList();
    }

    public int addIdee(Idee id){
        tabIdee.add(id);
        return tabIdee.size();
    }

    public int addIdee(String requete){
        String[] parms = requete.split(";");
        tabIdee.add(new Idee(parms[1],parms[2],parms[3],parms[4]));
        return tabIdee.size();
    }

    public String list(){
        String res = "";
        if(tabIdee.size()==0)
            return res + "aucune_idee_dans_la_base";
        for(int i = 0 ; i < tabIdee.size() ; i++){
            res += tabIdee.get(i).getId()+";"+tabIdee.get(i).getNom();
            if(i!=tabIdee.size()-1){
                res += ";";
            }
        }
        return res;
    }
}
