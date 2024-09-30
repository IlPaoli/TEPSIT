package StatoThread;

public class principale implements Runnable {
	private int t;
	private Thread[] TH;
	private numeri[] nums;
	
	principale(int t , Thread[] TH , numeri[] nums){
		this.t = t;
		this.TH = TH;
		this.nums = nums;
	}

	public void run() {
        boolean tuttimorti = false;
        while(!tuttimorti) {
        	for(short i = 0; i < t; i++){
        		tuttimorti = true;
        		if(TH[i].isAlive()) {
        			System.out.println(TH[i].threadId() 
        					+ " è ancora vivo : " + nums[i].GetCount());
        			tuttimorti = false;
        		}
        	}
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
        }
	}

}