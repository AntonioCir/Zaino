/**
 * 
 * https://www.youtube.com/watch?v=B2L7NI32Qck&list=PLqRTLlwsxDL-sGeTwjwMlpE9xEa9TaElg&index=14
 */


package zaino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	/**
	 * Calcola il costo di una soluzione parziale
	 * @param parziale
	 * @return
	 */
	private int costo(Set<Pezzo> parziale)
	{
		int r =0;
		for (Pezzo p:parziale)
		{
			r += p.getCosto();
		}
		return r;
	}
	
	private int peso(Set<Pezzo> parziale)
	{
		int r =0;
		for (Pezzo p:parziale)
		{
			r += p.getPeso();
		}
		return r;
	}
	
	private void scegli(Set<Pezzo> parziale, int livello, Set<Pezzo> best) 
	{
		if(costo(parziale) > costo(best))
		{
			// ho trovato una soluzione migliore
			// devo salvarla in best
			
			best.clear();
			best.addAll(parziale);
			
			System.out.println(best);
		}
		
		for (Pezzo p:pezzi)
		{
			if (!parziale.contains(p))
			{
				//p non c'è ancora, provo a metterlo se non supera la capacità
				if(peso(parziale)+ p.getPeso()<= capienza)
				{
					//provo a mettere p nello zaino
					parziale.add(p);
					//delego la ricerca al livello successivo
					scegli(parziale, livello+1, best);
					//poi rimetti le cose a posto (togli p)
					parziale.remove(p);
					
				}
			}
		}
	}
	
	private Set<Pezzo> risolvi() 
	{
		Set<Pezzo> parziale = new HashSet<Pezzo>();
		Set<Pezzo> best = new HashSet<Pezzo>();
		scegli(parziale,0,best);
		return best;
		
	}

}
