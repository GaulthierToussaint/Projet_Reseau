import java.io.IOException;

public class MainClient {

    public static void main(String[] args) throws IOException {
        Client myClient = new Client();
        myClient.connect("localhost",5555);
    }
}