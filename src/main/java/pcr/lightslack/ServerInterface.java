package pcr.lightslack;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServerInterface extends Remote {
    List<String> returnMessages() throws RemoteException;
    List<String> addMessage(String m) throws RemoteException;
}
