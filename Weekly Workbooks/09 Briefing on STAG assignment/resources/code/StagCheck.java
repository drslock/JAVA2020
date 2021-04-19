import java.io.*;
import java.net.*;
import java.lang.Process;

public class StagCheck
{
    public static void main(String args[])
    {
        String playerName = "Steve";
        String response;
        Process server = startNewServer();

        System.out.print("look...");
        response = executeCommand(playerName + ": look");
        if(response.contains("cabin")) System.out.println("SUCCESS");
        else System.out.println("FAIL");

        System.out.print("get....");
        executeCommand(playerName + ": get axe");
        response = executeCommand(playerName + ": inv");
        if(response.contains("axe")) System.out.println("SUCCESS");
        else System.out.println("FAIL");

        System.out.print("goto...");
        response = executeCommand(playerName + ": goto forest");
        if(response.contains("tree")) System.out.println("SUCCESS");
        else System.out.println("FAIL");

        killOldServer(server);
    }

    private static Process startNewServer()
    {
        try {
            String[] command = {"java", "-classpath", "dot-parser.jar:json-parser.jar:.", "StagServer", "entities.dot", "actions.json"};
            Process process = Runtime.getRuntime().exec(command);
            // Sleep for a bit to give the server some time to warm up
            Thread.sleep(2000);
            return process;
        } catch(InterruptedException ie) {
            return null;
        } catch(IOException ioe) {
            return null;
        }
    }

    public static String executeCommand(String command)
    {
        try {
            String response = "";
            String incoming;
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(command + "\n");
            out.flush();
            while((incoming = in.readLine()) != null) response = response + incoming + "\n";
            in.close();
            out.close();
            socket.close();
            return response;
        } catch(IOException ioe) {
            System.out.println(ioe);
            return "";
        }
    }

    private static void killOldServer(Process server)
    {
        try {
            server.destroy();
            server.waitFor();
        } catch(InterruptedException ie) {
        }
    }
}
