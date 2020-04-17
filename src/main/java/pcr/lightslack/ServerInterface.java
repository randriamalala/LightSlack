package pcr.lightslack;

import java.rmi.Remote;
import java.util.List;

public interface ServerInterface extends Remote {
    List<String> returnMessages();
    List<String> addMessage(String m);
}
