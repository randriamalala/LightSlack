package pcr.lightslack;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server implements  ServerInterface{
    private List<String> buffer;

    public Server() {
        buffer = new ArrayList<String>();
    }

    public List<String> returnMessages() {
        return buffer;
    }

    public List<String> addMessage(String m) {
        buffer.add(m);
        return buffer;
    }

    public static void main(String args[]) {
        try {
            Server server = new Server();
            ServerInterface stub =
                    (ServerInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("LightSlack", stub);
            System.err.println("Server LightSlack ready ;)");
        } catch (Exception e) {
            System.err.println("Server exception " + e.toString());
            e.printStackTrace();
        }
    }
}
