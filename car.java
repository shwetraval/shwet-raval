import java.util.Scanner;
class car
{
	public int topspeed;
	public String name;
	
	void getdata()
	{
	Scanner s1=new Scanner(System.in);
	System.out.println("Enter the topspeed :");
	topspeed=s1.nextInt();
	System.out.println("Enter the car name :");
	name=s1.next();
	}
	
	public String toString()
	{
		return topspeed+" "+name;
	}
	public static void main(String args[])
	{
		car obj=new car();
		car obj1=new car();
		car obj2=new car();
		car obj3=new car();
		car obj4=new car();
		obj.getdata();
		obj1.getdata();
		obj2.getdata();
		obj3.getdata();
		obj4.getdata();
		System.out.println(obj);
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
	}
}