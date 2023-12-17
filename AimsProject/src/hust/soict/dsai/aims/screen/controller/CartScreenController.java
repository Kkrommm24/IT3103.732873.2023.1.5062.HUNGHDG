package hust.soict.dsai.aims.screen.controller;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CartScreenController {			
		@FXML
	    private Label costLabel;
		@FXML
	    private RadioButton radioBtnFilterTitle;

	    @FXML
	    private RadioButton radioBtnFilterId;

	    @FXML
	    private TextField tfFilter;
	    @FXML
	    private TableView<Media> tblMedia;

	    @FXML
	    private TableColumn<Media, String> colMediaTitle;

	    @FXML
	    private TableColumn<Media, String> colMediaCategory;
	    
	    @FXML
	    private TableColumn<Media, Float> colMediaCost;
	    
	    @FXML
	    private Button btnPlay;

	    @FXML
	    private Button btnRemove;

	    private Cart cart;
	    private Store store;
	    public CartScreenController(Cart cart, Store store) {
	        this.cart = cart;
	        this.store = store;
	    }

	    public CartScreenController(Cart cart) {
	    	this.cart = cart;
		}

		@FXML
	    public void initialize() {
	        colMediaTitle.setCellValueFactory(
	                new PropertyValueFactory<Media, String>("title"));
	        colMediaCategory.setCellValueFactory(
	                new PropertyValueFactory<Media, String>("category"));
	        colMediaCost.setCellValueFactory(
	                new PropertyValueFactory<Media, Float>("cost"));
	        tblMedia.setItems(this.cart.getItemsOrdered());
	        
	        btnPlay.setVisible(false);
	        btnRemove.setVisible(false);

	        tblMedia.getSelectionModel().selectedItemProperty().addListener(
	        	new ChangeListener<Media>() {
	            @Override
	            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
	                updateButtonBar(newValue);
	            }
	        });	     
	        tfFilter.textProperty().addListener(new ChangeListener<String>() {
	            @Override
	            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	                showFilteredMedia(newValue);
	            }
	        });
	        costLabel.setText(cart.totalCost() + " $");
	    }
	    
	    void updateButtonBar(Media media) {
	        if (media == null) {
	            btnPlay.setVisible(false);
	            btnRemove.setVisible(false);
	        }
	        else {
	            btnRemove.setVisible(true);
	            if (media instanceof Playable) {
	                btnPlay.setVisible(true);
	            }
	            else {
	                btnPlay.setVisible(false);
	            }
	        }
	    }
	    
	    @FXML
	    void btnPlayPressed(ActionEvent event) throws PlayerException {
	    	try {
	            Media media = tblMedia.getSelectionModel().getSelectedItem();
	            Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).play().toString());
	            alert.showAndWait();
	        } catch (PlayerException e) {
	            e.printStackTrace();
	            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
	            alert.showAndWait();
	        }
       
	    }
	    
	    @FXML
	    void btnViewStorePressed(ActionEvent event) {
	        try {
	            final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/view/store.fxml";
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
	            fxmlLoader.setController(new ViewStoreController(cart, store));
	            Parent root = fxmlLoader.load();

	            // Get the MenuItem's source (which is a MenuItem)
	            MenuItem menuItem = (MenuItem) event.getSource();

	            // Get the MenuItem's parent, which is the ContextMenu
	            ContextMenu contextMenu = menuItem.getParentPopup();

	            // Get the ownerNode, which should be the node that triggered the context menu
	            Node ownerNode = contextMenu.getOwnerNode();

	            // Attempt to find the top-level Stage
	            Stage stage = findTopLevelStage(ownerNode);

	            if (stage != null) {
	                stage.setScene(new Scene(root));
	                stage.setTitle("Store - HungHDG - 5062");
	                stage.show();
	            } else {
	                System.out.println("Unable to find top-level Stage.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private Stage findTopLevelStage(Node node) {
	        Scene scene = node.getScene();
	        if (scene != null) {
	            Window window = scene.getWindow();
	            if (window instanceof Stage) {
	                return (Stage) window;
	            }
	        }
	        return null;
	    }

	    
	    @FXML
	    void btnRemovePressed(ActionEvent event) {
	        Media media = tblMedia.getSelectionModel().getSelectedItem();
	        cart.removeMedia(media);
	        costLabel.setText(cart.totalCost() + " $");
	    }
	    
	    //	Chức năng thêm item may mắn khi ấn đặt hàng với số lượng >= 2
	    @FXML
	    void placeOrderClicked(ActionEvent event) {
	        Media luckyItem = cart.getALuckyItem();
	        if (luckyItem != null) {
	            costLabel.setText(cart.totalCost() + " $");
	            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You got " + luckyItem.toString() + " as a lucky item.\n" + "The total cost is " + cart.totalCost() + " $");
	            alert.showAndWait();
	        }
	        cart = new Cart();
	        costLabel.setText(cart.totalCost() + " $");
	        tblMedia.setItems(null);

	    }
	    
	    void showFilteredMedia(String filter) {
	        String filterType;
	        if (radioBtnFilterTitle.isSelected()) {
	            filterType = "title";
	        } else {
	            filterType = "id";
	        }

	        FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), null);
	        list.setPredicate(media -> media.filterProperty(filter, filterType));

	        if (cart.getItemsOrdered()!= null) {
	            tblMedia.setItems(list);
	        }
	    }
}
