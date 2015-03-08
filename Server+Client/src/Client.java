//main


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import by.zti.lesson15.Server;

/**
 * Стартовый класс программы
 * 
 * <p>
 * Сделанно в образовательных целях, специально для канала Zhirni Toni Inc.
 * </p>
 * 
 * <p>
 * Вторая программа для туториала, является клиентом для ранее созданного локального сервера.
 * </p>
 * 
 * @author Cvazer
 * @version 1.0
 * @since 1.0
 */
public class Main {
	static JLabel l1;
	public static void setL1(String s) {
		l1.setText(s);
	}

	static Server s = new Server();
	static Thread th = new Thread (s);
	static JButton b1 = new JButton("Send");
	static JTextField t1 = new JTextField(10);
	static JFrame frame = new JFrame("Message");
	static Connector cn = new Connector();
	
	/**
	 * @param args Массив аргументов для программы.
	 */
	public static void main(String[] args) {	
		th.start();
		l1 = new JLabel("");
		Thread th1 = new Thread(cn);
		th1.start();
		l1.setText("Соединения устанавливаются...");
		createGUI();	
	}

	/**
	 * Метод для создания интерфейса
	 */
	private static void createGUI() {
		frame.setLayout(new FlowLayout());
		frame.add(l1);
		frame.add(t1);
		frame.add(b1);
		frame.pack();
		frame.setSize(340, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					cn.sendData(t1.getText());
				}
			}
		});
	}
}
// connector


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 * Класс для связи с сервером
 * 
 * <p>
 * Подготовленно в образовательных целях, специально для канала Zhirni Toni Inc.
 * </p>
 * 
 * <p>
 * Класс, выполняемый в отдельном потоке, 
 * предназначенный для установления соединения 
 * между клиентом и сервером
 * </p>
 * 
 * @author Cvazer
 * @created 09.07.2013
 * @version 1.0
 * @since 1.0
 */
public class Connector implements Runnable{
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static Socket connection;
	private static boolean isRunning = true;
	
	/**
	 * Метод стартующий при запуске потока.
	 * 
	 * Устанавливает соединения и начинает читать input.
	 */
	@Override
	public void run() {
		try {
			while(isRunning){
				connection = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input = new ObjectInputStream(connection.getInputStream());
				Main.setL1("Соединение установленно");
				JOptionPane.showMessageDialog(null, (String)input.readObject());
			}
			close();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	/**
	 * Передает данные на сервер.
	 * 
	 * @param s Строка, которую нужно передать.
	 */
	public void sendData(String s){
		try {
			output.flush();
			output.writeObject(s);
			output.flush();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	/**
	 * Закрывает соединения
	 * 
	 * Метод закрывает соединения, чтобы не возникало 
	 * дальнейших проблем при последующем запуске приложения
	 */
	public void close() {
		try {
			isRunning = false;
			output.close();
			input.close();
			connection.close();
		} catch (Exception e) {e.printStackTrace();}
	}

}

