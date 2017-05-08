import java.io.*;
import java.net.Socket;

public class Client {


    public void connect(String adress, int port) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(adress,port);

        System.out.println("Connected to "+adress+"/"+port);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        String temp = "";
        while(!temp.equals("close")){
            System.out.print("Request : ");
            temp = inFromUser.readLine();
            outToServer.writeUTF(temp);
            outToServer.flush();
        }
    }
}