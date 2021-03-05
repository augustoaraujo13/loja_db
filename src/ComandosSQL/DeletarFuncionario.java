package ComandosSQL;

import ConexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarFuncionario {

    private int codigo;

    public DeletarFuncionario() {
    }

    public void apagar() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Vamos apagar um funcionario");
        System.out.println("Digite o codigo para apagar o funcionario");
        setCodigo(teclado.nextInt());

        System.out.printf("O funcionario com o codigo %d foi apagado!", codigo);

    }

    private void Deletar() {

        try {

            Connection conn;
            PreparedStatement st;

            conn = Conexao.abrirBanco();
            st = conn.prepareStatement("delete from funcionarios"
                    + "where" + "Codigo = ?");

            st.setInt(1, codigo);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new ClassCastException(e.getMessage());

        } finally {
            Conexao.fecharBanco();
        }

    }

    private int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
