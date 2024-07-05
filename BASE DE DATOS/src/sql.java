import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class sql {
    public JButton button1;
    public JPanel panel1;
    public JTextField consultaTXT;
    public JLabel resultadoTXT;

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
                String URL = "jdbc:mysql://localhost:3306/ESTUDIATES2024";
                String user = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(URL, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "SELECT * FROM estudiantes WHERE cedula = '"+ consultaTXT.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String cedulaA = resultSet.getString("cedula");
                        int b1 = resultSet.getInt("b1");
                        int b2 = resultSet.getInt("b2");

                        float promedio= (b1+b2)/2;

                    String resultado = "Nombre: " + nombre + "\n" + "Cedula: " + cedulaA + "\n" + "nota B1: " + b1 + "\n" + "nota B2: " + b2 + "\n" + "promedio: " + promedio + "\n";
                    resultadoTXT.setText(resultado);
                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        consultaTXT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoTXT.setText("");

            }
        });
    }
}