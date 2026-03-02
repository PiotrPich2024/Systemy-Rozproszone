import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.net.InetAddress;

public class JavaUdpServer {

    public static void main(String args[])
    {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9008;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while(true) {
                System.out.println("Waiting for packet...");
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                byte[] sendBuffer = "żółta gęś".getBytes();
                socket.receive(receivePacket);
                System.out.println("debug: length = " + receivePacket.getLength());
                InetAddress address = receivePacket.getAddress();
                int port = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);

                String msg = new String(receivePacket.getData());
                System.out.println("received msg: " + msg);
                socket.send(sendPacket);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
