package proj2;

public class proj2 { //класс
	public static void main(String args[]){ //метод main, public - публичный (идентификатор доступности), static - (идентификатор переменных), void - (тип возвращения), ((параметры метода - отправка переменной в метод)), в фигурных скобках - тело метода
		int i = 3;
		int k = 5;
		i = count(i);
		k = count(k);
		System.out.println(i);
		System.out.println(k);
	}
	private static int count(int x){
		x = x + 1;
		return x;
	}
}
