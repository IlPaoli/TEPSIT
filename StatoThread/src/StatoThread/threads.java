package StatoThread;

public class threads implements Runnable {
	numeri n;
	public threads(numeri n) {
		this.n = n;
	}
	
    public void run() {
    	int x = n.getX();
        while(n.incCount() != x);
    }
}