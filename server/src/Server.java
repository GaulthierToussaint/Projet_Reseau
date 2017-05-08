import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    private static final int maxClientsCount = 3;
    private static final clientThread[] threads = new clientThread[maxClientsCount];

    public static void main(String args[]) {

        int portNumber = 5555;

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
                        (threads[i] = new clientThread(clientSocket)).start();
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

    private DataInputStream is = null;
    private PrintStream os = null;
    private Socket clientSocket = null;

    public clientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());

            os.println("Welcome ! \nTo leave enter \"quit\" in a new line.");

            while (true) {
                String line = is.readLine();
                if (line.startsWith("quit")) {
                    System.out.println(clientSocket.getInetAddress()+" disconnected");
                    break;
                }
                else{
                    System.out.println("Received from "+clientSocket.getInetAddress()+" "+line);
                }
            }

            is.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}