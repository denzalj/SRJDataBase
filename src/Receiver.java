import java.io.IOException;
import java.net.*;

public class Receiver {
    int port = 21000; // Порт, на котором будет работать сервер
    ServerSocket serverSocket;

    public String connection() {
        // Выберите порт для прослушивания

        // Создаем DatagramSocket для прослушивания широковещательных сообщений
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        byte[] buffer = new byte[1024];

        while (true) {
            // Получаем широковещательное сообщение
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Обрабатываем полученное сообщение
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            return receivedMessage;
        }

    }
}
