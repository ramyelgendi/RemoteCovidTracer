package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] args ) throws IOException {

        int bytesRead;

        ServerSocket serverSocket;
        serverSocket = new ServerSocket(13267);

        while(true) {
            Socket clientSocket;
            clientSocket = serverSocket.accept();
            InputStream in = clientSocket.getInputStream();

            // Writing the file to disk
            // Instantiating a new output stream object
            OutputStream output = new FileOutputStream("tracer_sent.log");

            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            // Closing the FileOutputStream handle
            output.close();
            System.out.println("Log File Recieved! ");
        }
    }
}
