import java.net.*;
import java.io.*;


public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 12345);
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            //create buffered reader for reading server responses
            BufferedReader serverResponseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);

            String userInput;
            do{
                System.out.print("Enter a message (type 'bye' to end): ");
                userInput = userInputReader.readLine();
                outputWriter.println(userInput);

                String serverResponse = serverResponseReader.readLine();
                System.out.println("Received from server: " + serverResponse);
            }while(!"bye".equalsIgnoreCase(userInput));
            userInputReader.close();;
            serverResponseReader.close();
            outputWriter.close();
            socket.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
