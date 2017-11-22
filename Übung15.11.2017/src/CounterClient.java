import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CounterClient {
	
	Socket clientSocket;
	
	public CounterClient()
	{
		
	}
	public boolean verbinden(String host, int port)
	 {
		 try {
			 clientSocket = new Socket(host, port);
		 if (!clientSocket.isConnected()){
		 return false;
		 }
		 return true;
		 }
		 catch (IOException e){
		 e.printStackTrace(); // optional
		 return false;
		 }
	}
	
	public void abmelden() throws IOException 
	 {
		 
		 clientSocket.close();
	 }
	
	public void senden(String text) throws IOException
	 {
	DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
		 
	dOut.writeByte(1);
	dOut.writeUTF(text);
	dOut.flush(); // Send off the data
	 }
	
	

}
