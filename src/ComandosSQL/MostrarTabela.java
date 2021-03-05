package ComandosSQL;

import ConexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarTabela {

    public void Tabela() {

        try {

            Connection conn;
            Statement st;
            ResultSet rs;

            conn = Conexao.abrirBanco();
            st = conn.createStatement();
            rs = st.executeQuery("select * from funcionarios");

            while (rs.next()) {

                System.out.println(rs.getInt("Codigo") + " - "
                        + rs.getString("Nome") + " - "
                        + rs.getDate("Nascimento") + " - "
                        + rs.getString("Sexo") + " - "
                        + rs.getString("Cargo") + " - "
                        + rs.getFloat("Salario") + " - "
                        + rs.getInt("CPF")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            Conexao.fecharBanco();
        }

    }

}