import java.sql.*;

public class Main {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Main() {

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "");
            System.out.println("Your connection is established... you can control your database");


        } catch (Exception e) {
        }

    }
    public void insert( String name , int age , int salary , String address) throws Exception{
        ps = conn.prepareStatement("INSERT INTO employees_info (name , age , salary , address) values (?,?,?,?)");
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, salary);
        ps.setString(4, address);
        ps.executeUpdate();

    }

    public void update(int id, String name , int age , int salary , String address) throws Exception {
        ps = conn.prepareStatement("UPDATE employees_info SET name = ? , age = ? , salary = ? , address = ? WHERE id = ?");
        ps.setInt(5, id);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, salary);
        ps.setString(4, address);
        ps.executeUpdate();
    }
    public void delete(int id) throws Exception {
        ps = conn.prepareStatement("DELETE FROM employees_info WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public void display() throws SQLException {
        ps = conn.prepareStatement("SELECT * FROM employees_info");
        rs = ps.executeQuery();
        while (rs.next()){
            System.out.printf("%-15s%-20s%5s\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
        }
    }
    public void searchById(int id) throws SQLException {
        ps = conn.prepareStatement("SELECT * FROM employees_info where id = ?");
        ps.setInt(1,id);
        rs = ps.executeQuery();
        if(rs.next())
            System.out.printf("%-15s%-20s%5s\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            else
                System.out.println("Id not exists....!");

        }

    
    public void close() throws Exception{
        conn.close();
        System.out.println("Connection closed");
}

     {
    }
}





