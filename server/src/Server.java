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
                        System.out.println(clientSocket.getInetAddress()+" is connected");
                        break;
                    }
                }
                if (i == maxClientsCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    System.out.println("Too much connections, a client has been refused");
                    os.println("Server too busy. Try later.");
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
        this.dataBase.addIdee(new Idee("ok","bob","ca","va"));
    }

    public void run() {

        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());

            os.println("Welcome on server ! \nTo leave enter \"quit\" in a new line.");

            while (true) {
                String line = is.readLine();
                if (line.startsWith("quit")) {
                    System.out.println(clientSocket.getInetAddress()+" disconnected");
                    break;
                }
                else{
                    System.out.println("Received from "+clientSocket.getInetAddress()+" "+line);
                    os.println(dataBase.toString());
                }
            }

            is.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}