package proj10;

import java.util.Formatter;
import java.util.Scanner;


public class proj10 {
	
	static Formatter x;
	static Scanner scn;
	
	public static void main(String args[]) {
		try{
			x = new Formatter("res//file.txt");
			scn = new Scanner(System.in);
			System.out.println("Сколько вам лет?");
			int a = (int)Double.parseDouble(scn.next());
			System.out.println("Как вас зовут?");
			String b = scn.next();
			System.out.println("Где вы живете?");
			String c = scn.next();
			x.format("Меня зовут %s, мне %d лет, я живу в городе %s", b, a, c);
			x.close();
		}catch(Exception e){};
	}
}
