/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer;


import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
    public static void main(String[] args) throws Exception 
    {
        URL url = new URL("http://ubuntu4.saluton.dk:9796/Server?wsdl"); // soap - Forbinder til det navn serveren udgiver sig på "GalgeServer"
        QName qname = new QName("http://typeracer/", "LogikService");
        
        Service service = Service.create(url, qname);
        RacerInterface spil = service.getPort(RacerInterface.class);
        
         boolean Spilbegyndt = true;
        boolean Login = true;
         String guess;
        Scanner input = new Scanner(System.in);

        
        // login
        while (Login) {
          System.out.println("Brugernavn: ");
          String brugernavn = input.nextLine();

          System.out.println("Password: ");
          String kodeord = input.nextLine();

          if (spil.hentBruger(brugernavn, kodeord))
              break;
          else
              System.out.println("FORKERT PASSWORD ELLER BRUGERNAVN");

        }
        System.out.println("Tillykke!");
        System.out.println("DIT LOGIN VAR KORREKT");
        System.out.println("VELKOMMEN TIL RACERTYPE");
        spil.nulstil();
        while (Spilbegyndt)
        {
            System.out.println("Indtast følgende sætninger, hurtigst muligt på 60 sekunder");
            guess = input.next();
            spil.gætBogstav(guess);   
            System.out.println(spil.outputTilKlient());
            spil.logStatus();       
            System.out.println(spil.outputTilKlient());    
            if (spil.erSpilletSlut()) Spilbegyndt = false;
        }
      
        //System.out.println("Spillet afsluttes/Forbindelse til server lukkes");
       
    }
}
