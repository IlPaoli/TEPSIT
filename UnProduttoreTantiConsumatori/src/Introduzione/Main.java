package Introduzione;


public class Main {

	public static void main(String[] args) {
		
		int C = 7;
		
		Buffer buf = new Buffer();
		
		Thread thr[] = new Thread[C];
		
		for(Thread t : thr) {
			
			t = new Thread(new Consumatore(buf));
			
			t.start();
			
		}
		
		Thread tmp = new Thread(new Produttore(buf));
		
		tmp.start();

	}

}
