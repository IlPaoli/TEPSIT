package LIFO;

public class Produttore implements Runnable{
	private Buffer buf;
	public Produttore(Buffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		while(true) {
			buf.push((int)(Math.random() * 1023));
			try {
				Thread.sleep((long) (Math.random() * (1000 - 100) + 100));
			}catch(InterruptedException e) { }
		}
	}
}