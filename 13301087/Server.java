package server1;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Server {  
    public static void main(String[] args) throws IOException {  
        ServerSocket server = new ServerSocket(3333);  
          
        while (true) {  
            Socket socket = server.accept();  
            invoke(socket);  
        }  
    }  
      
    private static void invoke(final Socket client) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                BufferedReader in = null;  
                PrintWriter out = null;  
                try {  
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
                    out = new PrintWriter(client.getOutputStream());  
  
                    while (true) {  
                        String msg = in.readLine();  
                        //System.out.println(msg);  
                        //out.println("Server received " + msg);  
                        for (int i = msg.length()-1; i >= 0; i--) {
                        	System.out.print(msg.charAt(i));
                        }
                        out.flush();  
                        if (msg.equals("bye")) {  
                            break;  
                        }  
                    }  
                } catch(IOException ex) {  
                    ex.printStackTrace();  
                } finally {  
                    try {  
                        in.close();  
                    } catch (Exception e) {}  
                    try {  
                        out.close();  
                    } catch (Exception e) {}  
                    try {  
                        client.close();  
                    } catch (Exception e) {}  
                }  
            }  
        }).start();  
    }  
}  