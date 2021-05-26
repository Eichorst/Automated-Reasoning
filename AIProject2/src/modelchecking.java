import java.util.*;



public class modelchecking {

	
	
	public static Boolean PLTrue(Set<Clause> sentence, Boolean[] assignment)
	{
		Boolean clauresult=false;
		
		
		for(Clause c :sentence)
		{
			Set<Integer> temp=c.getClause();
			
			for(Integer i :temp)
			{
				
				int a=i.intValue();
				
				if(assignment[Math.abs(a)]!=null) {
					if(a>0 && assignment[a]==true)
					{
						clauresult=true;
					}
					else if(a<0 && assignment[Math.abs(a)]==false)
					{
						clauresult=false;
					}
				} else {
					return true;
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
	
	
	public static LinkedList<Integer> symbolsgen(Set<Clause> KB,Set<Clause> query)
	{
		
		Set<Integer> result= new HashSet<Integer>();
		
		for(Clause c:KB)
		{
			for(Integer i:c.getClause())
			{
				if(i.intValue()<0)
				{
					Integer a=new Integer(Math.abs(i.intValue()));
					result.add(a);
				}
				else
				{
					result.add(i);
				}
				
			}
		}
		
		for(Clause c:query)
		{
			for(Integer i:c.getClause())
			{
				if(i.intValue()<0)
				{
					Integer a=new Integer(Math.abs(i.intValue()));
					result.add(a);
				}
				else
				{
					result.add(i);
				}
			}
		}
		
		LinkedList<Integer> r= new LinkedList<Integer>();
		for(Integer i:result)
		{
			r.add(i);
		}
		
		return r;
		
	}
	
	public static Boolean TTCheckALL(Set<Clause> KB,Set<Clause> query,LinkedList<Integer> symbols,Boolean [] model)
	{
		
		
		if(symbols.isEmpty())
		{
			if(PLTrue(KB,model))
			{
				return PLTrue(query,model);
			}
			else
			{
				return true;
			}
			
		}
		
		else
		{
			Integer i= symbols.getFirst();
			symbols.removeFirst();
			
			//Boolean []modela=model.clone();
			//Boolean []modelb=model.clone();
			Boolean []modela=new Boolean[20];
			Boolean []modelb=new Boolean[20];
			for(int b=0;b<model.length;b++)
			{
			    if(model[b]!=null)
			    {
			    	modela[b]=model[b];
			    	modelb[b]=model[b];
			    }
			}
			int a=i.intValue();
			
			modela[a]=true;
			modelb[a]=false;
			
			
			return TTCheckALL(KB,query,symbols,modela)&& TTCheckALL(KB,query,symbols,modelb);
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		///////////////Example 2
		
		Set<Integer> o = new HashSet<Integer>();
		Set<Integer> p = new HashSet<Integer>();
		Set<Integer> q = new HashSet<Integer>();
		Set<Integer> r = new HashSet<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		
		Set<Integer> t = new HashSet<Integer>();
		t.add(1);
		
		o.add(-1);
		o.add(2);
		
		p.add(1);
		p.add(-2);
		
		q.add(1);
		q.add(3);
		
		r.add(4);
		r.add(-2);
		
		s.add(4);
		s.add(-3);
		
		Clause a = new Clause(o);
		Clause b = new Clause(p);
		Clause c = new Clause(q);
		Clause d = new Clause(r);
		Clause e = new Clause(s);
		
		Clause f = new Clause(t);
		
		Set<Clause> kb = new HashSet<Clause>();
		kb.add(a);
		kb.add(b);
		kb.add(c);
		kb.add(d);
		kb.add(e);
		
		Set<Clause> query = new HashSet<Clause>();
		query.add(f);
		
		LinkedList<Integer> l=symbolsgen(kb,query);
		Boolean[] model=new Boolean[20];
		System.out.println(TTCheckALL(kb,query,l,model));
		
		////////////////Other example
//		
//		Set<Integer> o =new HashSet<Integer>();
//		o.add(-2);
//		o.add(3);
//		o.add(4);
//		
//		
//		
//		Set<Integer> p =new HashSet<Integer>();
//		p.add(-3);
//		p.add(2);
//		Set<Integer> a =new HashSet<Integer>();
//		a.add(-4);
//		a.add(2);
//		
//		Clause s21=new Clause(o);
//		Clause s22=new Clause(p);
//		Clause s23=new Clause(a);
//		
//		Set<Integer> d =new HashSet<Integer>();
//		d.add(-5);
//		d.add(1);
//		d.add(6);
//		d.add(7);
//		
//		Clause s31=new Clause(d);
//		
//		Set<Integer> e =new HashSet<Integer>();
//		e.add(-1);
//		e.add(5);
//		Clause s32=new Clause(e);
//		Set<Integer> f =new HashSet<Integer>();
//		f.add(-6);
//		f.add(5);
//		Clause s33=new Clause(f);
//		Set<Integer> g =new HashSet<Integer>();
//		g.add(-7);
//		g.add(5);
//		Clause s34=new Clause(g);
//		
//		
//		Set<Integer> h =new HashSet<Integer>();
//		h.add(-8);
//		h.add(1);
//		h.add(6);
//		h.add(9);
//		
//		Clause s71=new Clause(d);
//		
//		Set<Integer> i =new HashSet<Integer>();
//		i.add(-1);
//		i.add(8);
//		Clause s72=new Clause(i);
//		
//		
//		Set<Integer> j =new HashSet<Integer>();
//		j.add(-6);
//		j.add(8);
//		Clause s73=new Clause(j);
//		
//		
//		Set<Integer> k =new HashSet<Integer>();
//		k.add(-9);
//		k.add(8);
//		Clause s74=new Clause(k);
//		
//		Set<Integer> l =new HashSet<Integer>();
//		l.add(-2);
//		Clause s41=new Clause(l);
//		
//		Set<Integer> m=new HashSet<Integer>();
//		m.add(-1);
//		Clause s11=new Clause(m);
//		
//		
//		
//		
//		
//		
//		
//		Boolean[] assignment= {true,true,true,true,true,true,true,true, true, true};
//		Set<Clause> KB=new HashSet<Clause>();
//		KB.add(s21);
//		KB.add(s22);
//		KB.add(s23);
//		KB.add(s31);
//		KB.add(s32);
//		KB.add(s33);
//		KB.add(s34);
//		KB.add(s71);
//		KB.add(s72);
//		KB.add(s73);
//		KB.add(s74);
//		KB.add(s41);
//		KB.add(s11);
//		
//		
//		
//		
//		
//		
//		
//		
//////		Boolean r=PLTrue(sentence,assignment);
//////		System.out.println(r);
//		Set<Integer> q =new HashSet<Integer>();
//		q.add(-4);
//		Clause c= new Clause(q);
//		Set<Clause> query=new HashSet<Clause>();
//		query.add(c);
//		LinkedList<Integer> lo=symbolsgen(KB,query);
//		Boolean[] model=new Boolean[20];
//		System.out.println(TTCheckALL(KB,query,lo,model));
//
//
//		
//		System.out.println(symbolsgen(KB,query).toString());
//		System.out.println("4+2!");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


