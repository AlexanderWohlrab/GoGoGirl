import java.io.IOException;

public class ClientGOGO {

	public static void main(String[] args) throws IOException {

		CounterClient cc = new CounterClient();
		
		cc.verbinden("localhost", 1234);
		
		while(true)
		{
		cc.senden("plus");
		}

	}

}
