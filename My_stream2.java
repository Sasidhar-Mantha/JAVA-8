package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
class cricketers2
{
public cricketers2(int id, String name, int salary,String team) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.team = team;
	}
public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return salary;
	}
	public void setSal(int salary) {
		this.salary = salary;
	}
	public String getteam() {
		return team;
	}
	public void setteam(String team) {
		this.team = team;
	}
@Override
	public String toString() {
		return "Cricketer [id = " + id + ", name = " + name + ", salary = " + salary + ", team = "+team+ "]";
	}
private int id;
private String name;
private int salary;
private String team;

}
//StreamAPi is class in java which is used to filter and map the data 
//1,2,3,4,5,6,7,8,9
public class My_stream2 {

	public static <T> Predicate<T> distinctByKey(
	        Function<? super T, ?> keyExtractor) {

	        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	    }
	
	public static void main(String args[])
	{
		
		
		 List<cricketers2> ls=new ArrayList<cricketers2>();
		 
		 ls.add(new cricketers2(1, "Virat", 160000000,"RCB")); 
		 ls.add(new cricketers2(2, "Maxwell",100000000,"RCB")); 
		 ls.add(new cricketers2(3, "Siraj", 70000000,"RCB"));
		 ls.add(new cricketers2(4, "Pant", 160000000,"DC"));
		 ls.add(new cricketers2(5, "Axar", 90000000,"DC"));
		 ls.add(new cricketers2(6, "Shaw", 75000000,"DC"));
		 
		 List<String> ls1=ls.stream() .filter(cr->cr.getSal()>=100000000)
		 .map(s->s.getName()) .collect(Collectors.toList());
		 
		 ls1.forEach(s->System.out.println("CRICKETERS WITH SALARY GREATER THAN 10CR ARE "+s));
		 
		 List<String> ls2=ls.stream()
		 .filter(cr->cr.getName().startsWith("S"))
		 .map(s->s.getName().toUpperCase()) .collect(Collectors.toList());
		 System.out.println("**********************************************");
		 System.out.println("Players names starting with 'S'");
		 ls2.forEach(s->System.out.println(s));
		 
		 Comparator<cricketers2> comparator = Comparator.comparing( cricketers2::getSal );
		 cricketers2 minObject = ls.stream().min(comparator).get();
		 cricketers2 maxObject = ls.stream().max(comparator).get();
		 System.out.println("**********************************************");
		 System.out.println("Cricketer with min salary = " + minObject);
		 System.out.println("**********************************************");
		 System.out.println("Cricketer with max salary = " + maxObject);
		 
		 
		 System.out.println("**********************************************");
		 System.out.println("SORTED ORDER OF NAMES:");
		 ls.stream().sorted((p1, p2) -> (p1.getName()).compareTo(p2.getName()))
	        .forEach(person -> System.out.println(person.getName()));
		 
	      List<String> names = ls.stream() 
                  .map(n->n.getName()) 
                  .collect(Collectors.toList());
	      System.out.println("**********************************************");
	      System.out.println("All the names of Players:");
	      System.out.println(names); 
	      System.out.println("**********************************************");
	      System.out.print("No of players with salary below 10Cr : ");
	      long count=ls.stream() .filter(cr->cr.getSal()<100000000).count();
	      System.out.println(count);
	      System.out.println("**********************************************");
	      
	      List<cricketers2> distinctElements = ls.stream().filter(distinctByKey(cr -> cr.getSal()))
					.collect(Collectors.toList());
	      System.out.println(distinctElements);
	      
	      System.out.println("**********************************************");
	      long sum = ls.stream()
	    		  .mapToInt(cr -> cr.getSal())
	    		  .sum();
	      System.out.print("Sum of all Salaries : ");
	      System.out.println(sum);
	      
	      System.out.println("**********************************************");
	      System.out.println("PLAYERS PLAYING FOR DC");
	      List<String> ls5=ls.stream() .filter(cr->cr.getteam()=="DC")
	    			 .map(s->s.getName()) .collect(Collectors.toList());
	      ls5.forEach(s->System.out.println(s));
	}
	
	

}
