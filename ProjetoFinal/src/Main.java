// Programming Languages and Paradigms - Final Project
// Matthew Riddell 2023107667
// Conor McGinn 2023107678

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static RentalStore store = new RentalStore("Matt's Rental Store");

    public static void main(String[] args) {
        // Create Store Items
        Game game = new Game("The Witcher 3", "CD Projekt Red", "PC");
        OnlineGame onlineGame = new OnlineGame("Fortnite", "Epic Games", "PC", "https://download.fortnite.com");
        Movie movie = new Movie("Inception", "Christopher Nolan", "Sci-Fi");

        // Add items to the store
        store.addItem(game);
        store.addItem(onlineGame);
        store.addItem(movie);

        // Create Customers
        Customer customer = new Customer("Jonathan Joe");

        // Register the customer
        store.registerCustomer(customer);

        // Create and display the GUI
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Rental Store Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Increased size for better appearance
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        // Inventory Menu
        JMenu inventoryMenu = new JMenu("Inventory");
        JMenuItem viewInventory = new JMenuItem("View Inventory");
        viewInventory.addActionListener(e -> viewInventoryDialog());
        inventoryMenu.add(viewInventory);

        JMenuItem addItem = new JMenuItem("Add Item");
        addItem.addActionListener(e -> addItemDialog());
        inventoryMenu.add(addItem);

        menuBar.add(inventoryMenu);

        // Customer Menu
        JMenu customerMenu = new JMenu("Customers");
        JMenuItem viewCustomers = new JMenuItem("View Customers");
        viewCustomers.addActionListener(e -> viewCustomersDialog());
        customerMenu.add(viewCustomers);

        JMenuItem registerCustomer = new JMenuItem("Register Customer");
        registerCustomer.addActionListener(e -> registerCustomerDialog());
        customerMenu.add(registerCustomer);

        menuBar.add(customerMenu);

        // Rental Menu
        JMenu rentalMenu = new JMenu("Rentals");
        JMenuItem rentItem = new JMenuItem("Rent Item");
        rentItem.addActionListener(e -> rentItemDialog());
        rentalMenu.add(rentItem);

        JMenuItem returnItem = new JMenuItem("Return Item");
        returnItem.addActionListener(e -> returnItemDialog());
        rentalMenu.add(returnItem);

        menuBar.add(rentalMenu);

        frame.setJMenuBar(menuBar);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // Grid layout with spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding around the panel

        JButton viewInventoryButton = new JButton("View Inventory");
        viewInventoryButton.setFont(new Font("Arial", Font.PLAIN, 20));
        viewInventoryButton.addActionListener(e -> viewInventoryDialog());
        buttonPanel.add(viewInventoryButton);

        JButton addItemButton = new JButton("Add Item");
        addItemButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addItemButton.addActionListener(e -> addItemDialog());
        buttonPanel.add(addItemButton);

        JButton viewCustomersButton = new JButton("View Customers");
        viewCustomersButton.setFont(new Font("Arial", Font.PLAIN, 20));
        viewCustomersButton.addActionListener(e -> viewCustomersDialog());
        buttonPanel.add(viewCustomersButton);

        JButton registerCustomerButton = new JButton("Register Customer");
        registerCustomerButton.setFont(new Font("Arial", Font.PLAIN, 20));
        registerCustomerButton.addActionListener(e -> registerCustomerDialog());
        buttonPanel.add(registerCustomerButton);

        JButton rentItemButton = new JButton("Rent Item");
        rentItemButton.setFont(new Font("Arial", Font.PLAIN, 20));
        rentItemButton.addActionListener(e -> rentItemDialog());
        buttonPanel.add(rentItemButton);

        JButton returnItemButton = new JButton("Return Item");
        returnItemButton.setFont(new Font("Arial", Font.PLAIN, 20));
        returnItemButton.addActionListener(e -> returnItemDialog());
        buttonPanel.add(returnItemButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void viewInventoryDialog() {
        JTextArea inventoryArea = new JTextArea(15, 30);
        inventoryArea.setEditable(false);
        StringBuilder inventoryText = new StringBuilder();
        for (Item item : store.getItems()) {
            inventoryText.append(item).append("\n");
        }
        inventoryArea.setText(inventoryText.toString());
        JOptionPane.showMessageDialog(null, new JScrollPane(inventoryArea), "Inventory", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void viewCustomersDialog() {
        JTextArea customersArea = new JTextArea(15, 30);
        customersArea.setEditable(false);
        StringBuilder customersText = new StringBuilder();
        for (Customer customer : store.getCustomers()) {
            customersText.append(customer).append("\n");
        }
        customersArea.setText(customersText.toString());
        JOptionPane.showMessageDialog(null, new JScrollPane(customersArea), "Customers", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addItemDialog() {
        // Simple dialog for adding items
        String[] itemTypes = {"Game", "OnlineGame", "Movie"};
        JComboBox<String> itemTypeCombo = new JComboBox<>(itemTypes);
        JTextField titleField = new JTextField(10);
        JTextField developerField = new JTextField(10);
        JTextField platformField = new JTextField(10);
        JTextField directorField = new JTextField(10);
        JTextField genreField = new JTextField(10);
        JTextField downloadLinkField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Spacing between elements
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding
        panel.add(new JLabel("Item Type:"));
        panel.add(itemTypeCombo);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Developer:"));
        panel.add(developerField);
        panel.add(new JLabel("Platform:"));
        panel.add(platformField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);
        panel.add(new JLabel("Download Link:"));
        panel.add(downloadLinkField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String itemType = (String) itemTypeCombo.getSelectedItem();
            String title = titleField.getText();
            if ("Game".equals(itemType)) {
                String developer = developerField.getText();
                String platform = platformField.getText();
                store.addItem(new Game(title, developer, platform));
            } else if ("OnlineGame".equals(itemType)) {
                String developer = developerField.getText();
                String platform = platformField.getText();
                String downloadLink = downloadLinkField.getText();
                store.addItem(new OnlineGame(title, developer, platform, downloadLink));
            } else if ("Movie".equals(itemType)) {
                String director = directorField.getText();
                String genre = genreField.getText();
                store.addItem(new Movie(title, director, genre));
            }
        }
    }

    private static void registerCustomerDialog() {
        JTextField nameField = new JTextField(10);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding
        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Register Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            store.registerCustomer(new Customer(name));
        }
    }

    private static void rentItemDialog() {
        JTextField customerIdField = new JTextField(10);
        JTextField itemIdField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Added spacing between elements
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding
        panel.add(new JLabel("Customer ID:"));
        panel.add(customerIdField);
        panel.add(new JLabel("Item ID:"));
        panel.add(itemIdField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Rent Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int customerId = Integer.parseInt(customerIdField.getText());
            int itemId = Integer.parseInt(itemIdField.getText());
            Customer customer = store.getCustomers().stream().filter(c -> c.getCustomerId() == customerId).findFirst().orElse(null);
            Item item = store.getItems().stream().filter(i -> i.getId() == itemId).findFirst().orElse(null);
            if (customer != null && item != null) {
                store.rentItemToCustomer(item, customer);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Customer ID or Item ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void returnItemDialog() {
        JTextField customerIdField = new JTextField(10);
        JTextField itemIdField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Added spacing between elements
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding
        panel.add(new JLabel("Customer ID:"));
        panel.add(customerIdField);
        panel.add(new JLabel("Item ID:"));
        panel.add(itemIdField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Return Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int customerId = Integer.parseInt(customerIdField.getText());
            int itemId = Integer.parseInt(itemIdField.getText());
            Customer customer = store.getCustomers().stream().filter(c -> c.getCustomerId() == customerId).findFirst().orElse(null);
            Item item = store.getItems().stream().filter(i -> i.getId() == itemId).findFirst().orElse(null);
            if (customer != null && item != null) {
                store.returnItemFromCustomer(item, customer);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Customer ID or Item ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
