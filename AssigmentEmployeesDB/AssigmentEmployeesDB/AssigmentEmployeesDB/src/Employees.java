import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Employees  {

    public static void main(String[] args) throws Exception {
        int choice = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main conn = new Main();
        do {
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY ALL");
            System.out.println("3. SEARCH");
            System.out.println("4. UPDATE");
            System.out.println("5. DELETE");
            System.out.println("0. EXIT");
            System.out.println("Enter you choice : ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter how many employees you want to add: ");
                    int n = Integer.parseInt(br.readLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter employee name : ");
                        String name = br.readLine();
                        System.out.println("Enter employee age : ");
                        int age = Integer.parseInt(br.readLine());
                        System.out.println("Enter employee salary : ");
                        int salary = Integer.parseInt(br.readLine());
                        System.out.println("Enter employee address : ");
                        String address = br.readLine();
                        conn.insert( name, age, salary, address);
                    }
                    break;
                case 0:
                    conn.close();
                    System.out.println("Thanks... bye...!");
                    break;
                case 2:
                    conn.display();
                    break;
                case 3:
                    System.out.println("Enter employee id to search : ");
                    int id = Integer.parseInt(br.readLine());
                    conn.searchById(id);
                    break;
                case 4:

                    System.out.println("Enter employee id to update : ");
                    id = Integer.parseInt(br.readLine());
                    System.out.println("Enter new employee Name : ");
                    String name = br.readLine();
                    System.out.println("Enter new employee age : ");
                    int age = Integer.parseInt(br.readLine());
                    System.out.println("Enter new employee salary : ");
                    int salary = Integer.parseInt(br.readLine());
                    System.out.println("Enter new employee address : ");
                    String address = br.readLine();
                    conn.update(id , name , age , salary , address );
                    break;
                case 5:
                    System.out.println("Enter employee id to delete : ");
                    id = Integer.parseInt(br.readLine());
                    conn.delete(id);


            }
            }
            while (choice != 0) ;


            conn.close();


        }
}




