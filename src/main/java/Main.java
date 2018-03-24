import java.io.IOException;
import static spark.Spark.*;

import model.Model;
import view.View;

public class Main {

	private static Model model;

	public static void main(String[] args) throws NullPointerException, InterruptedException, IOException {

		model = Model.getInstance();
		// initializeModel(model);
		View view = new View(model);
		model.registerObserver(view); // connection Model -> View
		view.receiveUsersMessages();
		
		 ProcessBuilder process = new ProcessBuilder();
	        int myPort;
	        if (process.environment().get("PORT") != null) {
	            myPort = Integer.parseInt(process.environment().get("PORT"));
	        } else {
	            myPort = 8080;
	        }
	        port(myPort);


	}

}