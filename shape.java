class shape
{
	public
	void area(float redius)
	{
		float areaofci= redius * redius ;
		System.out.println("Area of cirle ="+areaofci);
	}
	void area(float length, float width)
	{
		float areaofre= length * width ;
		System.out.println("Area of rectangle ="+areaofre);
	}
	public static void main(String args[])
	{
		shape s1=new shape();
		s1.area(3);
		s1.area(2,3);
	}
}