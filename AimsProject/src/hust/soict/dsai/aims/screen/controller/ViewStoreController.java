package hust.soict.dsai.aims.screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/view/cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartScreenController(cart, store));
            Parent root = fxmlLoader.load();
            
            Parent sourceParent = ((Node) event.getSource()).getScene().getRoot();
            // Tạo stage mới
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root));
            nextStage.setTitle("Cart - HungHDG - 5062");

            // Gọi hàm khởi tạo item
            initializeItemsInStore();

            // Show stage sau
            nextStage.show();
            Stage currentStage = (Stage) sourceParent.getScene().getWindow();
            if(currentStage instanceof Stage) {
            	currentStage.close();
            }else {
            	System.out.println("The event source is not an instance of Node.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Store store;
    private Cart cart;

    public ViewStoreController(Cart cart, Store store) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        // Call the separate initialization method
        initializeItemsInStore();
    }

    private void initializeItemsInStore() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/view/item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
