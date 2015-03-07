package proj5;

public class proj5 {
	public static void main(String args[]){
		Reader r = new Reader(); //Ссылка на объект (класс Reader)
		r.Scan(); //Вызов метода Scan из класса Reader
		r.i = count(r.i);
		r.k = count(r.k);
		r.Scan(r.i, r.k);
	}
	private static int count(int x){
		x = x + 1;
		return x;
	}
}
