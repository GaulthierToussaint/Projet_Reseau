import java.util.ArrayList;

public class DataBase {

    private ArrayList<Idee> tabIdee;

    public DataBase(){
        tabIdee = new ArrayList();
    }

    public void addIdee(Idee id){
        tabIdee.add(id);
    }
}
