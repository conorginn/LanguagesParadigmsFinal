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

    // Abstract Clone method to be implemented by subclasses
    public abstract Item clone();


    // Override Methods
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Available: " + isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id == item.id && isAvailable == item.isAvailable && title.equals(item.title);
    }


    // Print method
    public void print() {
        System.out.println(this.toString());
    }
}
