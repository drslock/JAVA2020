import java.io.*;
import java.net.*;

public class DBClient
{
    final static char EOT = 4;

    public static void main(String args[])
    {
        try {
            BufferedReader commandLine = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true) handleNextCommand(commandLine, socketReader, socketWriter);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    private static void handleNextCommand(BufferedReader commandLine, BufferedReader socketReader, BufferedWriter socketWriter)
    {
        try {
            System.out.print("SQL:> ");
            String command = commandLine.readLine();
            socketWriter.write(command + "\n");
            socketWriter.flush();
            String incomingMessage = socketReader.readLine();
            while( ! incomingMessage.contains("" + EOT + "")) {
                System.out.println(incomingMessage);
                incomingMessage = socketReader.readLine();
            }
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
}
