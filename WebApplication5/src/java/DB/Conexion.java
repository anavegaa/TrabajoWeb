/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static void main(String[] args) {
        connect();
    }
    private static Connection connection;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShif=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    private static void connect() {
        if (connection == null) {

            try {
                Class.forName(driver);
                System.out.println("Driver cargado con exito");
                try {
                    connection = DriverManager.getConnection(url, user, password);
                    if (connection != null) {
                        System.out.println("Conexion wiii");
                    }
                } catch (Exception e) {
                    System.out.println("Error al intentar conectar con la base de datos, " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error al cargar el driver, " + e.getMessage());
            }
        }
    }
}