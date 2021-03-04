package lojabd;

import ComandosSQL.DeletarFuncionario;
import ComandosSQL.MostrarTabela;

public class Loja {

    public static void main(String[] args) {

        MostrarTabela mt = new MostrarTabela();
        DeletarFuncionario df = new DeletarFuncionario();

        df.apagar();
        
        //mt.Tabela();
    }
}
