// OnlineGame SubClass of Game

public class OnlineGame extends Game {
    private String downloadLink;

    // Default constructor
    public OnlineGame() {
        super();
        this.downloadLink = "";
    }

    // Parameterized constructor
    public OnlineGame(String title, String developer, String platform, String downloadLink) {
        super(title, developer, platform);
        this.downloadLink = downloadLink;
    }

    // Copy constructor
    public OnlineGame(OnlineGame other) {
        super(other);
        this.downloadLink = other.downloadLink;
    }

    // Getters and setters
    public String getDownloadLink() { return downloadLink; }
    public void setDownloadLink(String downloadLink) { this.downloadLink = downloadLink; }

    // Override Methods
    @Override
    public void print() {
        super.print();
        System.out.println("Download Link: " + downloadLink);
    }

    @Override
    public OnlineGame clone() {
        return new OnlineGame(this);
    }

    // Rentable methods (inherited from Game)
    @Override
    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Online game rented: " + title);
        } else {
            System.out.println("Online game is not available: " + title);
        }
    }

    @Override
    public void returnItem() {
        isAvailable = true;
        System.out.println("Online game returned: " + title);
    }
}
