import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.channels.ServerSocketChannel;

public class ServerSocketTest {

	public static void main(String[] args) {
		try {
			bindToAllTwice();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bindToAllThenOne();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bindToOneThenAgain();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void bindToAllTwice() throws IOException, SocketException {
		System.out.println("bindToAllTwice:");
		
		ServerSocketChannel socket1 = bind("::", 4443);
		System.out.println("Socker1 bound: " + socket1);
		
		ServerSocketChannel socket2 = bind("::", 4443);
		System.out.println("Socker2 bound: " + socket2);
		
		socket1.close();
		socket2.close();
	}

	private static ServerSocketChannel bind(String host, int port) throws IOException, SocketException {
		ServerSocketChannel channel = ServerSocketChannel.open();
		ServerSocket socket = channel.socket();
		socket.setReuseAddress(true);
		socket.bind(new InetSocketAddress(host, port));
		return channel;
	}
	
	private static void bindToAllThenOne() throws IOException, SocketException {
		System.out.println("bindToAllThenOne:");
		
		ServerSocketChannel socket1 = bind("::", 4444);
		System.out.println("Socker1 bound: " + socket1);
		
		ServerSocketChannel socket2 = bind("127.0.0.1", 4444);
		System.out.println("Socker2 bound: " + socket2);
		
		socket1.close();
		socket2.close();
	}
	
	private static void bindToOneThenAgain() throws IOException, SocketException {
		System.out.println("bindToOneThenAgain:");
		
		ServerSocketChannel socket1 = bind("127.0.0.1", 4445);
		System.out.println("Socker1 bound: " + socket1);
		
		ServerSocketChannel socket2 = bind("127.0.0.1", 4445);
		System.out.println("Socker2 bound: " + socket2);
		
		socket1.close();
		socket2.close();
	}

}
