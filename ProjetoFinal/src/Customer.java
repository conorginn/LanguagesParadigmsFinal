// Programming Languages and Paradigms - Final Project
// Matthew Riddell 2023107667
// Conor McGinn 2023107678

import java.util.ArrayList;

// Customer Class
public class Customer {
    private int customerId;
    private String name;
    private ArrayList<Item> rentedItems;
    private static int customerCount = 0;

    // Default constructor
    public Customer() {
        this.customerId = ++customerCount;
        this.name = "";
        this.rentedItems = new ArrayList<>();
    }

    // Parameterized constructor
    public Customer(String name) {
        this.customerId = ++customerCount;
        this.name = name;
        this.rentedItems = new ArrayList<>();
    }

    // Copy constructor
    public Customer(Customer other) {
        this.customerId = other.customerId;
        this.name = other.name;
        this.rentedItems = new ArrayList<>(other.rentedItems);
    }

    // Getters and setters
    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public ArrayList<Item> getRentedItems() { return rentedItems; }

    public void setName(String name) { this.name = name; }

    // Rent an item
    public void rentItem(Item item) {
        if (item != null && item instanceof Rentable && item.isAvailable()) {
            rentedItems.add(item);
            ((Rentable) item).rent();
        } else {
            System.out.println("Item is not available for rent.");
        }
    }

    // Return an item
    public void returnItem(Item item) {
        if (rentedItems.contains(item)) {
            rentedItems.remove(item);
            ((Rentable) item).returnItem();
        } else {
            System.out.println("This item is not rented by the customer.");
        }
    }

    // Override Methods
    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name;
    }

    @Override
    public Customer clone() {
        return new Customer(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customerId == customer.customerId && name.equals(customer.name);
    }

    // Print method to display customer details
    public void print() {
        System.out.println(this.toString());
        System.out.println("Rented Items:");
        for (Item item : rentedItems) {
            item.print();
        }
    }
}
