package zaino;

import java.util.ArrayList;
import java.util.List;

public class Zaino 
{

	private int capienza; // peso max sopportato dallo zaino
	private List<Pezzo> pezzi; // pezzi da provare a inserire
	
	
	
	/**
	 * Inizializza un nuovo problema dello zaino
	 * @param capienza
	 */
	public Zaino(int capienza) 
	{
		this.capienza = capienza;
		this.pezzi = new ArrayList<Pezzo>();
	}
	
	/**
	 * Aggiunge un nuovo pezzo al problema dello zaino
	 * il nuovo pezzo è diverso da quelli già presenti
	 * 
	 * @param p il pezzo da provare ad aggiungere
	 */
	public void add(Pezzo p)
	{
		if (!pezzi.contains(p))
		{
			pezzi.add(p);
		}
		else
			throw new IllegalArgumentException("Pezzo duplicato "+ p);
		
	}



	public static void main(String[] args) 
	{
		Zaino z = new Zaino(15);
		
		z.add(new Pezzo(12,4, "Verde"));
		z.add(new Pezzo(2,2, "Azzurro"));
		z.add(new Pezzo(1,1, "Salmone"));
		z.add(new Pezzo(4,10, "Giallo"));
		z.add(new Pezzo(1,2, "Grigio"));
		
		Set<Pezzo> soluzione= z.risolvi();
		
		System.out.println(soluzione);
		
	}

}
