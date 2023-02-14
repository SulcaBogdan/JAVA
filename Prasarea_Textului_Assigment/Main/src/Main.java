public class Main {

    public static void main(String[] args) {
        String text = "John.Davidson/Belgrade Michael.Barton/Krakow Ivan.Perkinson/Moscow";

        String[] personList = text.split("[. /]");

        Person[] personArray = new Person[personList.length/3];

        for (int i = 0; i < personList.length; i+=3) {
            Person person = new Person(personList[i], personList[i+1], personList[i+2]);
            personArray[i/3] = person;

        }

        for (Person person : personArray){
            System.out.println(person.getInfo());
        }


    }

}
