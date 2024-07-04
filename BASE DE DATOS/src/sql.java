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
                String URL = "jdbc:mysql://localhost:3306/ESTUDIATES2024A";
                String user = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(URL, user, password)) {
                    System.out.println("Conectado a la base de datos");

                    // Consulta para obtener el nombre del estudiante por cédula (ejemplo: 1736492203)
                    String cedula = "1726195207"; // Puedes modificar la cédula según tus necesidades
                    String query = "SELECT * FROM estudiantes WHERE cedula = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, cedula);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        System.out.println(nombre); // Solo para verificar en la consola

                        // Establecer el nombre en el JLabel
                        nombreTxt.setText(nombre);
                    } else {
                        // Manejar caso en el que no se encuentre el estudiante
                        nombreTxt.setText("Estudiante no encontrado");
                    }

                } catch (SQLException sqlException) {
                    System.out.println("Error al conectar a la base de datos: " + sqlException.getMessage());
                }
            }
        });
    }
}