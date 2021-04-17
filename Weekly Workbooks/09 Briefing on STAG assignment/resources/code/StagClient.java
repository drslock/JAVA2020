import java.io.*;
import java.net.*;

public class StagClient
{
    public static void main(String args[])
    {
        if(args.length != 1) System.out.println("Usage: java StageClient <player-name>");
        else {
            String playerName = args[0];
            BufferedReader commandLine = new BufferedReader(new InputStreamReader(System.in));
            while(true) handleNextCommand(commandLine, playerName);
        }
    }

    private static void handleNextCommand(BufferedReader commandLine, String playerName)
    {
        try {
            String incoming;
            System.out.print("\n" + playerName + ": ");
            String command = commandLine.readLine();
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(playerName + ": " + command + "\n");
            out.flush();
            while((incoming = in.readLine()) != null) System.out.println(incoming);
            in.close();
            out.close();
            socket.close();
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
}
