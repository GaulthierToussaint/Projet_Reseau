import fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Etudiant;
import fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Idee;
import fr.unice.polytech.si3.reseaux.prog_reseaux.protocol.Requete;

import java.net.Socket;
import java.util.Scanner;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client2 {


    public static void main(String[] s){
        new Client2().start("10.212.107.232", 9999, "LIST");
    }

    public void start(String server, int port, String type){
        Scanner sc  = new Scanner(System.in);
        Object object;

        System.out.println("nom etudian et l'email\n");
        Etudiant etudiant = new Etudiant(sc.next(),sc.next());
        System.out.println("libelle de l'idee\n");
        String libelle = sc.next();
        System.out.println("description de l'idee\n");
        String description = sc.next();
        object = new Idee(etudiant,libelle,description);

        try{
            Requete requete = new Requete(type,object );
            Socket socketConnection = new Socket(server, port);
            ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
            ObjectInputStream clientInputStream = new ObjectInputStream(socketConnection.getInputStream());

            clientOutputStream.writeObject(requete);

            Requete reponse = (Requete)clientInputStream.readObject();
            System.out.println(reponse.toString());
            clientInputStream.close();
            clientOutputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}