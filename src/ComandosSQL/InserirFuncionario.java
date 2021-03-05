package ComandosSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import ConexaoBanco.Conexao;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class InserirFuncionario {

    private String nome;
    private Date nascimento;
    private String sexo;
    private String cargo;
    private float salario;
    private int cpf;
    
    private String nasci;

    public InserirFuncionario() {
    }

    public void funcionario() {

        try {

            Scanner teclado = new Scanner(System.in);

            System.out.println("----------------------------");
            System.out.println("Agora vamos inserir um funcionario"
                    + " ao banco");
            System.out.println();
            System.out.println("Digite o nome do funcionario: ");
            nome = teclado.next().trim();
            System.out.println("Digite a data de nascimento: ");
            nasci = teclado.next();
            System.out.println("Digite o CPF: ");
            cpf = teclado.nextInt();
            System.out.println("Digite o cargo: ");
            cargo = teclado.next().trim();
            System.out.println("Digite o sexo: ");
            sexo = teclado.next().trim();
            System.out.println("Digite o salario: ");
            salario = teclado.nextFloat();
            System.out.println();
            System.out.println("----------------------------");

        } catch (Exception e) {
            System.out.println("Você digitou um campo incorretamente");
        }
    }

    private void converterData() {

        try {

            String converter_data = nasci;

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date dt = df.parse(converter_data);

            java.sql.Date da;
            da = new java.sql.Date(dt.getTime());

            setNascimento(da);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    private void InserirDados() throws ParseException, SQLException {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Connection conn;
            PreparedStatement st;

            conn = Conexao.abrirBanco();

            st = conn.prepareStatement("insert into funcionarios"
                    + "(Codigo, Nome, Nascimento, Sexo, Cargo, Salario, CPF)"
                    + "values"
                    + "(?,?,?,?,?,?,?)"
            );

            st.setString(1, "default");
            st.setString(2, nome);
            st.setDate(3, nascimento);
            st.setString(4, sexo);
            st.setString(5, cargo);
            st.setFloat(6, salario);
            st.setInt(7, cpf);

            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new ComandoException(e.getMessage());
        } finally {
            Conexao.fecharBanco();
        }

    }

    private String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    private void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private String getCargo() {
        return cargo;
    }

    private void setCargo(String cargo) {
        this.cargo = cargo;
    }

    private float getSalario() {
        return salario;
    }

    private void setSalario(float salario) {
        this.salario = salario;
    }

    private int getCpf() {
        return cpf;
    }

    private void setCpf(int cpf) {
        this.cpf = cpf;
    }

}