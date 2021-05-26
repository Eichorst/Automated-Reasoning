import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Part2 {
	
	public static boolean problem1() {
		//clause a
		Set<Integer> o =new HashSet<Integer>();
		o.add(1);
		
		//clause b
		Set<Integer> p =new HashSet<Integer>();
		p.add(-1);
		p.add(2);
		
		Clause a=new Clause(o);
		Clause b=new Clause(p);
		
		//add clauses to KB
		Set<Clause> KB=new HashSet<Clause>();
		KB.add(a);
		KB.add(b);
		
		//clause c, and add clause c to query
		Set<Integer> i =new HashSet<Integer>();
		i.add(2);
		Clause c= new Clause(i);
		Set<Clause> query=new HashSet<Clause>();
		query.add(c);
		
		
		LinkedList<Integer> l=modelchecking.symbolsgen(KB,query);
		Boolean[] model=new Boolean[20];
		return (modelchecking.TTCheckALL(KB,query,l,model));
	}
	
	public static void problem2() {
		Set<Integer> r1 = new HashSet<Integer>();
		r1.add(-1);
		Clause a = new Clause(r1);
		
		Set<Integer> r2_a = new HashSet<Integer>();
		Set<Integer> r2_b = new HashSet<Integer>();
		Set<Integer> r2_c = new HashSet<Integer>();
		r2_a.add(-7);
		r2_a.add(2);
		r2_a.add(4);
		r2_b.add(7);
		r2_b.add(-2);
		r2_c.add(7);
		r2_c.add(-4);
		
		Clause b = new Clause(r2_a);
		Clause c = new Clause(r2_b);
		Clause d = new Clause(r2_c);
		
		
		Set<Integer> r3_a = new HashSet<Integer>();
		Set<Integer> r3_b = new HashSet<Integer>();
		Set<Integer> r3_c = new HashSet<Integer>();
		Set<Integer> r3_d = new HashSet<Integer>();
		r3_a.add(-8);
		r3_a.add(1);
		r3_a.add(5);
		r3_a.add(10);
		r3_b.add(8);
		r3_b.add(-1);
		r3_c.add(8);
		r3_c.add(-5);
		r3_d.add(8);
		r3_d.add(-10);
		
		Clause e = new Clause(r3_a);
		Clause f = new Clause(r3_b);
		Clause g = new Clause(r3_c);
		Clause h = new Clause(r3_d);
		
		Set<Integer> r7_a = new HashSet<Integer>();
		Set<Integer> r7_b = new HashSet<Integer>();
		Set<Integer> r7_c = new HashSet<Integer>();
		Set<Integer> r7_d = new HashSet<Integer>();
		r7_a.add(-8);
		r7_a.add(1);
		r7_a.add(5);
		r7_a.add(3);
		r7_b.add(8);
		r7_b.add(-1);
		r7_c.add(8);
		r7_c.add(-5);
		r3_d.add(8);
		r7_d.add(-3);
		
		Clause i = new Clause(r7_a);
		Clause j = new Clause(r7_b);
		Clause k = new Clause(r7_c);
		Clause l = new Clause(r7_d);
		
		System.out.println("Add first perception, R4 \n");
		
		Set<Integer> r4 = new HashSet<Integer>();
		r4.add(-7);
		
		Clause m = new Clause(r4);
		
		
		//build kb1
		Set<Clause> kb1 = new HashSet<Clause>();
		kb1.add(a);
		kb1.add(b);
		kb1.add(c);
		kb1.add(d);
		kb1.add(e);
		kb1.add(f);
		kb1.add(g);
		kb1.add(h);
		kb1.add(i);
		kb1.add(j);
		kb1.add(k);
		kb1.add(l);
		kb1.add(m);
		
		Set<Integer> q1Clause = new HashSet<Integer>();
		q1Clause.add(-2);
		Clause q1IsClause = new Clause(q1Clause);
		Set<Clause> q1 = new HashSet<Clause>();
		q1.add(q1IsClause);
		
		Set<Integer> q2Clause = new HashSet<Integer>();
		q2Clause.add(-4);
		Clause q2IsClause = new Clause(q2Clause);
		Set<Clause> q2 = new HashSet<Clause>();
		q2.add(q2IsClause);
		
		Set<Integer> q3Clause = new HashSet<Integer>();
		q3Clause.add(5);
		Clause q3IsClause = new Clause(q3Clause);
		Set<Clause> q3 = new HashSet<Clause>();
		q3.add(q3IsClause);
		
		Set<Integer> q4Clause = new HashSet<Integer>();
		q4Clause.add(-5);
		Clause q4IsClause = new Clause(q4Clause);
		Set<Clause> q4 = new HashSet<Clause>();
		q4.add(q4IsClause);
		LinkedList<Integer> list1 = modelchecking.symbolsgen(kb1,q1);
		Boolean[] model=new Boolean[100];
		System.out.println("Entails not P_1_2: "+ modelchecking.TTCheckALL(kb1,q1,list1,model));
		LinkedList<Integer> list2 = modelchecking.symbolsgen(kb1,q2);
		Boolean[] model2=new Boolean[100];
		System.out.println("Entails not P_2_1: "+ modelchecking.TTCheckALL(kb1,q2,list2,model2));
		LinkedList<Integer> list3 = modelchecking.symbolsgen(kb1,q3);
		Boolean[] model3=new Boolean[100];
		System.out.println("Entails P_2_2: "+ !modelchecking.TTCheckALL(kb1,q3,list3,model3));
		LinkedList<Integer> list4 = modelchecking.symbolsgen(kb1,q4);
		Boolean[] model4=new Boolean[100];
		System.out.println("Entails not P_2_2: "+ !modelchecking.TTCheckALL(kb1,q4,list4,model4));
		///Perception R5
		System.out.println("\nAdd second perception, R5 \n");
		Set<Integer> perR5 = new HashSet<Integer>();
		perR5.add(9);
		Clause perR5KBclause = new Clause(perR5);
		kb1.add(perR5KBclause);
		
		
		Set<Integer> q2ClauseR5 = new HashSet<Integer>();
		q2ClauseR5.add(5);
		q2ClauseR5.add(6);
		Clause q2IsClauseR5 = new Clause(q2ClauseR5);
		Set<Clause> q2R5 = new HashSet<Clause>();
		q2R5.add(q2IsClauseR5);
		
		Set<Integer> q3ClauseR5 = new HashSet<Integer>();
		q3ClauseR5.add(5);
		Clause q3IsClauseR5 = new Clause(q3ClauseR5);
		Set<Clause> q3R5 = new HashSet<Clause>();
		q3R5.add(q3IsClauseR5);
		
		Set<Integer> q4ClauseR5 = new HashSet<Integer>();
		q4ClauseR5.add(-5);
		Clause q4IsClauseR5 = new Clause(q4ClauseR5);
		Set<Clause> q4R5 = new HashSet<Clause>();
		q4R5.add(q4IsClauseR5);
		
		Set<Integer> q5ClauseR5 = new HashSet<Integer>();
		q5ClauseR5.add(10);
		Clause q5IsClauseR5 = new Clause(q5ClauseR5);
		Set<Clause> q5R5 = new HashSet<Clause>();
		q5R5.add(q5IsClauseR5);
		
		Set<Integer> q6ClauseR5 = new HashSet<Integer>();
		q6ClauseR5.add(-10);
		Clause q6IsClauseR5 = new Clause(q6ClauseR5);
		Set<Clause> q6R5 = new HashSet<Clause>();
		q6R5.add(q6IsClauseR5);

		
		LinkedList<Integer> list2R5 = modelchecking.symbolsgen(kb1,q2R5);
		Boolean[] model2R5=new Boolean[100];
		System.out.println("Entails P_2_2 V P_3_1: "+ modelchecking.TTCheckALL(kb1,q2R5,list2R5,model2R5));
		LinkedList<Integer> list3R5 = modelchecking.symbolsgen(kb1,q3R5);
		Boolean[] model3R5=new Boolean[100];
		System.out.println("Entails P_2_2: "+ !modelchecking.TTCheckALL(kb1,q3R5,list3R5,model3R5));
		LinkedList<Integer> list4R5 = modelchecking.symbolsgen(kb1,q4R5);
		Boolean[] model4R5=new Boolean[100];
		System.out.println("Entails not P_2_2: "+ !modelchecking.TTCheckALL(kb1,q4R5,list4R5,model4R5));
		LinkedList<Integer> list5R5 = modelchecking.symbolsgen(kb1,q5R5);
		Boolean[] model5R5=new Boolean[100];
		System.out.println("Entails P_3_1: "+ !modelchecking.TTCheckALL(kb1,q5R5,list5R5,model5R5));
		LinkedList<Integer> list6R5 = modelchecking.symbolsgen(kb1,q6R5);
		Boolean[] model6R5=new Boolean[100];
		System.out.println("Entails not P_3_1: "+ !modelchecking.TTCheckALL(kb1,q6R5,list6R5,model6R5));
		System.out.println("\nAdd third perception, R6 \n");
		Set<Integer> lastInt = new HashSet<Integer>();
		lastInt.add(-8);
		Clause lastClause = new Clause(lastInt);
		kb1.add(lastClause);
		Set<Integer> lastQuery1 = new HashSet<Integer>();
		lastQuery1.add(-5);
		Clause lastQClause1 = new Clause(lastQuery1);
		Set<Clause> finalQuery1 = new HashSet<Clause>();
		finalQuery1.add(lastQClause1);
		Set<Integer> lastQuery2 = new HashSet<Integer>();
		lastQuery2.add(10);
		Clause lastQClause2 = new Clause(lastQuery2);
		Set<Clause> finalQuery2 = new HashSet<Clause>();
		finalQuery2.add(lastQClause2);
		LinkedList<Integer> lastList1 = modelchecking.symbolsgen(kb1,q5R5);
		Boolean[] modelLast1=new Boolean[100];
		System.out.println("Entails not P_2_2: "+ modelchecking.TTCheckALL(kb1,finalQuery1,lastList1,modelLast1));
		LinkedList<Integer> lastList2 = modelchecking.symbolsgen(kb1,q6R5);
		Boolean[] modelLast2=new Boolean[100];
		System.out.println("Entails P_3_1: "+ modelchecking.TTCheckALL(kb1,finalQuery2,lastList2,modelLast2));
		
	}
	
	public static void problem3() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(-1);
		set1.add(2);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(1);
		set2.add(-2);
		set2.add(-3);
		Set<Integer> set3a = new HashSet<Integer>();
		set3a.add(4);
		set3a.add(2);
		Set<Integer> set3b = new HashSet<Integer>();
		set3b.add(4);
		set3b.add(-3);
		Set<Integer> set4 = new HashSet<Integer>();
		set4.add(-4);
		set4.add(5);
		
		Clause c1 = new Clause(set1);
		Clause c2 = new Clause(set2);
		Clause c3a = new Clause(set3a);
		Clause c3b = new Clause(set3b);
		Clause c4 = new Clause(set4);
		
		Set<Clause> kb = new HashSet<Clause>();
		kb.add(c1);
		kb.add(c2);
		kb.add(c3a);
		kb.add(c3b);
		kb.add(c4);
		
		
		Set<Integer> cSet1 = new HashSet<Integer>();
		cSet1.add(4);
		Clause queryClauseHorn = new Clause(cSet1);
		Set<Clause> queryHorn = new HashSet<Clause>();
		queryHorn.add(queryClauseHorn);
		
		LinkedList<Integer> l1 = modelchecking.symbolsgen(kb,queryHorn);
		Boolean[] model1=new Boolean[100];
		System.out.println("Does it have a horn? "+ modelchecking.TTCheckALL(kb,queryHorn,l1,model1));
		
		System.out.println("\n*Add horn to KB*\n");
		
		kb.add(queryClauseHorn);
		
		Set<Integer> cSet2 = new HashSet<Integer>();
		cSet2.add(5);
		Clause queryClauseMagic = new Clause(cSet2);
		Set<Clause> queryMagic = new HashSet<Clause>();
		queryMagic.add(queryClauseMagic);
		
		LinkedList<Integer> l2 = modelchecking.symbolsgen(kb,queryMagic);
		Boolean[] model2=new Boolean[100];
		System.out.println("Is it magical? "+ modelchecking.TTCheckALL(kb,queryMagic,l2,model2));
		
		System.out.println("\nWhen doing it by hand, we found that it cannot be shown that it is mythical.");
		
		
	}

	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Demonstration for Problem 1:");
		System.out.println("-------------------------------------------------------\n");
		if(problem1() == true) {
			System.out.println("{P, P ⇒ Q} |= Q : true");
		} else {
			System.out.println("{P, P ⇒ Q} does not entail Q: false");
		}
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Demonstration for Problem 2:");
		System.out.println("-------------------------------------------------------\n");
		problem2();
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Demonstration for Problem 3\n");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("Note: We did it by hand first.");
		problem3();
	}

}
