package bgu.spl.net.impl.stomp.Frames;

import bgu.spl.net.impl.stomp.Frame;

import java.util.HashMap;

public class ConnectFrame extends Frame {

    private final static int argsNum = 4;

    private String acceptVersion;
    private String host;
    private String login;
    private String passcode;

    public ConnectFrame(HashMap headerMap){
        this.acceptVersion = headerMap.get("accept-version").toString();
        this.host = headerMap.get("host").toString();
        this.login = headerMap.get("login").toString();
        this.passcode = headerMap.get("passcode").toString();
    }


    @Override
    public String processFrame() {
        return new ConnectedFrame(acceptVersion).toString();
    }

    @Override
    public String toString() {
        return "";
    }


    public String getAcceptVersion() {
        return acceptVersion;
    }

    public String getHost() {
        return host;
    }

    public String getLogin() {
        return login;
    }

    public String getPasscode() {
        return passcode;
    }


}
