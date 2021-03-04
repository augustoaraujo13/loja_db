package ComandosSQL;

import ConexaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarFuncionario {

    Scanner teclado = new Scanner(System.in);
    private Connection conn = null;
    private PreparedStatement st = null;
    private int codigo;

    public DeletarFuncionario() {
    }

   public void apagar(){
   
       System.out.println("Vamos apagar um funcionario");
       System.out.println("Digite o codigo para apagar o funcionario");
       setCodigo(teclado.nextInt());
       
       System.out.printf("O funcionario com o codigo %d foi apagado!", codigo);
   
   }
    
    public void Deletar() {

        try {

            conn = Conexao.abrirBanco();
            st = conn.prepareStatement("delete from funcionarios"
                    + "where" + "Codigo = ?");

            st.setInt(1, codigo);
            
            st.executeUpdate();

        } catch (SQLException e) {
           throw new ClassCastException(e.getMessage());

        } finally {
            Conexao.fecharStatement(st);
            Conexao.fecharBanco();
        }

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
