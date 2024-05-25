// Programming Languages and Paradigms - Final Project
// Matthew Riddell 2023107667
// Conor McGinn 2023107678

// Game SubClass

public class Game extends Item implements Rentable {
    private String developer;
    private String platform;

    // Default constructor
    public Game() {
        super();
        this.developer = "";
        this.platform = "";
    }

    // Parameterized constructor
    public Game(String title, String developer, String platform) {
        super(title);
        this.developer = developer;
        this.platform = platform;
    }

    // Copy constructor
    public Game(Game other) {
        super(other);
        this.developer = other.developer;
        this.platform = other.platform;
    }

    // Getters and setters
    public String getDeveloper() {
        return developer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Override Methods
    @Override
    public void print() {
        super.print();
        System.out.println("Developer: " + developer + ", Platform: " + platform);
    }

    @Override
    public Game clone() {
        return new Game(this);
    }

    // Rentable methods
    @Override
    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Game rented: " + title);
        } else {
            System.out.println("Game is not available: " + title);
        }
    }

    @Override
    public void returnItem() {
        isAvailable = true;
        System.out.println("Game returned: " + title);
    }

}
