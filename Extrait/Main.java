package weather_project;
import java.io.IOException;
import java.net.URLConnection;


public class Main {
	public static void main(String[] args) throws IOException {
		String ville=" ";
		int jour=0;
	 	for (int i=0; i<args.length; i++)
	 	{
	 	    if ("-l".equals(args[i]))
	 	   {
	 	       ville=args[i+1];
	 	   }
	 	   if ("-j".equals(args[i]))
	 	   {
	 	       jour =Integer.parseInt(args[i+1]);
	 	   }
	 	}
//	 	System.out.println(jour);
//	 	System.out.println(ville);
	 	
	 	Connection a=new Connection(jour,ville);
	 	double temperatures[] = a.httprequest();
	 // Récpération informations
		Ville ville_demande = new Ville(ville);
		Temperature t = new Temperature(ville, jour);
//		
//		
//	
//	 // Affichage	
	    ville_demande.afficheVille();
	    t.afficheTemperature(jour, temperatures);
	}


}
