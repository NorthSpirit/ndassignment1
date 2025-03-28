package lt.viko.eif.mjurevicius.ndassignment1.service;

import java.io.*;
import java.net.Socket;

public class ClientFileSender {
    private static DataOutputStream dos = null;
    private static DataInputStream dis = null;

    public static void fileSend(String filename)
    {
        String fullpath = filename + ".xml";
        try (Socket socket = new Socket("localhost", 14242)) {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("sending the file to the server");

            dos.writeUTF(filename);
            sendFile(fullpath);

            dis.close();
            dos.close();
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String path) throws Exception {
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        dos.writeLong(file.length());
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1){
            dos.write(buffer, 0, bytes);
            dos.flush();
        }
        fileInputStream.close();
    }
}
