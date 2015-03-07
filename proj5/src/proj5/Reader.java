package proj5;
import javax.swing.JOptionPane; 

public class Reader {
	int i, k;
	String n1, n2;
	public void Scan(){
		n1 = JOptionPane.showInputDialog("Введите первое число");
		n2 = JOptionPane.showInputDialog("Введите второе число");
		i = Integer.parseInt(n1);
		k = Integer.parseInt(n2);
		
	}
	
	public void Scan(int a, int b){
		JOptionPane.showMessageDialog(null, "Теперь ваше 1 число = " +a);
		JOptionPane.showMessageDialog(null, "Теперь ваше 2 число = " +b);
	}

}