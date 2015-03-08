
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс для сервера
 * 
 * <p>
 * Данный класс подготовлен в учебных целях специально для канала Zhirni Toni Inc.
 * <br>
 * <br>ВК - vk.com/ztinc.html
 * </p>
 * 
 * @author Cvazer
 * @version 1.0
 * @since 1.0
 */
public class Server implements Runnable{
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private boolean isRunning = true;
	
	/**
	 * Метод для старта сервера
	 * <br>
	 * <br>
	 * Открывает и устаннавливает соединения и потоки.
	 * Принимает входящий поток и отправляет его с припиской назад.
	 */
	public void ServerStarter(){
		try{
			server = new ServerSocket(1234, 100);
			while (isRunning) {
				connection = server.accept();
				output = new ObjectOutputStream(connection.getOutputStream());
				output.flush();
				input = new ObjectInputStream(connection.getInputStream());
				output.writeObject("Вы прислали: "+input.readObject());
				output.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	/**
	 * Метод для закрытия потоков и соединений.
	 */
	private void close() {
		try{
			output.close();
			input.close();
			connection.close();
			isRunning = false;
		}catch(Exception e){e.printStackTrace();}
	}

	@Override
	public void run() {
		ServerStarter();
	}

}
