import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static final int maxClientsCount = 3;
    private static final clientThread[] threads = new clientThread[maxClientsCount];
    private static DataBase dataBase;

    public static void main(String args[]) {

        int portNumber = 5555;
        dataBase = new DataBase();

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i;
                for (i = 0; i < maxClientsCount; i++) {
                    if (threads[i] == null) {
                        (threads[i] = new clientThread(clientSocket, dataBase)).start();
                        System.out.println(clientSocket.getInetAddress()+" est connecté");
                        break;
                    }
                }
                if (i == maxClientsCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    System.out.println("Il y a trop de connexions, un client a été refusé !");
                    os.println("Le serveur est surchargé, réessayez plus tard.");
                    os.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

class clientThread extends Thread {

    private DataInputStream is;
    private PrintStream os;
    private Socket clientSocket;
    private DataBase dataBase;

    public clientThread(Socket clientSocket, DataBase dataBase) {
        this.clientSocket = clientSocket;
        this.dataBase = dataBase;
    }

    public void run() {

        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());


            os.println("Vous etes connecte au serveur ! \n Pour avoir une idee des requetes disponibles tapper \"help\" \n Pour vous deconnecter tapper \"exit\".");

            while (true) {
                String line = is.readLine();
                if (line.startsWith("exit")) {
                    System.out.println(clientSocket.getInetAddress()+" deconnecte");
                    String reponse = TranslatorIdee.execute(line, dataBase);
                    os.println(reponse);
                    break;
                }
                else{
                    System.out.println("Recu de "+clientSocket.getInetAddress()+" "+line);
                    String reponse = TranslatorIdee.execute(line, dataBase);
                    os.println(reponse);
                }
            }

            is.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}