import java.util.Scanner;
abstract class shape2
{
	abstract void area();
}
class rectangle implements shape2
{
	public void area()
	{
		int l;
		int w;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the length :");
		l=s.nextInt();
		System.out.println("Enter the width :");
		w=s.nextInt();
		int areaofr= l * w ;
		System.out.println("area of rectangle ="+areaofr);
	}
}
class triangle implements shape2
{
	public void area()
	{
		int b;
		int h;
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the brath:");
		b=s1.nextInt();
		System.out.println("Enter the hieght:");
		h=s1.nextInt();
		int areaoft= 0.5 * b * h;
		System.out.println("area of triangle ="+areaoft);
	}
}
class circle implements shape2
{
	public void area()
	{
		int r;
		Scanner s2=new Scanner(System.in);
		System.out.println("Enter the radius:");
		r=s2.nextInt();
		int areaofc= 3.14 * r * r;
		System.out.println("area of circle ="+areaofc);

	}
	public static void main(String args[])
	{
		rectangle ob1=new rectangle();
		ob1.area();
		triangle ob2=new triangle();
		ob2.area();
		circle ob3=new circle();
		ob3.area();
	}
}
