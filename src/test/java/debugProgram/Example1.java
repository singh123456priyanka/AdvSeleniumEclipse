package debugProgram;

public class Example1 {

	public static void main(String[] args) {

		int a,b,num;
		a=10;
		b=20;
		System.out.println("::Before swap::");

		System.out.println("a= "+a);
		System.out.println("b= "+b);
		num=a;
		a=b;
		b=num;
		System.out.println("::After swap::");
		System.out.println("a= "+a);
		System.out.println("b= "+b);

	}

}
