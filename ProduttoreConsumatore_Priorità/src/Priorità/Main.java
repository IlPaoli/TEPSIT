package Priorità;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Consumatore consumatore = new Consumatore(buffer);
		Produttore produttore = new Produttore(buffer);
		
		Thread cons = new Thread(consumatore);
		Thread prod = new Thread(produttore);
		
		prod.start();
		try {
			Thread.sleep(100);} catch(InterruptedException e) {}
		cons.start();
		
	}

}