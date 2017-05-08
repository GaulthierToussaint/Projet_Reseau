import java.util.ArrayList;

public class DataBase {

    private ArrayList<Idee> tabIdee;

    public DataBase(){
        tabIdee = new ArrayList();
    }

    public void addIdee(Idee id){
        tabIdee.add(id);
    }

    public String toString(){
        String res = "";
        for(int i = 0 ; i<tabIdee.size() ; i++){
            res += tabIdee.get(i).toString();
            res += "\n";
        }
        return res;
    }
}
