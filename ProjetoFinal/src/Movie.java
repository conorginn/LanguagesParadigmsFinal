// Movie SubClass

public class Movie extends Item implements Rentable {
    private String director;
    private String genre;

    // Default constructor
    public Movie() {
        super();
        this.director = "";
        this.genre = "";
    }

    // Parameterized constructor
    public Movie(String title, String director, String genre) {
        super(title);
        this.director = director;
        this.genre = genre;
    }

    // Copy constructor
    public Movie(Movie other) {
        super(other);
        this.director = other.director;
        this.genre = other.genre;
    }

    // Getters and setters
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    // Overridden print method
    @Override
    public void print() {
        super.print();
        System.out.println("Director: " + director + ", Genre: " + genre);
    }

    // Rentable methods
    @Override
    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Movie rented: " + title);
        } else {
            System.out.println("Movie is not available: " + title);
        }
    }

    @Override
    public void returnItem() {
        isAvailable = true;
        System.out.println("Movie returned: " + title);
    }

}
