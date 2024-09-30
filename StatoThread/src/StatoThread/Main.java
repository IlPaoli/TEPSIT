package StatoThread;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("n:");
        int n = scan.nextInt();
        
        System.out.println("t:");
        int t = scan.nextInt();
        
        scan.close();
        
        Thread[] TH = new Thread[t];
        
        numeri[] nums = new numeri[t];
        
        for(short i = 0; i < t; i++){
        	nums[i] = new numeri(n);
        	threads obj = new threads(nums[i]);
        	TH[i] = new Thread(obj);
        }
        
        
        for(short i = 0; i < t; i++)
        	TH[i].start();
        
        principale obj = new principale(t,TH,nums);
        Thread MainThread = new Thread(obj);
        MainThread.start();
     	try {
			for(short i = 0; i < t; i++)
				TH[i].join();
			MainThread.interrupt();
		} catch (InterruptedException e) {}
        

        System.out.println("TUTTI I THREAD COMPLETATI");
    }

}