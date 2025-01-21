package bgu.spl.net.impl.stomp;

import bgu.spl.net.impl.stomp.Frames.ConnectFrame;

import java.util.HashMap;

public abstract class Frame {


    public abstract String processFrame();

    public static Frame processMessage(String msg) {
        String[] args = msg.split("\n");

        HashMap<String, String> headers = new HashMap<>();

        for (int i = 1; i < args.length; i++) {
            String[] header = args[i].split(":");
            headers.put(header[0], header[1]);
        }
        //handle exceptions (should return errorFrame)
        if (args[0].equals("CONNECT")) {
            return new ConnectFrame(headers);
        }

    return null; //should return error exception
    }

    public abstract String toString();


}
