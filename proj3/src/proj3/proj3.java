package proj3;

public class proj3 {
	public static void main(String args[]){
		Reader r = new Reader(); //Ссылка на объект (класс Reader)
		r.Scan(); //Вызов метода Scan из класса Reader
		r.i = count(r.i);
		r.k = count(r.k);
		System.out.println("Теперь ваше 1 число = " + r.i);
		System.out.println("Теперь ваше 2 число = " + r.k);
	}
	private static int count(int x){
		x = x + 1;
		return x;
	}
}
