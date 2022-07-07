package sample;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFileTransServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        Socket socket = listener.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        byte[] buffer = new byte[4096];
        int length;

        try {
            String fileName = null;

            while ((fileName = dataInputStream.readUTF()) != null) {
                int fileSize = dataInputStream.readInt();

                FileOutputStream fileOutputStream = new FileOutputStream("./ServerFiles" + fileName);

                while (fileSize > 0) {
                    length = dataInputStream.read(buffer, 0, Math.min(fileSize, buffer.length));
                    fileSize -= length;
                    fileOutputStream.write(buffer, 0, length);
                }

                fileOutputStream.close();
                System.out.println(fileName + " is received.");
            }
        } finally {
            
        }

        listener.close();
    }
}
