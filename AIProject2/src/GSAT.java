import java.util.*;
import java.io.*;



public class GSAT {

	
	public static Boolean[] randomize(int numofvariable)
	{
		Random rand=new Random();
		Boolean[] result=new Boolean[numofvariable+1];
		for(int i=1;i<numofvariable+1;i++)
		{
			int a=rand.nextInt(10);
			
			if(a%2==0)
			{
				result[i]=true;
			}
			else
			{
				result[i]=false;
			}
				
			
		}
		
		return result;
		
	}
	

	public static Boolean PLTrue(Set<Clause> sentence, Boolean[] assignment)
	{
		Boolean clauresult=false;
		
		
		for(Clause c :sentence)
		{
			Set<Integer> temp=c.getClause();
			
			for(Integer i :temp)
			{
				
				int a=i.intValue();
				
				if(a>0&&assignment[a]==true)
				{
					clauresult=true;
				}
				else if(a<0&&assignment[Math.abs(a)]==false)
				{
					clauresult=true;
				}
				
				
				
			}
			if(clauresult==false)
			{
				return false;
			}
			else
			{
				clauresult=false;
			}
			
			
			
		}
		return true;
	
	
	

	
	
	}

	
	
	public static int numofclausesat(Set<Clause> clauses,Boolean[] assignment)
	{
		int num=0;
		for(Clause c:clauses)
		{
			Set<Clause> temp=new HashSet<Clause>();
			temp.add(c);
			if(PLTrue(temp, assignment))
			{
				num++;
				
			}
			
		}
		
		return num;
	}
	
	
	
	
	
	
	
	public static Boolean[] GSATalgo(Set<Clause> a, int maxflips,int maxrestarts )
	{
		Set<Clause> fakenews=new HashSet<Clause>();
		LinkedList<Integer> symbols=modelchecking.symbolsgen(a, fakenews);
		
		
		for(int i=1;i<maxrestarts;i++)
		{
			Boolean[] result=randomize(symbols.size());
			
			
			for(int j=1;j<maxflips;j++)
			{
				if(PLTrue(a, result))
				{
					return result;
				}
				int max=0;
				int fliped=0;
				
				Boolean[] temp=result.clone();
				for(Integer symbol:symbols)
				{
					int sat;
					int o=symbol.intValue();
					result[o]=!result[o];
					sat=numofclausesat(a,result);
					if(sat>max)
					{
						max=sat;
						fliped=o;
					}
					result[o]=!result[o];
					
				}
				
				result[fliped]=!result[fliped];
				
				
				
			}
			
			
		}
		
		return null;
		
	}
	
	public static Set<Clause> example1()
	{
		
		Set<Integer> b= new HashSet<Integer>();
		b.add(1);
		b.add(3);
		b.add(-4);
		Clause c= new Clause(b);
		Set<Integer> d= new HashSet<Integer>();
		d.add(-3);
		d.add(2);
		
		Clause e= new Clause(d);
		Set<Integer> f= new HashSet<Integer>();
		f.add(4);
		Clause g=new Clause(f);
		Set<Clause> test1=new HashSet<Clause>();
		
		test1.add(c);
		test1.add(e);
		test1.add(g);
		return test1;
	}
	
	
	public static Set<Clause> nqueens(int choice)
	{
		File file;
		switch(choice)
		{
		case 4:
			 file=new File("nqueens_4.cnf");
		      break;
		case 8:
			 file=new File("nqueens_8.cnf");
			 break;
		case 12:
			file=new File("nqueens_12.cnf");
			break;
		default:
			 file=new File("nqueens_4.cnf");
			 break;
		}
		
		Scanner sc;
		Set<Clause> clauses=new HashSet<Clause>();
		try {
			   sc = new Scanner(file);
			   // Check if there is another line of input
			   sc.nextLine();
			   
			   
			   while(sc.hasNextLine()){
				   Set<Integer> c=new HashSet<Integer>();
				 if(sc.hasNextInt()) {
					 int i=sc.nextInt();
					  while(i!=0)
					   {
						  
						  c.add(i);
						 i=sc.nextInt();
					   }
					  Clause clause=new Clause(c);
					  clauses.add(clause);
					  
				 }
				 else
				 {
					 System.out.println("Closing ");
					   sc.close();
					   System.out.println("yay");
					  
					   break;
				 }
				 
			    
				
			   }
			   
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		return clauses;
	}
	
	
	
	
	public static Set<Clause> quinn()
	{
		File file=new File("quinn.cnf");
		Scanner sc;
		Set<Clause> clauses=new HashSet<Clause>();
		try {
			   sc = new Scanner(file);
			   // Check if there is another line of input
			   sc.nextLine();
			   sc.nextLine();
			   sc.nextLine();
			   
			   while(sc.hasNextLine()){
				   Set<Integer> c=new HashSet<Integer>();
				 if(sc.hasNextInt()) {
					 int i=sc.nextInt();
					  while(i!=0)
					   {
						  
						  c.add(i);
						 i=sc.nextInt();
					   }
					  Clause clause=new Clause(c);
					  clauses.add(clause);
					  
				 }
				 else
				 {
					 System.out.println("Closing ");
					   sc.close();
					   System.out.println("yay");
					  
					   break;
				 }
				 
			    
				
			   }
			   
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		return clauses;
	}
	
	/*
	public static Set<Clause> aim()
	{
		File file=new File("aim-50-1_6-yes1-4.cnf");
		Scanner sc;
		Set<Clause> clauses=new HashSet<Clause>();
		try {
			   sc = new Scanner(file);
			   // Check if there is another line of input
			  /* for(int i=0;i<11;i++)
			   {
				   sc.nextLine();
				   
			   }
			   sc.nextLine();
			   sc.nextLine();
			   sc.nextLine(); 
			   sc.nextLine();
			   sc.nextLine();
			   sc.nextLine();
			   sc.nextLine();
			   sc.nextLine(); 
			   sc.nextLine(); 
			   sc.nextLine(); 
			   sc.nextLine(); 
			   
			  
			   
			   
			   int count=0;
			   while(sc.hasNextLine()){
				   Set<Integer> c=new HashSet<Integer>();
				 if(sc.hasNextInt()) {
					 int i=sc.nextInt();
					  while(i!=0)
					   {
						  
						  c.add(i);
						  
						 i=sc.nextInt();
					   }
					  Clause clause=new Clause(c);
					  clauses.add(clause);
					  count++;
				 }
				 else
				 {
					 System.out.println("Closing ");
					   sc.close();
					   System.out.println("yay");
					  
					   break;
				 }
				 
			    
				
			   }
			   
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		return clauses;
	}
	
	*/
	public static Set<Clause> par()
	{
		File file=new File("par8-1-c.cnf");
		Scanner sc;
		Set<Clause> clauses=new HashSet<Clause>();
		try {
			   sc = new Scanner(file);
			   // Check if there is another line of input
			   for(int i=0;i<21;i++)
			   {
				   sc.nextLine();
				   
			   }
			   
			   
			  
			   
			   
			   
			   while(sc.hasNextLine()){
				   Set<Integer> c=new HashSet<Integer>();
				 if(sc.hasNextInt()) {
					 int i=sc.nextInt();
					  while(i!=0)
					   {
						  
						  c.add(i);
						 // System.out.println(i);
						 i=sc.nextInt();
						
					   }
					  Clause clause=new Clause(c);
					
					  clauses.add(clause);
					  
					  
				 }
				 else
				 {
					 System.out.println("Closing ");
					   sc.close();
					   System.out.println("yay");
					  
					   break;
				 }
				 
			    
				
			   }
			   
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		return clauses;
	}
	
	
	
	
	public static void start()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Which example do you want to choose? (example1,nqueens,quinn,par)");
		String input1=sc.nextLine();
		switch(input1)
		{
		case "example1":
			System.out.println("Give a maxtries");
			System.out.println("Suggestion:5");
			int a=sc.nextInt();
			System.out.println("Give a maxrestart");
			System.out.println("Suggestion:5");
			int b=sc.nextInt();
			System.out.println(Arrays.toString(GSATalgo(example1(),a,b)));	
			break;
			
		case"nqueens":
			System.out.println("Which one do you want to try?(4,8,12)");
			int input2=sc.nextInt();
			if(input2==4)
			{
				System.out.println("Give a maxtries");
				System.out.println("Suggestion:5");
				int c=sc.nextInt();
				System.out.println("Give a maxrestart");
				System.out.println("Suggestion:5");
				int d=sc.nextInt();
				System.out.println(Arrays.toString(GSATalgo(nqueens(4),c,d)));
			}
			else if(input2==8) 
			{
				System.out.println("Give a maxtries");
				System.out.println("Suggestion:30");
				int e=sc.nextInt();
				System.out.println("Give a maxrestart");
				System.out.println("Suggestion:30");
				int f=sc.nextInt();
				System.out.println(Arrays.toString(GSATalgo(nqueens(8),e,f)));	
				
			}
			else {
				System.out.println("Give a maxtries");
				System.out.println("Suggestion:80");
				int g=sc.nextInt();
				System.out.println("Give a maxrestart");
				System.out.println("Suggestion:80");
				int h=sc.nextInt();
				System.out.println("This gonna take a while.");
				System.out.println(Arrays.toString(GSATalgo(nqueens(12),g,h)));	
			}
			break;
		case"quinn":
			System.out.println("Give a maxtries");
			System.out.println("Suggestion:20");
			int i=sc.nextInt();
			System.out.println("Give a maxrestart");
			System.out.println("Suggestion:20");
			int j=sc.nextInt();
			System.out.println(Arrays.toString(GSATalgo(quinn(),i,j)));	
			break;	
			
		case"par":
			System.out.println("Give a maxtries");
			System.out.println("Suggestion:80");
			int k=sc.nextInt();
			System.out.println("Give a maxrestart");
			System.out.println("Suggestion:80");
			int l=sc.nextInt();
			System.out.println(Arrays.toString(GSATalgo(par(),k,l)));	
			break;
			
		}
		
		
		
	}
	
	public static void main(String[] args) 
	{
		
		/*Boolean[] assignment=new Boolean[10];
		assignment=randomize(10);
		System.out.println(Arrays.toString(assignment));
		Integer a= new Integer(2);
		System.out.println(a.intValue());
		Set<Integer> b= new HashSet<Integer>();
		b.add(1);
		b.add(3);
		b.add(-4);
		Clause c= new Clause(b);
		Set<Integer> d= new HashSet<Integer>();
		d.add(-3);
		d.add(2);
		
		Clause e= new Clause(d);
		Set<Integer> f= new HashSet<Integer>();
		f.add(4);
		Clause g=new Clause(f);
		Set<Clause> test1=new HashSet<Clause>();
		
		test1.add(c);
		test1.add(e);
		test1.add(g);
		Boolean[] assign= {null,true,false,false,false};
		
		System.out.println(numofclausesat(test1,assign));
		System.out.println(modelchecking.PLTrue(test1, assign));
		System.out.println(Arrays.toString(GSATalgo(test1,8,4)));
		*/
		
		//File file=new File("/Users/Leon/eclipse-workspace/AIProject2/src/nqueens_4.cnf");
		
		
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Demonstration for Problem 1:");
		System.out.println("-------------------------------------------------------\n");
		if(Part2.problem1() == true) {
			System.out.println("{P, P ⇒ Q} |= Q : true");
		} else {
			System.out.println("{P, P ⇒ Q} does not entail Q: false");
		}
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Demonstration for Problem 2:");
		System.out.println("-------------------------------------------------------\n");
		Part2.problem2();
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Demonstration for Problem 3\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("Note: We did it by hand first.");
		Part2.problem3();
		
			System.out.println("Demostrating part3");
		start();
		
	}
	
	
	
	
}
