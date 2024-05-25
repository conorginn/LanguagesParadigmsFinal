// Game SubClass

public class Game extends Item {
    private String developer;

    // Default constructor
    public Game() {
        super();
        this.developer = "";
    }

    // Parameterized constructor
    public Game(String title, String developer) {
        super(title);
        this.developer = developer;
    }

    // Copy constructor
    public Game(Game other) {
        super(other);
        this.developer = other.developer;
    }

    // Getters and setters
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    // Overridden print method
    @Override
    public void print() {
        super.print();
        System.out.println("developer: " + developer);
    }
}
