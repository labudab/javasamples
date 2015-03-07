package proj3;
import java.util.*; //(подключение библиотеки для класса Scanner)

public class Reader {
	int i;
	int k;
	public void Scan(){
		System.out.println("Введите первое число");
		Scanner scn = new Scanner(System.in); //Ссылка на стандартный класс из библиотеки Java
		i = scn.nextInt();
		System.out.println("Введите второе число");
		k = scn.nextInt();
	}

}
