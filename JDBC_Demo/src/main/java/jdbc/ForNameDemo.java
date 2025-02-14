package jdbc;

import java.sql.DriverManager;

class abc{
	static {
		System.out.println("static block");
	}
	{
		System.out.println("instance block");
	}
}

public class ForNameDemo {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		
		//abc obj=new abc();				// o/p -->static block  /n instance block
		
		//Class.forName("jdbc.abc");     // o/p --> static block
		
		Class.forName("jdbc.abc").newInstance();
		

		
	}
	

}
