// Programming Languages and Paradigms - Final Project
// Matthew Riddell 2023107667
// Conor McGinn 2023107678

import java.util.ArrayList;

// Rental Store Class
public class RentalStore {
    private String name;
    private ArrayList<Item> items;
    private ArrayList<Customer> customers;

    // Default constructor
    public RentalStore() {
        this.name = "";
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Parameterized constructor
    public RentalStore(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Copy constructor
    public RentalStore(RentalStore other) {
        this.name = other.name;
        this.items = new ArrayList<>(other.items);
        this.customers = new ArrayList<>(other.customers);
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Item> getItems() { return items; }
    public void setItems(ArrayList<Item> items) { this.items = items; }

    public ArrayList<Customer> getCustomers() { return customers; }
    public void setCustomers(ArrayList<Customer> customers) { this.customers = customers; }

    // Add item to the store
    public void addItem(Item item) {
        items.add(item);
    }

    // Remove item from the store
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Register a new customer
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    // Print inventory
    public void printInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            item.print();
        }
    }

    // Print customers
    public void printCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            customer.print();
        }
    }

    // Rent an item to a customer
    public void rentItemToCustomer(Item item, Customer customer) {
        if (item instanceof Rentable && customer != null) {
            Rentable rentable = (Rentable) item;
            rentable.rent();
            customer.rentItem(item);
        } else {
            System.out.println("Item cannot be rented or customer is invalid.");
        }
    }

    // Return an item from a customer
    public void returnItemFromCustomer(Item item, Customer customer) {
        if (item instanceof Rentable && customer != null) {
            Rentable rentable = (Rentable) item;
            rentable.returnItem();
            customer.returnItem(item);
        } else {
            System.out.println("Item cannot be returned or customer is invalid.");
        }
    }
}
