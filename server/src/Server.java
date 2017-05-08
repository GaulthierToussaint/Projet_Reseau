import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;

    public Server(int port){
        this.port = port;
    }

    public void run(){
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(this.port);
            System.out.println("Server listenning on port "+this.port);
            clientSocket = serverSocket.accept();

            System.out.println("Connection from "+clientSocket.getRemoteSocketAddress());

            String requestClient = "";

            while(!requestClient.equals("close")){
                DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
                requestClient = inFromClient.readUTF();
                System.out.println("Received from client "+requestClient);

            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}