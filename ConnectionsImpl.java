package bgu.spl.net.srv;

import com.sun.security.ntlm.Client;
import jdk.internal.net.http.common.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ConnectionsImpl<T> implements Connections<T>{
    private final Map<ConnectionHandler<T>, Client> connections;
    public ConnectionsImpl() {
        this.connections = new WeakHashMap<>();
    }
    public boolean send(int connectionId, T msg){
        for (Map.Entry entry : connections.entrySet()){
            if (entry.getValue().getId()==connectionId){
                entry.getKey().send(msg);
                return true;
            }
        }
        return false;
    }
    public void send(String channel, T msg){

    }
    public void disconnect(int connectionId){
        for (Map.Entry entry : connections.entrySet()){
            if (entry.getValue().getId()==connectionId){
                connections.remove(entry.getKey());
                return;
            }
        }
    }

}
