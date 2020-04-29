package weather_project;

public class Temperature extends ElementMeteo{
  private int temperature;

  public Temperature(String ville, int jour){
	super();
    this.temperature = 0;
    //this.setTemperature(ville, jour);
  }

//  public int getTemperature(String ville, int jour) {	  	
//		return temperature;
//  }
//  
//  public void setTemperature(String ville, int jour) {
//	  this.temperature = ;
//  }

  public void afficheTemperature(int n_jours, double temperatures[]){
	  int i;
	  
	  System.out.print("              +-----+");
	  for (i = 0; i < n_jours - 1; i++ ) {
			System.out.print("-----+");
	  }
	  System.out.println("");
	  
	  
	  System.out.print("              | J+");
	  System.out.print(0);
	  System.out.print(" |");

	  for (i = 1; i < n_jours; i++ ) {
		  	System.out.print(" J+");
			System.out.print(i);
			System.out.print(" |");
	  }
	  System.out.println("");

	  
	  System.out.print("+-------------+-----+");

	  for (i = 0; i < n_jours - 1; i++ ) {
			System.out.print("-----+");
	  }
	  System.out.println("");

	  System.out.print("|             |");
	  for (i = 0; i < n_jours; i++ ) {
		  System.out.print(" ");
		  if ((int)Math.floor(temperatures[i])/10 == 0)
			  System.out.print(" ");
		  System.out.print((int)Math.floor(temperatures[i]));
		  System.out.print("° |");
	  }
	  System.out.println("");

	  
	  System.out.print("+-------------+-----+");
	  for (i = 0; i < n_jours - 1; i++ ) {
			System.out.print("-----+");
	  }
	  System.out.println("");

  }
}