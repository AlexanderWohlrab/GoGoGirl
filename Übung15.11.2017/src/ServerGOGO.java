import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGOGO {

	public static void main(String[] args) throws IOException {
		
		CounterServer cs = new CounterServer(1234);
		
		System.out.println("Test 11");
		
		cs.starteServer(1234);
		
		cs.verbinde();
		
		
		
}

}
