
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
		
		Eliza eliza=new Eliza();
		while(true)
		{
			try {
				sum += 10;
				Thread.sleep(5000);
				if(Eliza.isContain()==true)
				{
							
					
					if(Eliza.getQualify()==0)
					{
					String value = Eliza.getQualifierSet().toArray(new String[3])[0];
				    System.out.println(value);
					}
					else if(Eliza.getQualify()==1)
					{
					String value = Eliza.getQualifierSet().toArray(new String[3])[1];
				    System.out.println(value);
					}
				
					else if(Eliza.getQualify()==2)
					{
					String value = Eliza.getQualifierSet().toArray(new String[3])[2];
				    System.out.println(value);
					}
				
				}
				else if(Eliza.isContain()==false)
				{
				
					if(Eliza.getHedges()==0)
					{
						String value = Eliza.getHedgeSet().toArray(new String[3])[0];
						System.out.println(value);
					}
					else if(Eliza.getHedges()==1)
					{
						String value = Eliza.getHedgeSet().toArray(new String[3])[1];
						System.out.println(value);
					}
				
					else if(Eliza.getHedges()==2)
					{
						String value = Eliza.getHedgeSet().toArray(new String[3])[2];
						System.out.println(value);
					}
				}	
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
