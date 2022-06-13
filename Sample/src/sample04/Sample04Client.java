package sample04;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sample04Client {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 9090);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        int length;

        File directory = new File("./ClientFiles");
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                dataOutputStream.writeUTF(file.getName());
                dataOutputStream.writeInt((int) file.length());

                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file.getPath());

                    while ((length = fileInputStream.read(buffer)) == -1) {
                        dataOutputStream.write(buffer, 0, length);
                    }
                } finally {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
            }
        }

        socket.close();
    }
}
