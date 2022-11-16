package com.example.jmed;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private int clientId;
    private Online activity;
    public Socket S;
    public ServerSocket SS;

    public Server(Online activity, int id, Socket S, ServerSocket SS) {
        this.activity = activity;
        clientId = id;
        this.S = S;
        this.SS = SS;
    }

    public void run() {
        try {

            BufferedReader BR = new BufferedReader(new InputStreamReader(S.getInputStream()));
            while (!interrupted()) {
                String s = BR.readLine();
                switch (s.charAt(0)) {
                    case '1':
                        activity.getPartie().avancer(clientId,false);
                        break;
                    case '2':
                        activity.getPartie().eliminer(clientId);
                        break;
                    case '3':
                        activity.getPartie().switchLight();
                        break;
                    case '4':
                        activity.getPartie().avancer(clientId,true);
                        break;
                    case '5':
                        activity.getPartie().alert();
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
