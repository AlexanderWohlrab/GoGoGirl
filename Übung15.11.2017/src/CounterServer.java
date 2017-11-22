import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CounterServer {
	
	int localPort;
	int zaehler;
	int number;
	ServerSocket SeSock;
	
	
	public CounterServer(int LocalPort)
	{
		this.localPort = LocalPort;
	}
	
	public void starteServer(int LocalPort) throws IOException
	{
		SeSock = new ServerSocket(LocalPort);
		SeSock.accept();
	}
	
	public void beendeServer() throws IOException
	{
		SeSock.close();
	}
	
	public void  plus()
	{
		zaehler++;
	}
	
	public ServerSocket getSocket()
	{
		return SeSock;
	}
	public int getZaehler()
	{
		return zaehler;
	}
	
	public void verbinde() { 

        while (true) { 
            Socket socket = null; 
            try { 
                socket = SeSock.accept(); 
                reinRaus(socket); 
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

    private void reinRaus(Socket socket) throws IOException { 
        BufferedReader rein = new BufferedReader(new InputStreamReader(socket 
                .getInputStream())); 
        PrintStream raus = new PrintStream(socket.getOutputStream()); 
        String s; 
         
        while(rein.ready()) { 
            s = rein.readLine(); 
            raus.println(s); 
            if(s == "plus") 
	        {
	        	plus();
	        	raus.print(getZaehler());
	        	System.out.println(getZaehler());
	        }
        } 
    } 

}
