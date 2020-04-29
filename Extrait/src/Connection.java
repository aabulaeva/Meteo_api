package weather_project;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;



public class Connection {
	private int jour;
	private String ville;
	private String chemin;
	private String url;
	private int woeid;
	private double[] temp;
	
	public Connection(int jour,String ville){
		setJour(jour);
		setVille(ville);
		setChemin();
	}
	public String getVille(){
		return ville;
		
	}
	public int getJour(){
		return jour;
		
	}public String getChemin(){
		return chemin;
		
	}
	public Connection setJour(int jour){
		this.jour=jour;
		return this;
		
	}

	public void setVille(String ville){
	this.ville=ville;
}
	public double temp(String chaine){
//		chaine=chaine.substring(1, chaine.length()-1);
//		System.out.println(chaine);
		JSONObject json = new JSONObject(chaine);


		Iterator<String> it = json.keys();
		double tab = 0.0;
		int c=1;
		while (it.hasNext()){
		

		  String key = it.next();

//		  System.out.println(key);
		  
		  if(c%10==0 ){
//			  System.out.println(json.get(key));
		  tab=(double) json.get(key);
		  }
//		  System.out.println(json.get(key));
		  c++;
		  

		}
		return tab;
		
	}
		
	
	
	public Connection setChemin(){
		this.chemin="https://www.metaweather.com/api/location/search/?query=" + this.ville;
		return this;
		
	}
	public String setUrl(String date){
		this.url="https://www.metaweather.com/api/location/"+ this.woeid+"/"+date;
		return this.url;
		
	}
	public int setWoeid(int woeid){
		this.woeid=woeid;
		return this.woeid;
		
	}
	private String readStream(InputStream is) throws IOException {

	    StringBuilder sb = new StringBuilder();  

	    BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);  

	    for (String line = r.readLine(); line != null; line =r.readLine()){  

	        sb.append(line);  

	    }  

	    is.close();  

	    return sb.toString();

	}
	public String ObjectJson(URLConnection connexion){
		try {

			InputStream flux = new BufferedInputStream(connexion.getInputStream());
			String chaine=readStream(flux);
			chaine=chaine.substring(1, chaine.length()-1);
//			System.out.println(chaine);
			flux.close();
			return chaine;

	} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
	}
	public int woeid(String chaine){
		JSONObject json = new JSONObject(chaine);


		Iterator<String> it = json.keys();
		int woeid = 0;
		int c=1;
		while (it.hasNext()){
		

		  String key = it.next();

//		  System.out.println(key);
//		  System.out.println(key.length());
		  
		  if(c==2){
		  woeid=(int) json.get(key);
		  }
//		  System.out.println(json.get(key));
		  c++;

		}
		return woeid;
		
	}
	
	public double[] setTemp(double temp[],double tab,int i){
		temp[i]=tab;
		return temp;
	}
	
	public void getTemp(){
		for(int i=0;i<this.temp.length;i++){
			System.out.println(this.temp[i]);
		}
	}
		
	
	public double[] httprequest() throws IOException{
			this.chemin=getChemin();
			this.ville=getVille();
			this.jour=getJour();
			this.temp=new double[this.jour];
			URL u=new URL(this.chemin);
			URLConnection connexion=u.openConnection();
			String chaine=ObjectJson(connexion);
				
			int woeid=woeid(chaine);
			this.woeid=setWoeid(woeid);
			
			Calendar date=new GregorianCalendar();
			int i=0;
			while(i<this.jour){
				String dateDemain = date.get(Calendar.YEAR) +"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.DATE);
				this.url=setUrl(dateDemain);
				URL url=new URL(this.url);
				connexion=url.openConnection();
				chaine=ObjectJson(connexion);
				double tab=temp(chaine);
				this.temp=setTemp(this.temp,tab,i);
				date.add(Calendar.DATE, 1);
				i++;
			}
//			getTemp();
			return this.temp;

			
			
	}
	

}
