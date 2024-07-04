import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class sql {
    public JButton button1;
    public JPanel panel1;
    public JTextArea calcularTextArea;
    public JLabel nombreTxt;

    public sql() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello and welcome!");
/*
                String URL = "jdbc:mysql://localhost:3306/ESTUDIATES2024A";
                String user = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(URL, user, password)) {

                    System.out.println("Conectado a la base de datos!");
                    String query = "select * from estudiante";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {

                        Scanner sc = new Scanner(System.in);
                        System.out.println("Ingrese la cedula del estudainte: ");
                        String cedula = sc.nextLine();
                        String searchQuery = "SELECT * FROM estudiante WHERE cedula = ?";
                        PreparedStatement searchStatement = connection.prepareStatement(searchQuery);
                        searchStatement.setString(1, cedula);
                        ResultSet searchResultSet = searchStatement.executeQuery();
                        if (searchResultSet.next()) {
                            System.out.println(searchResultSet.getString("nombre"));
                            System.out.println(searchResultSet.getString("cedula"));
                            System.out.println(searchResultSet.getString("bimestreUno"));
                            System.out.println(searchResultSet.getString("bimestreDos"));

                            // transformamos los  valores
                            int bimestreUno = searchResultSet.getInt("bimestreUno");
                            int bimestreDos = searchResultSet.getInt("bimestreDos");
                            int sumaNotas = bimestreUno + bimestreDos;
                            if (sumaNotas >= 28) {
                                System.out.println("Resultado: Aprobado");
                            } else {
                                System.out.println("Resultado: Reprobado");
                            }
                        }
                    }
                } catch (SQLException sqlException) {
                    System.out.println(sqlException.getMessage());
                }
            }*/
                String url="jdbc:mysql://localhost:3306/estudiantes2024a";
                String user="root";
                String password="";

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula=1736492203";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("nombre"));
                        nombreTxt.setText(resultSet.getString("nombre"));
                    }
                }catch (SQLException e1){
                    System.out.println(e);}
            }
        });
    }
}