/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author mikkel
 */
public class LocalhostClient {
    public static void main(String[] args) throws MalformedURLException, Exception {
        
        URL url = new URL("http://localhost:4450/typeracer?wsdl");
	QName qname = new QName("http://typeracer/", "LogikService");
	
        Service service = Service.create(url, qname);
	
        QName port_name = new QName("http://typeracer/", "LogikPort");
        RacerInterface k = service.getPort(port_name, RacerInterface.class);
       //Logikken fra galgelogik
        Logik spil = new Logik();
        
        //scanner
        System.out.println("Det Virker");
        
       boolean truee = true;
        String guess;
        Scanner input = new Scanner(System.in);

        
        // login
        while (true) {
          System.out.println("Brugernavn: ");
          String brugernavn = input.nextLine();

          System.out.println("Password: ");
          String kodeord = input.nextLine();

          if (spil.hentBruger(brugernavn, kodeord))
              break;
          else
              System.out.println("DET ER FORKERT! :-D");

        }
        System.out.println("Tillykke!");
        System.out.println("Dit adgangskode var rigtigt."); 
        
        
        
       /*Scanner sc = new Scanner(System.in);
       int i = sc.nextInt();
                
    boolean aktiv = true;
    while (aktiv)
    {
    //-------------------------------------
    //Gæt et ord til galgeleg
    System.out.println("Indtast et gæt");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    spil.gætBogstav(username);
    //-----------------------------------------
    }    */
    }
    
    
}
