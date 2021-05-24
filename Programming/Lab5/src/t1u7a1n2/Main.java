package t1u7a1n2;

/**
 * Main class of programm to start app.
 * @author Tuan
 */
public class Main {
	public static void main(String[] args) {
		String path = null;
		try{
            path = args[0];
		}catch (InvalidArgumentsException e) {
			System.out.println("Please insert file input via command line argument!");
			System.exit(-1);
		}
        try {
			Manager manager = new Manager(path);
        	manager.start();
        }catch (InvalidArgumentsException e){
            System.out.println(e.getMessage());
        }
    }
}
