// Classe Singleton para gerenciar uma "conexão de banco de dados"
class DatabaseConnection {

    // Armazena a única instância da classe
    private static DatabaseConnection instance;

    // Construtor privado para evitar criação de novas instâncias
    private DatabaseConnection() {
        // Simulando a inicialização de uma conexão de banco de dados
        System.out.println("Iniciando uma conexão de banco de dados...");
    }

    // Método público estático e sincronizado para obter a única instância
    public static synchronized DatabaseConnection getInstance() {
        // Verifica se a instância já foi criada
        if (instance == null) {
            // Cria uma nova instância se ainda não foi criada
            instance = new DatabaseConnection();
        }
        // Retorna a instância única
        return instance;
    }

    // Um método para simular uma consulta ao banco de dados
    public void executeQuery(String query) {
        System.out.println("Executando a consulta: " + query);
    }
}

// Classe principal para testar o Singleton
public class Main {

    public static void main(String[] args) {

        // Obtendo a instância única do DatabaseConnection
        DatabaseConnection connection1 = DatabaseConnection.getInstance();

        // Usando a instância para executar uma consulta fictícia
        connection1.executeQuery("SELECT * FROM users");

        // Obtendo outra "conexão"
        // Isso na verdade retornará a mesma instância que connection1
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        // Verificando se as duas instâncias são as mesmas
        if (connection1 == connection2) {
            System.out.println("As duas conexões são a mesma instância.");
        }

        // Usando a segunda instância para executar outra consulta
        // Isso demonstra que connection1 e connection2 são de fato a mesma instância
        connection2.executeQuery("SELECT * FROM orders");
    }
}
