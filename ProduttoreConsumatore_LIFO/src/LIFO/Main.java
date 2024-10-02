package LIFO;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Consumatore consumatore = new Consumatore(buffer);
		Produttore produttore = new Produttore(buffer);
		
		Thread cons = new Thread(consumatore);
		Thread prod = new Thread(produttore);
		
		prod.start();
		cons.start();
		
	}

}
