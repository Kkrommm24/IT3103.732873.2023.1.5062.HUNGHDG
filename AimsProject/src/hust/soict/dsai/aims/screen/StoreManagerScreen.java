package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StoreManagerScreen extends JFrame {
	private Cart cart;
	private Store store;
	public StoreManagerScreen(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart - HungHDG - 5062");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/view/store.fxml";
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource(CART_FXML_FILE_PATH));
					ViewStoreController controller =
							new ViewStoreController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
