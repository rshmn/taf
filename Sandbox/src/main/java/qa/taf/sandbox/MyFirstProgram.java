package qa.taf.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		
		hello("Kirill");
		double l = 5;
		System.out.println("SQ = "+ area(l));
		double a = 4;
		double b = 6;
		System.out.println("SQ = " + area(a,b));

	}
	public static void hello(String somebody){

		System.out.println("Hello, " + somebody + "!");
	}

	public static double area (double l){
		return l * l;
	}
	public static double area(double a, double b){
		return a * b;
	}
}
