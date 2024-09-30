package Teatro;

/*
 * A Teatro
	Considerare uno scenario in cui in un cinema gli spettatori arrivano per comprare dei biglietti 
	per un film, il cinema è composto da 15 file ogniuna con 46 posti. Ogni spettatore prova a 
	prenotare i posti centrali, e la biglietteria gli fornisce sempre i posti più vicini.
	Definire quali sono le entità attiva e quali sono le risorse (entità passive) del sistema e creare 
	un programma che simula con la creazione di 7 Thread la prenotazione dei posti. La 
	simulazione deve prevedere che lo spettacolo può iniziare una volta passati 10 secondi e deve 
	mostrare il numero di posti disponibili rimasti nel cinema.
	La simulazione deve garantire che lo stesso posto viene venduto a due spettatori diversi e che 
	non vengono venduti più posti di quelli disponibili.
	La simulazione deve utilizzare delle stampe a video per far capire l’implementazione dello 
	scenario
 */

public class gestore {
	public static void main(String[] args) {
		teatro Teatro = new teatro(15,46);
		
        Thread[] spettatori = new Thread[7]; 
        for (int i = 0; i < spettatori.length; i++) {
            spettatori[i] = new Thread(new spettatore(Teatro, "Spettatore " + (i + 1)));
        }
        
        for (Thread spettatore : spettatori) { // foreach
            spettatore.start();
        }
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
        System.out.println("Lo spettacolo sta per iniziare");
        
        for (Thread spettatore : spettatori) {
            try {
				spettatore.join();
			} catch (InterruptedException e) {}
        }
        
        Teatro.mappaPosti();
        
        System.out.println("Posti disponibili: " + Teatro.postiavanzati());

	}
}
