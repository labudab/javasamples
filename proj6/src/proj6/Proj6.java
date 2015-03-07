package proj6;

import javax.swing.JFrame;

public class Proj6 {
	public static void main (String args[]){
		Reader r = new Reader("Заголовок окна");
		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(300, 200);
		r.setResizable(false);
		r.setLocationRelativeTo(null); //размещение окна при запуске
	}

}
