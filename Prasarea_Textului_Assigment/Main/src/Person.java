public class Person {

    String firstName;
    String secondName;
    String birthPlace;

    public Person(String firstName, String secondName, String birthPlace) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthPlace = birthPlace;
    }
    String getInfo(){
        return firstName+" "+secondName+" "+birthPlace+"";
    }
}
