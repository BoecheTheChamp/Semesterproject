/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer;


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.xml.ws.Endpoint;
/**
 *
 * @author mikkel
 */
public class Server {
 
    public static void main(String[] args) throws RemoteException, MalformedURLException, Exception
    {
    RacerInterface qs = new Logik();
    //Server kørende på ubuntu4    
   //Endpoint.publish("http://ubuntu4.saluton.dk:9280/Server", qs);
    
   //Localhost
   Endpoint.publish("http://localhost:4450/typeracer", qs);
    System.out.println("Serveren er publiseret");
        
    }
}
