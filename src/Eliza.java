import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Eliza {
	
	private static Set<String> hedgeSet = new HashSet<String>();

	private static Set<String> qualifierSet = new HashSet<String>();

	private static Map<Integer,String> replacementMap = new HashMap<Integer,String>();
	
	private static Scanner sc=new Scanner(System.in);
	
	private static Random rand=new Random();
	
	public static Set<String> getHedgeSet() {
		return hedgeSet;
	}


	public static void setHedgeSet(Set<String> hedgeSet) {
		Eliza.hedgeSet = hedgeSet;
	}


	public static Set<String> getQualifierSet() {
		return qualifierSet;
	}


	public static void setQualifierSet(Set<String> qualifierSet) {
		Eliza.qualifierSet = qualifierSet;
	}


	public static int getHedges() {
		return hedges;
	}


	public static void setHedges(int hedges) {
		Eliza.hedges = hedges;
	}


	public static boolean isContain() {
		return contain;
	}


	public static void setContain(boolean contain) {
		Eliza.contain = contain;
	}


	public static int getQualify() {
		return qualify;
	}


	public static void setQualify(int qualify) {
		Eliza.qualify = qualify;
	}

	private static boolean contain=false;
	
	private static int qualify=rand.nextInt(2);
	private static int hedges=rand.nextInt(2);
	
	private static String response;
	
	public static void main(String[] args)
	{
		
		Counter mom = new Counter();
		Thread th1=new Thread(mom);
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing.");
		hedgeSet.add("It is getting late, maybe we have better quit.");
		
		
		System.out.println("Good day. What is your problem?");
	    System.out.println("Enter your response here or Q to quit: ");
		
	    th1.start();
		
	    
		while(1>0)
		{
			
			response=sc.nextLine();
			
			if(response.equals("Q"))
			{Set<String> Set = new HashSet<String>();
				break;
			}
			
			String[] changeInput = response.split(" ");
			
			qualifierSet=Quilify(changeInput);
			
			if(contain==true)
			{
				replacementMap=Replacement(changeInput);		
				
				if(qualify==0)
				{
				String value = qualifierSet.toArray(new String[3])[0];
			    System.out.println(value);
				}
				else if(qualify==1)
				{
				String value = qualifierSet.toArray(new String[3])[1];
			    System.out.println(value);
				}
			
				else if(qualify==2)
				{
				String value = qualifierSet.toArray(new String[3])[2];
			    System.out.println(value);
				}
			
			}
			else if(contain==false)
			{
			
				if(hedges==0)
				{
					String value = hedgeSet.toArray(new String[3])[0];
					System.out.println(value);
				}
				else if(hedges==1)
				{
					String value = hedgeSet.toArray(new String[3])[1];
					System.out.println(value);
				}
			
				else if(hedges==2)
				{
					String value = hedgeSet.toArray(new String[3])[2];
					System.out.println(value);
				}
			}	
			
		}
		th1.interrupt();
		sc.close();
	}
	
	
	public static Set<String> Quilify(String[] str)
	{
		Set<String> Set = new HashSet<String>();
		Map<Integer,String> replacementMap = new HashMap<Integer,String>();
		for(int i=0;i<str.length;i++)
		{
			if(str[i].equals("I")||str[i].equals("i")||str[i].equals("me")||str[i].equals("my")||str[i].equals("My")||str[i].equals("am"))
			{
				contain=true;
				replacementMap=Replacement(str);
				String Content="";
				for (Integer key : replacementMap.keySet()) {
			
					Content+=replacementMap.get(key)+" ";	    
					}
        
				Set.add("Why do you say that "+Content);
				Set.add("You Seem to think that "+Content);
				Set.add("So, you are concerned that "+Content);
				
				break;
			}
			contain=false;
		}
						    
		return Set;
		
	}
	
	public static Map<Integer,String> Replacement(String[] str)
	{	
		int length=str.length;
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		for(int i=0;i<length;i++)
		{
			if(str[i].equals("my"))
			{
				map.put(i, "your");
			}
			else if(str[i].equals("My"))
			{
				map.put(i, "your");
			}
			else if(str[i].equals("i"))
			{
				map.put(i, "you");
			}
			else if(str[i].equals("I"))
			{
				map.put(i, "you");
			}
			else if(str[i].equals("am"))
			{
				map.put(i, "are");
			}
			else if(str[i].equals("me"))
			{
				map.put(i, "you");
			}
			else 
			{
				map.put(i, str[i]);
			}
	
		}
		return map;
	}
	
	
	
	
	
	

}
