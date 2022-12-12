package sendfileinsocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost", 12000);

            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());

            // Read a file
            FileReader fr = new FileReader("src/myapp/input.txt");
            BufferedReader bfe = new BufferedReader(fr);
            String line;
            while (null != (line = bfe.readLine())) {
                dos.writeUTF(line);
                dos.flush();
            }

            // SEND an EDF identifier to server
            // dos.writeUTF("EDF");
            // dos.flush();

            bfe.close();
            cs.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
