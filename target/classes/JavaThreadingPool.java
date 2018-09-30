import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable {
	
	String location ;
	
	PrintJob(String location){
		this.location=location;
	}
	
	public void run() {
		System.out.println(location+"..Job Started by Thread"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(location+"..Job Completed by Thread"+Thread.currentThread().getName());
	}
}

public class JavaThreadingPool {

	public static void main(String[] args) {
		
		PrintJob [] jobs= { new PrintJob("United Kingdom"),
							new PrintJob("USA"),
							new PrintJob("India"),
							new PrintJob("Singapore"),		
							new PrintJob("Dubai"),
							new PrintJob("Brazil"),		
		};
		
		ExecutorService service=Executors.newFixedThreadPool(4);
		for(PrintJob job:jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}

