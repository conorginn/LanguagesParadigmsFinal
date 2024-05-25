// Game SubClass

public class Game extends Item {
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

    // Overridden print method
    @Override
    public void print() {
        super.print();
        System.out.println("developer: " + developer + "platform: " + platform);
    }
}
