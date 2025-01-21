package bgu.spl.net.impl.stomp;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.srv.Connections;

public class stompProtocolImp implements MessagingProtocol<String> {




    @Override
    public void start(int connectionId, Connections<String> connections) {

    }

    @Override
    public String process(String msg) {
        Frame frame = Frame.processMessage(msg); //return the frame that the message describes
        return frame.processFrame(); //process the frame and return the response
    }

    @Override
    public boolean shouldTerminate() {
        return false;
    }
}
