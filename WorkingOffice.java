import java.util.Random;
import CLASS3.list3_src.UnboundedQueue;
public class Task3{
	static UnboundedQueue<Customer> queue = new UnboundedQueue<Customer>();
	static Officials[] office = {new Officials("A"), new Officials("B"), new Officials("C") };
	private static class Officials{
		public String name;
		int timeLeft = 0;
		public Officials(String name){
			this.name = name;
			}
		public Officials() { 
			
		}
		public void working(){
			if (timeLeft > 0) timeLeft--;
		}
		public boolean isFree(){
			return timeLeft == 0;
		}
		public void addCase(Customer customer){
			timeLeft = customer.time;	
		}
		public void run()	{	
			Customer customers = new Customer(); 
			customers.run(100);
			int n=0; 
			while (!queue.isEmpty()){
				for (Officials official : office){
					official.working();
					if (official.isFree()){
						Customer customer = queue.dequeue();
						official.addCase(customer);
						System.out.println(n+": "+ "Official"  + official.name +
								" has a new customer with time " + customer.time);
						n++;
					}
				}
			}
		}
	}
	
	private static class Customer{
		int time;	
		public Customer(){		
			time = new Random().nextInt(10);		
		}
		public void run(int NoCustomer){
			//Adding new customers to the queue 
			for (int x = 0; x < NoCustomer; x++){
				queue.enqueue(new Customer());
			}	
		}
	}
	static class Main{
		public static void main(String[] args)
		{
			Officials off=new Officials();
			off.run(); 
		}
	}
}
