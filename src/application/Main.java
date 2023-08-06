package application;
// Worood Assi


import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		// create ArrayList :
		ArrayList<PizzaOrder> orders = new ArrayList<>();

		// BackGround :
		ImageView background = new ImageView(
				"C:\\Users\\Admin\\Desktop\\comp-231(Java)\\LAB-java\\Proj_II_2\\src\\application\\pizza.jpg");
		background.setOpacity(0.3);
		Image i = new Image(
				"C:\\Users\\Admin\\Desktop\\comp-231(Java)\\LAB-java\\Proj_II_2\\src\\application\\icon.jpg");
		stage.getIcons().add(i);

		// Title :
		stage.setTitle("Pizza Shop");

		//// create panes :
		StackPane stackPane = new StackPane();
		Pane pane = new Pane();
		GridPane Gpane = new GridPane();

		// create vBox : for customerName ->
		VBox vBox1 = new VBox(10);

		// customerName :
		Label customerName = new Label("Customer Name :");
		customerName.setFont(new Font(15));
		String s = "Customer name :";
		TextField C_name = new TextField();
		C_name.setPromptText(s); // placeholder in textfield
		vBox1.getChildren().addAll(customerName, C_name);
		vBox1.setPadding(new Insets(10));

		// orderType :
		Label orderType = new Label("Order Type :");
		orderType.setFont(new Font(15));
		String[] order_type = { "ToGo", "Delivary", "Seated" };
		ComboBox<String> ordertype = new ComboBox<>();
		ordertype.getItems().addAll(order_type);
		ordertype.getSelectionModel().select(0); // default value

		// create vBox : for ordertype ->
		VBox vBox2 = new VBox(10);
		vBox2.getChildren().addAll(orderType, ordertype);
		vBox2.setPadding(new Insets(10));

		// pizzaSize :
		Label pizzaSize = new Label("Pizza Size :");
		pizzaSize.setFont(new Font(15));

		// create Radio Buttons :
		RadioButton R1 = new RadioButton("SMALL");
		RadioButton R2 = new RadioButton("MEDIUM");
		RadioButton R3 = new RadioButton("LARGE");

		// create toggle group :
		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(R1, R2, R3);
		R1.setSelected(true); // default value

		// create hBox : for pizzaSize ->
		HBox hBox1pizzaSize = new HBox(20);
		hBox1pizzaSize.getChildren().addAll(R1, R2, R3);
		hBox1pizzaSize.setPadding(new Insets(10));

		VBox vbox_3 = new VBox();
		vbox_3.getChildren().addAll(pizzaSize, hBox1pizzaSize);
		vbox_3.setPadding(new Insets(10));

		// List of Toppings :
		Label topping = new Label("Topping :");
		topping.setFont(new Font(15));

		// create check Boxes :
		CheckBox b1 = new CheckBox("Onions");
		CheckBox b2 = new CheckBox("Olives");
		CheckBox b3 = new CheckBox("Green Peppers ");
		CheckBox b4 = new CheckBox("Cheese");
		CheckBox b5 = new CheckBox("Tomato Sause");

		// clear checkBoxes :
		Button cleanTopping = new Button("clear");

		cleanTopping.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				b1.setSelected(false);
				b2.setSelected(false);
				b3.setSelected(false);
				b4.setSelected(false);
				b5.setSelected(false);
			}
		});

		// choose all -> check Boxes
		Button chooseAll = new Button("chooseAll");

		chooseAll.setOnAction(e -> {
			b1.setSelected(true);
			b2.setSelected(true);
			b3.setSelected(true);
			b4.setSelected(true);
			b5.setSelected(true);
		});

		// create hBox : for checkBoxes ->
		HBox hBox2 = new HBox(20);
		hBox2.getChildren().addAll(b1, b2, b3, b4, b5);
		hBox2.setPadding(new Insets(10));

		HBox hBox_2 = new HBox(20);
		hBox_2.getChildren().addAll(chooseAll, cleanTopping);
		hBox_2.setPadding(new Insets(10));

		VBox vbox_4 = new VBox();
		vbox_4.getChildren().addAll(topping, hBox2, hBox_2);
		vbox_4.setPadding(new Insets(10));

		// toppingPrice :
		Label toppingPrice = new Label("Topping Price :");
		TextField topping_Price = new TextField("10"); // default value
		toppingPrice.setFont(new Font(15));

		// create vbox : for toppingPrice ->
		VBox vBox3 = new VBox(10);
		vBox3.getChildren().addAll(toppingPrice, topping_Price);
		vBox3.setPadding(new Insets(10));

		// orderPrice :
		Label orderPrice = new Label("Order Price");
		Label order_Price = new Label("0.0"); // default value
		orderPrice.setFont(new Font(15));
		order_Price.setFont(new Font(15));

		// create vbox : for orderPrice ->
		HBox vBox4 = new HBox(30);
		vBox4.getChildren().addAll(orderPrice, order_Price);
		vBox4.setPadding(new Insets(10));

		// create VBoxes : for labels && text fields
		VBox vBox5 = new VBox(10);
		VBox vBox6 = new VBox(10);
		VBox vBox7 = new VBox(10);
		vBox5.setVisible(false);
		vBox6.setVisible(false);

		// for delivery order :
		Label tripRate = new Label("Trip Rate");
		TextField trip_Rate = new TextField();
		Label zone = new Label("Zone");
		TextField _zone = new TextField();

		// for seated order :
		Label serviceCharge = new Label("Service Charge ");
		TextField service_Charge = new TextField();
		Label numberOfPeople = new Label("Number Of People ");
		TextField number_OfPeople = new TextField();

		vBox5.getChildren().addAll(tripRate, trip_Rate, zone, _zone);
		vBox6.getChildren().addAll(serviceCharge, service_Charge, numberOfPeople, number_OfPeople);
		vBox5.setPadding(new Insets(10));
		vBox6.setPadding(new Insets(10));

		// when you choose the order type :
		ordertype.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (ordertype.getSelectionModel().isSelected(1)) {
					vBox6.setVisible(false);
					vBox5.setVisible(true);

				}

				if (ordertype.getSelectionModel().isSelected(2)) {
					vBox5.setVisible(false);
					vBox6.setVisible(true);

				}

				if (ordertype.getSelectionModel().isSelected(0)) {
					vBox5.setVisible(false);
					vBox6.setVisible(false);

				}
			}
		});

		// create three buttons :
		Button ProcessOrder = new Button("Process Order");
		Button PrintOrders = new Button("PrintOrders");
		Button Reset = new Button("Reset");

		// HBox for the three buttons :
		HBox hBox3 = new HBox(20);
		hBox3.getChildren().addAll(ProcessOrder, PrintOrders, Reset);
		hBox3.setPadding(new Insets(10));

		ProcessOrder.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				String name = C_name.getText().trim();

				int size;
				if (R1.isSelected())
					size = 1;
				else if (R2.isSelected())
					size = 2;
				else
					size = 3;

				int number_of_topping = 0;
				if (b1.isSelected())
					number_of_topping++;
				if (b2.isSelected())
					number_of_topping++;
				if (b3.isSelected())
					number_of_topping++;
				if (b4.isSelected())
					number_of_topping++;
				if (b5.isSelected())
					number_of_topping++;

				int t_price = Integer.parseInt(topping_Price.getText());

				int o_price = 0;
				// Integer.parseInt(order_Price.getText());

				if (ordertype.getSelectionModel().isSelected(0)) {
					PizzaOrder object = new ToGo(name, size, number_of_topping, t_price);
					order_Price.setText(String.valueOf(object.calculateOrderPrice()));
					orders.add(object);
				}

				if (ordertype.getSelectionModel().isSelected(1)) {
					double trip_rate = Double.parseDouble(trip_Rate.getText());
					int zone = Integer.parseInt(_zone.getText());
					// create new object for delivery order :
					PizzaOrder object = new Delivery(name, size, number_of_topping, t_price, trip_rate, zone);
					order_Price.setText(String.valueOf(object.calculateOrderPrice()));
					orders.add(object);

				}

				if (ordertype.getSelectionModel().isSelected(2)) {
					double service_charge = Double.parseDouble(service_Charge.getText());
					int N_Of_people = Integer.parseInt(number_OfPeople.getText());
					// create new object for togo order :
					PizzaOrder object = new Seated(name, size, number_of_topping, t_price, service_charge, N_Of_people);
					order_Price.setText(String.valueOf(object.calculateOrderPrice()));
					orders.add(object);
				}

			}
		});

		// button to exit program :
		Button exit = new Button("Exit");
		Button back = new Button("Back");
		HBox hBox4 = new HBox(10);
//        hBox4.getChildren().add(exit);
		hBox4.getChildren().addAll(exit, back);
		hBox4.setLayoutX(40);
		hBox4.setLayoutY(500);

		// create new stage :
		Stage secondStage = new Stage();
		PrintOrders.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				stage.hide();
				secondStage.setTitle("Pizza Orders ");

				// background for the new stage :
				ImageView background2 = new ImageView(
						"C:\\\\Users\\\\Admin\\\\Desktop\\\\comp-231(Java)\\\\LAB-java\\\\Proj_II_2\\\\src\\\\application\\\\pizza.jpg");
				background2.setOpacity(0.3);
				Image i2 = new Image(
						"C:\\Users\\Admin\\Desktop\\comp-231(Java)\\LAB-java\\Proj_II_2\\src\\application\\icon.jpg");
				secondStage.getIcons().add(i2);

				Pane pane2 = new Pane();

				sortOrders(orders);
				VBox new_vBox = new VBox(10);
				new_vBox.setPadding(new Insets(20));
				new_vBox.setSpacing(10);

				for (int i = 0; i < orders.size(); i++) {
					Label new_label1 = new Label(orders.get(i).getCustomerName());
					Label new_label2 = new Label(String.valueOf(orders.get(i).calculateOrderPrice()));
					HBox new_hBox = new HBox(new_label1, new_label2);
					new_hBox.setSpacing(10);
					new_vBox.getChildren().add(new_hBox);
					new_label1.setFont(new Font(25));
					new_label2.setFont(new Font(25));
				}

				pane2.getChildren().add(background2);
				pane2.getChildren().add(new_vBox);
				pane2.getChildren().add(hBox4);

				Scene scene2 = new Scene(pane2, 600, 600);
				secondStage.setScene(scene2);
				secondStage.show();

			}

			public static void sortOrders(ArrayList<PizzaOrder> list) {
				Collections.sort(list);
			}

		});

		Reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				C_name.setText("");
				ordertype.getSelectionModel().select(0);
				R1.setSelected(true);
				b1.setSelected(false);
				b2.setSelected(false);
				b3.setSelected(false);
				b4.setSelected(false);
				b5.setSelected(false);
				topping_Price.setText("10");
				order_Price.setText("0.0");
				orders.removeAll(orders);
				trip_Rate.setText("");
				_zone.setText("");
				service_Charge.setText("");
				number_OfPeople.setText("");

			}
		});

		Gpane.add(vBox1, 0, 0);
		Gpane.add(vBox2, 0, 1);
		Gpane.add(vbox_3, 0, 2);
		Gpane.add(vbox_4, 0, 3);
		Gpane.add(vBox3, 0, 5);
		Gpane.add(vBox4, 0, 6);
		Gpane.add(vBox5, 0, 7);
		Gpane.add(vBox6, 0, 7);
		Gpane.add(hBox3, 0, 11);

		Gpane.setPadding(new Insets(20));
		stackPane.getChildren().add(background);
		stackPane.getChildren().add(Gpane);
//		stackPane.getChildren().add(Bpane); delete this
		Scene scene = new Scene(stackPane, 700, 700);
		stage.setScene(scene);
//*************************************************************************************
		Stage firstStage = new Stage();
		Pane firstPane = new Pane();
		firstStage.setTitle("Welcome : ");
		Button firstButton = new Button(" Order ");

		Label label = new Label("Welcome To My Pizza Shop");
		label.setLayoutX(150);
		label.setLayoutY(250);
		label.setFont(new Font(34));
		label.setTextFill(Color.CRIMSON);
		firstButton.setLayoutX(285);
		firstButton.setLayoutY(325);
		firstButton.setPrefSize(120, 40);
		firstButton.setFont(new Font(20));
		firstButton.setTextFill(javafx.scene.paint.Color.AZURE);
		firstButton.setStyle("-fx-background-color: crimson");
//        firstButton.setStyle("-fx-background-color: tomato ");
		ImageView background1 = new ImageView(
				"C:\\\\Users\\\\Admin\\\\Desktop\\\\comp-231(Java)\\\\LAB-java\\\\Proj_II_2\\\\src\\\\application\\\\pizza.jpg");
		background1.setOpacity(0.3);
		Image i1 = new Image(
				"C:\\Users\\Admin\\Desktop\\comp-231(Java)\\LAB-java\\Proj_II_2\\src\\application\\icon.jpg");
		firstStage.getIcons().add(i1);
		firstPane.getChildren().add(background1);
		firstPane.getChildren().add(label);
		firstPane.getChildren().add(firstButton);
		Scene firstScene = new Scene(firstPane, 700, 700);
		firstStage.setScene(firstScene);

		firstButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.show();
				firstStage.close();

			}
		});

		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.close();
				secondStage.close();
			}
		});

		back.setOnAction(e -> {
			stage.show();
			secondStage.close();

		});

		firstStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
