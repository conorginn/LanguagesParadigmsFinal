// Item Super Class

public abstract class Item {
    protected int id;
    protected String title;
    protected boolean isAvailable;
    protected static int itemCount = 0;

    // Default constructor
    public Item() {
        this.id = ++itemCount;
        this.title = "";
        this.isAvailable = true;
    }

    // Parameterized constructor
    public Item(String title) {
        this.id = ++itemCount;
        this.title = title;
        this.isAvailable = true;
    }

    // Copy constructor
    public Item(Item other) {
        this.id = other.id;
        this.title = other.title;
        this.isAvailable = other.isAvailable;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Overridden methods TODO


    // Print method
    public void print() {
        System.out.println(this.toString());
    }
}
