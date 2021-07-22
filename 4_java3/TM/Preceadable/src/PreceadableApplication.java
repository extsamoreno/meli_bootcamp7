public class PreceadableApplication {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("John", 1),
                new Person("Albert", 2),
                new Person("Alex", 3),
                new Person("Robert", 4)
        };

        SortUtils.order(persons);

        for (Person person: persons
             ) {
            System.out.println(person);
        }

        Cellphone[] cellphones = {
                new Cellphone("3456442188", "John"),
                new Cellphone("3456474849", "Albert"),
                new Cellphone("1145757854", "Alex"),
                new Cellphone("3511442177", "Robert"),

        };

        SortUtils.order(cellphones);

        for (Cellphone cellphone: cellphones
             ) {
            System.out.println(cellphone.toString());
        }
    }
}
