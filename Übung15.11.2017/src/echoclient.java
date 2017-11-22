import java.io.*;
import java.net.Socket;
import java.util.*;
/*
* EchoClient
* …
*/
public class echoclient {
 private Socket clientSocket;
 /*
 * verbindet den Clientsocket mit dem host an Port port.
 * Liefert true, wenn die Verbindung aufgebaut wurde, sonst false.
 */
 String host;
 int port;
 
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
 // sendet text an Server
 public void senden(String text) throws IOException
 {
DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
	 
dOut.writeByte(1);
dOut.writeUTF(text);
dOut.flush(); // Send off the data
 }
 // wartet auf Nachrichteneingang (Zeichenkette) vom Server und
///liefert bei
 // Empfang die Nachricht als Zeichenkette zurück.
 @SuppressWarnings("static-access")
public String empfangen() throws IOException
 {
	 char[] buf = null;
	 String catchString = null;
	 InputStreamReader read = new InputStreamReader(clientSocket.getInputStream());
	 read.read(buf);
	 read.close();
	 catchString = String.valueOf(buf);
	 
	 
	 return catchString;
 }
 /*
 * meldet den Client ab, indem der Clientsocket geschlossen wird.
 */
 public void abmelden() throws IOException {
	 
	 clientSocket.close();
 }
} 