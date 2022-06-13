package sample03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;

public class sample03Server {
    
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);

        try {
            Socket socket = listener.accept();
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(new Timestamp(new Date().getTime()));
            } finally {
                socket.close();
            }
        } finally {
            listener.close();
        }
    }
}
