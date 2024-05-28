package br.unipar;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/Exemplo1";
    private static final String user = "postgres";
    private static final String password = "admin123";


    public static void main(String[] args) {

    }
    //localhost -> Onde esta o banco
    //5432 -> porta padrão do banco
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public static void criarTabelaUsuario(){
        try {
            Connection conn = connection();

            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE IF NOT EXISTS usuarios ("
                       + " codigo SERIAL PRIMARY KEY,"
                       + " username VARCHAR(50) UNIQUE NOT NULL,"
                       + " password VARCHAR(300) NOT NULL,"
                       + " nome VARCHAR(50) NOT NULL,"
                       + " nascimento DATE )";

            statement.executeUpdate(sql);

            System.out.println("TABELA USUARIOS CRIADA");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public static void criarTabelaVenda(){
        try{
            Connection conn = connection();

            Statement statement = conn.createStatement();

            String sql = " CREATE TABLE IF NOT EXISTS venda ("
                       + " id_venda SERIAL PRIMARY KEY,"
                       + " cliente VARCHAR(50) NOT NULL,"
                       + " produto VARCHAR(50) NOT NULL,";

            statement.executeUpdate(sql);

            System.out.println("TABELA VENDA CRIADA");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public static void criarTabelaProduto(){
        try{
            Connection conn = connection();

            Statement statement = conn.createStatement();

            String sql = " CREATE TABLE IF NOT EXISTS produto ("
                    + " id_produto SERIAL PRIMARY KEY,"
                    + " descricao VARCHAR(50) NOT NULL,"
                    + " valor DOUBLE NOT NULL,";

            statement.executeUpdate(sql);

            System.out.println("TABELA PRODUTO CRIADA");


        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public static void criarTabelaCliente(){
        try{
            Connection conn = connection();
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE IF NOT EXISTS cliente ("
                    + " id_cliente SERIAL PRIMARY KEY,"
                    + " nome VARCHAR(50) NOT NULL,"
                    + " cpf VARCHAR(14) NOT NULL";

            System.out.println("TABELA CLIENTE CRIADA");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
