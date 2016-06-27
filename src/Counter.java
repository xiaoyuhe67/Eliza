
public class Counter implements Runnable{
	private int count=1;
	private long sum = 0;
	
	private static final int CHILDCALLED = 1;
	private static final int GODCALLED = 2;
	
	private int whoCalled = 1;
	
	public void setWhoCalled(int whoCalled) {
		this.whoCalled = whoCalled;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				sum += 10;
				Thread.sleep(5000);
				System.out.println("Random Comment");
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
				//System.out.println("I hear you...I will come to help you soon..");
				if(this.whoCalled == GODCALLED) {
					break;
				}
			}
			Thread mainthread = Thread.currentThread();
			
			System.out.println("Thread: "+mainthread.getName()+", Count: "+count);
			
			count++;
		}
		
		
	}

}
