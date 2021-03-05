package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conn = null;

    public Conexao() {

    }

    public static Connection abrirBanco() {

        if (conn == null) {

            try {
                return conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/loja?useSSL=false",
                        "root",
                        "12345"
                );

            } catch (SQLException e) {
                throw new ConexaoException(e.getMessage());
            }
        }
        return conn;
    }

    public static Connection fecharBanco() {

        if (conn != null) {

            try {
                conn.close();
            } catch (SQLException e) {
                throw new ConexaoException(e.getMessage());
            }
        }
        return conn;
    }

}
