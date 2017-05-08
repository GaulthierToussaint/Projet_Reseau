public class MainServer {

    public static void main(String[] args){
        Server myServer = new Server(5555);
        myServer.run();
    }

}