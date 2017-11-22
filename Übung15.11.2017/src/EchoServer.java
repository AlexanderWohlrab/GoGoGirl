import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
	int localport;
	ServerSocket SeSock ; // = new ServerSocket();
	
public EchoServer(int LocalPort)
{
	this.localport = LocalPort;
}

public void starteServer() throws IOException
{
	
	 while (true) { 
         Socket socket = null; 
         try { 
             socket = SeSock.accept(); 
             echo(socket); 
         } 

         catch (IOException e) { 
             e.printStackTrace(); 
         } finally { 
             if (socket != null) 
                 try { 
                     socket.close(); 
                 } catch (IOException e) { 
                     e.printStackTrace(); 
                 } 
         } 
     } 
}
public void echo(Socket sock) throws IOException
{
	BufferedReader rein = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
    PrintStream raus = new PrintStream(sock.getOutputStream()); 
    String s; 
     
    while(rein.ready()) 
    { 
        s = rein.readLine(); 
        raus.println(s); 
    } 
} 


public void beendeServer() throws IOException
{
	SeSock.close();
}



}
