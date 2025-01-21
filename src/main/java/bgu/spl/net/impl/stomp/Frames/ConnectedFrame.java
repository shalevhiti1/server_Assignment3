package bgu.spl.net.impl.stomp.Frames;

import bgu.spl.net.impl.stomp.Frame;

public class ConnectedFrame extends Frame {

    String stompVersion;

    public ConnectedFrame(String _stompVersion) {
        stompVersion = _stompVersion;
    }

    @Override
    public String processFrame() {
        //should not be called
        return null;
    }

    @Override
    public String toString() {
        return "CONNECTED\n" +
                "version:" + stompVersion + "\n" +
                "\n" + '\u0000';
    }
}
