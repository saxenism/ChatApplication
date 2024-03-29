package saxenism.chatApp.client;

import java.io.*;
import java.net.*;

public class ReadThread extends Thread{
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    public ReadThread(Socket socket, ChatClient client)
    {
        this.socket = socket;
        this.client = client;

        try
        {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        }
        catch(IOException e)
        {
            System.out.println("Error getting input stream: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run()
    {
        while(true)
        {
            try
            {
                String response = reader.readLine();
                System.out.println(response);

            }
            catch (IOException e)
            {
                System.out.println("Error reading from server: " + e.getMessage());
                e.printStackTrace();
                break;
            }
        }
    }
}
