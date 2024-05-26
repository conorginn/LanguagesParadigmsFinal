// Programming Languages and Paradigms - Final Project
// Matthew Riddell 2023107667
// Conor McGinn 2023107678

// Main Class
public class Main {
    public static void main(String[] args) {
        // Create RentalStore
        RentalStore store = new RentalStore("Matt's Rental Store");

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

        // Print inventory and customers
        store.printInventory();
        store.printCustomers();

        // Rent an item to the customer
        store.rentItemToCustomer(game, customer);

        // Print inventory and customers after renting
        store.printInventory();
        store.printCustomers();

        // Return an item from the customer
        store.returnItemFromCustomer(game, customer);

        // Print inventory and customers after returning
        store.printInventory();
        store.printCustomers();

        // Test cloning
        Game clonedGame = game.clone();
        System.out.println("Cloned Game:");
        clonedGame.print();
    }
}