import javax.swing.*;
import java.awt.*;

public class IST411View extends JFrame {
    private JTextField txtFieldItemId, txtFieldOrderId;
    private JButton btnGetItem, btnAddItem, btnGetOrder, btnCreateOrder;
    private JTextArea txtAreaDisplay;

    public IST411View() {
        //initialize panel and content pane
        setTitle("IST411 Inventory Management System");
        getContentPane().setLayout(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1)); 

        JPanel itemPanel = new JPanel(new FlowLayout()); 
        JPanel orderPanel = new JPanel(new FlowLayout());
        
        //initialize main components
        txtFieldItemId = new JTextField(10);
        txtFieldOrderId = new JTextField(10);
        btnGetItem = new JButton("Get Item");
        btnAddItem = new JButton("Add New Item");
        btnGetOrder = new JButton("Get Order");
        btnCreateOrder = new JButton("Create New Order");
        
        //initialize action listeners
        btnGetItem.addActionListener(e -> getItem());
        btnAddItem.addActionListener(e -> openAddItemDialog());
        btnGetOrder.addActionListener(e -> getOrder());
        btnCreateOrder.addActionListener(e -> openCreateOrderDialog());

        //add item controls
        itemPanel.add(new JLabel("Item ID:"));
        itemPanel.add(txtFieldItemId);
        itemPanel.add(btnGetItem);
        itemPanel.add(btnAddItem);

        //add order controls
        orderPanel.add(new JLabel("Order ID:"));
        orderPanel.add(txtFieldOrderId);
        orderPanel.add(btnGetOrder);
        orderPanel.add(btnCreateOrder);

        //add subpanels to the main input panel
        inputPanel.add(itemPanel);
        inputPanel.add(orderPanel);

        //text area for outputs
        txtAreaDisplay = new JTextArea(5, 20);
        txtAreaDisplay.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(txtAreaDisplay), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
    }

    private void getItem() {
        try {
            int itemId = Integer.parseInt(txtFieldItemId.getText());
            Item item = Item.getItem(itemId);
            if (item != null) {
                txtAreaDisplay.setText(item.toString());
            } else {
                //item valid, but not found in database
                txtAreaDisplay.setText("No item found with ID: " + itemId);
            }
        } catch (NumberFormatException e) {
            //item input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric item ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openAddItemDialog() {
        AddItemDialog addItemDialog = new AddItemDialog(this);
        addItemDialog.setVisible(true);
    }

    private void getOrder() {
        try {
            int orderId = Integer.parseInt(txtFieldOrderId.getText());
            Order order = Order.getOrder(orderId);
            if (order != null) {
                txtAreaDisplay.setText(order.toString());
            } else {
                //order valid, but not found in database
                txtAreaDisplay.setText("No order found with ID: " + orderId);
            }
        } catch (NumberFormatException e) {
            //order input invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric order ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void openCreateOrderDialog() {
     CreateOrderDialog addOrderDialog = new CreateOrderDialog(this);
     addOrderDialog.setVisible(true);
 }
}
