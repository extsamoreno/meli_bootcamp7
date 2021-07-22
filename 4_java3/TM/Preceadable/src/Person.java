public class Person implements Precedeable<Person> {
    private String name;
    private int id;

    @Override
    public int precedes (Person p) {
        return this.name.compareTo(p.getName());
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name;
    }

    // constructor
    public Person (String name, int id) {
        this.name = name;
        this.id = id;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
