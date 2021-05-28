public class Book {

    private String name;
    private String isbn;
    private String author;
    private int status;

    //status
    public static final int AVAILABLE = 1;
    public static final int LENDED = 0;


    public Book (String name, String isbn, String author){

        this.author = author;
        this.isbn = isbn;
        this.name = name;
        this.status = AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

  
    public void setAuthor(String author) {
        this.author = author;
    }

 
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public void lend (){

        this.status = LENDED;

    }

    public void giveBack(){

        this.status = AVAILABLE;

    }

    @Override 
    public String toString(){

        return this.name+", "+this.isbn+", "+this.author;

    }

}
