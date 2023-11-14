import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try{
            //create a server socket and bind it to a specific port
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server waiting for client on port 12345...");

            //wait for client to connect.
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            //InputStreamReader reads bytes from InputStream and converts them into characters.
            //BufferedReader is used for efficient reading when reading lines of text.
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            //Create PrintWriter for sending messages back to the client.
            PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while((message = inputReader.readLine()) != null){
                System.out.println("Received from client: " + message);
                outputWriter.println("Server: " + message);

                //Echo the message back to the client.
                outputWriter.println("Server: " + message);
                if("bye".equalsIgnoreCase(message))
                    break;
            }
            inputReader.close();
            outputWriter.close();
            clientSocket.close();
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
