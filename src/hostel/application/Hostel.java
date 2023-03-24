package hostel.application;

import java.text.NumberFormat;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;


/**
 * GUI for Hostel Application
 * @author Abdul-Razak Hussein
 * @version: 29th July, 2021
 */
public class Hostel extends Application
{
    //Attrbutes
    private TenantList list;
    private int noOfRooms;
    // Width and Height of GUI stored in contants
    private final int WIDTH = 800;
    private final int HEIGHT = 500; 
    
    private Label headingLabel = new Label("Hostel Application"); 
    private Label roomLabel1 = new Label ("Room");
    private TextField roomField1 = new TextField();
    private Label nameLabel = new Label("Name");
    private TextField nameField = new TextField();
    private Button addButton = new Button("Add Tenant");
    private Button displayButton = new Button("Display Tenants");
    private Button removeButton = new Button("Remove Tenant");
    private Button saveAndQuitButton = new Button("Save And Quit");
    private TextArea displayArea1 = new TextArea();
    private Label roomLabel2 = new Label("Room");
    private TextField roomField2 = new TextField();
    private Label monthLabel = new Label("Month");
    private TextField monthField = new TextField();
    private Label amountLabel = new Label("Amount");
    private TextField amountField = new TextField();
    private Button paymentButton = new Button("Make Payments");
    private Button listPaymentsButton = new Button("List Payments");
    private TextArea displayArea2 = new TextArea();
    
    //Methods 
    @Override
    public void start (Stage stage)
    {
       noOfRooms = getNumberOfRooms(); // call private method
       // Initialise tenant list
       list = new TenantList(noOfRooms);
       TenantFileHandler.readRecords(list);
       // Codes to layout components, process event handling routines and initialise the list goes down here
       // create four HBoxes
       HBox roomDetails = new HBox(10);
       HBox tenantButtons = new HBox(10);
       HBox paymentDetails = new HBox(10);
       HBox paymentButtons = new HBox(10);
       //Add components to HBoxes
       roomDetails.getChildren().addAll(roomLabel1, roomField1, nameLabel, nameField);
       tenantButtons.getChildren().addAll(addButton, displayButton, removeButton, saveAndQuitButton);
       paymentDetails.getChildren().addAll( roomLabel2, roomField2, monthLabel, monthField, amountLabel, amountField);
       paymentButtons.getChildren().addAll(paymentButton, listPaymentsButton);
       
       //Create VBox
       VBox root = new VBox(10);
       root.getChildren().addAll(headingLabel,roomDetails, tenantButtons, displayArea1,  paymentDetails, paymentButtons , displayArea2);
       //Add the VBox to the Scene
       Scene scene = new Scene(root, Color.LIGHTBLUE);
       //Set Font of Heading
       Font font = new Font("Calibri", 40);
       headingLabel.setFont(font);
       // Set Alignment of HBoxes
       roomDetails.setAlignment(Pos.CENTER);
       tenantButtons.setAlignment(Pos.CENTER);
       paymentDetails.setAlignment(Pos.CENTER);
       paymentButtons.setAlignment(Pos.CENTER);
       
       // Set alignment of the VBox
       root.setAlignment(Pos.CENTER);
       // set maximum and minimum width of components
       roomField1.setMaxWidth(50);
       roomField2.setMaxWidth(50);
       
       roomDetails.setMinWidth(WIDTH);
       roomDetails.setMaxWidth(WIDTH);
       
       tenantButtons.setMinWidth(WIDTH);
       tenantButtons.setMaxWidth(WIDTH);
       
       paymentDetails.setMinWidth(WIDTH);
       paymentDetails.setMaxWidth(WIDTH);
       
       paymentButtons.setMinWidth(WIDTH);
       paymentButtons.setMaxWidth(WIDTH);
       
       paymentButtons.setMinWidth(WIDTH);
       paymentButtons.setMaxWidth(WIDTH);
       
       root.setMinSize(WIDTH, HEIGHT);
       root.setMaxSize(WIDTH, HEIGHT);
       
       displayArea1.setMaxSize( WIDTH -80 , HEIGHT/5);
       displayArea2.setMaxSize( WIDTH - 80, HEIGHT/5);
       
       stage.setWidth(WIDTH);
       stage.setHeight(HEIGHT);
       
       //Customize visua; components
       
       //Customise the VBox border and background
       BorderStroke style  = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2));
       root.setBorder(new Border(style));
       root.setBackground(Background.EMPTY);
       
       //customize the buttons
       addButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
       displayButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
       removeButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
       saveAndQuitButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
       paymentButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
       listPaymentsButton.setBackground(new Background( new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

       // Call private methods for button event handlers   
       addButton.setOnAction(e->addHandler());
       displayButton.setOnAction(e->displayHandler());
       removeButton.setOnAction(e->removeHandler());
       paymentButton.setOnAction(e->paymentHandler());
       listPaymentsButton.setOnAction(e->listHandler());
       saveAndQuitButton.setOnAction(e->saveAndQuitHandler());
      
       // Configure the stage and the stage visible
       stage.setScene(scene);
       stage.setTitle("Hostel Application");
       stage.setResizable(true);
       stage.show();
       
    }
    /**
     * Method to request number of hostels from user
     * @param num stores the number of room
     * @return number of rooms
     */
    private int getNumberOfRooms()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("How many rooms?");
        dialog.setTitle("Room Information Request");
        String response = dialog.showAndWait().get(); 
return Integer.parseInt(response);
    }
    
    //Event handler methods
    
    public void addHandler()
    {
        String roomEntered = roomField1.getText();
        String nameEntered = nameField.getText();
        //check for errors
        if (roomEntered.length() == 0 || nameEntered.length() == 0)
        {
            displayArea1.setText("Room number and name must be entered!!!");
        }
        else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
        {
            displayArea1.setText("There are only "+ noOfRooms+ " rooms");
        }
        else if(list.search(Integer.parseInt(roomEntered)) != null)
        {
            displayArea1.setText("Room number "+Integer.parseInt(roomEntered)+" is occupied");
        }
        else  // ok to add tenant
        {
            Tenant t = new Tenant(nameEntered, Integer.parseInt(roomEntered));
            list.addTenant(t);
            roomField1.setText("");
            nameField.setText("");
            displayArea1.setText("New tenant in room "+roomEntered+" successfully added");
        }
       
        
       
    }
    public void displayHandler()
    {
        int i;
        if(list.isEmpty())  // No rooms to display
        {
            displayArea1.setText("All rooms are empty");
        }
        else
        {
            displayArea1.setText("Room "+"\t"+ "Name"+"\n");
            for(i = 1; i<= list.getTotal(); i++)
            {
                displayArea1.appendText(list.getTenant(i).getRoom()+"\t\t"+list.getTenant(i).getName()+"\n");
            }
        }
    }
    public void removeHandler()
    {
        String roomEntered = roomField1.getText();
        //check for errors
        if(roomEntered.length() == 0)
        {
            displayArea1.setText("Room number must be entered");
        }
        else if(Integer.parseInt(roomEntered)< 1 || Integer.parseInt(roomEntered)> noOfRooms)
        {
            displayArea1.setText("Invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered)) == null)
        {
            displayArea1.setText("Room "+"roomEntered"+ "id empty");
        }
        else // ok to remove tenant
        {
            list.removeTenant(Integer.parseInt(roomEntered));
            displayArea1.setText("Tenant removed from room "+Integer.parseInt(roomEntered));
        }
    }
    public void paymentHandler()
    {
        String roomEntered = roomField2.getText();
        String monthEntered = monthField.getText();
        String amountEntered = amountField.getText();
        //check for errors
        if(roomEntered.length() == 0 || monthEntered.length() == 0 || amountEntered.length() == 0)
        {
            displayArea2.setText("Room numner, month and amount must all be entered");
        }
        else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
        {
            displayArea2.setText("Invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered)) == null)
        {
            displayArea2.setText("Room number "+roomEntered+ " is empty");
        }
        else
        {
            Payment p = new Payment(monthEntered, Double.parseDouble(amountEntered));
            list.search(Integer.parseInt(roomEntered)).makePayment(p);
            displayArea2.setText("Payment recorded");
        }
    }
    public void listHandler()
    {
        int i;
        String roomEntered = roomField2.getText();
        //check for errors
        if(roomEntered.length() == 0)
        {
            displayArea2.setText("Room number must be entered");
        }
        else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
        {
            displayArea2.setText("Invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered)) == null)
        {
            displayArea2.setText("Room number "+roomEntered+" is empty");
        }
        else // ok to list tenants
        {
            Tenant t = list.search(Integer.parseInt(roomEntered));
            PaymentList p = t.getPayment();
            if(t.getPayment().getTotal() == 0)
            {
                displayArea2.setText("No payments made for this tenant");
            }
            else
            {
                /* The NumberFormat class is similar to DecimalFormat. CuurencyInstance reads the system to find out the country and the currency
                then uses the currency symbol
                */
               
                /*NumberFormat nf = NumberFormat.getCurrencyInstance();
                String s;
                displayArea2.setText("Month"+"\t\t"+"Amount"+"\n");
                for(i = 1; i <= p.getTotal(); i++)
                {
                    s = nf.format(p.getPayment(i).getAmount());
                    displayArea2.appendText("" +p.getPayment(i).getMonth()+"\t\t\t"+ s+ "\n");
                    
                }
                displayArea2.appendText("\n"+"Total paid so far: "+nf.format(p.calculateTotalPaid()));
                monthField.setText("");
                amountField.setText("");
                        */
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                String s;
                displayArea2.setText("Month" + "\t\t" + "Amount" + "\n");
                for(i = 1; i <= p.getTotal(); i++ )
                      { 
                           s = nf.format(p.getPayment(i).getAmount());
                           displayArea2.appendText("" + p.getPayment(i).getMonth() + "\t\t\t" + s + "\n");
                       }
                 displayArea2.appendText("\n" + "Total paid so far : " + 
                 nf.format(p.calculateTotalPaid()));
                 monthField.setText("");
                 amountField.setText("");
            }
        }
    }
    public void saveAndQuitHandler()
    {
        TenantFileHandler.saveRecords(noOfRooms, list);
        Platform.exit();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
