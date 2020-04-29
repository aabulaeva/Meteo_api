package weather_project;


public class Ville{
	private String ville;
	  
	public Ville(String ville){
	  this.ville = ville;
	}

	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	  
	public void afficheVille() {
		System.out.print("La ville est : ");  
	    System.out.println(this.ville);
	}
}