package ComandosSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import ConexaoBanco.Conexao;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class InserirFuncionario {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private Connection conn = null;
    private PreparedStatement st = null;

    private int codigo;
    private String nome;
    private Date nascimento;
    private String sexo;
    private String cargo;
    private float salario;
    private int cpf;

    public InserirFuncionario(int codigo, String nome, Date nascimento, String sexo, String cargo, float salario, int cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.cpf = cpf;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement getSt() {
        return st;
    }

    public void setSt(PreparedStatement st) {
        this.st = st;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void InserirDados() throws ParseException, SQLException {

        try {
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
            st.close();
            Conexao.fecharBanco();

        }

    }

}
