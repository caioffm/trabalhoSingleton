// Classe Singleton para gerenciar um "Logger"
class Logger {

    // Cria e inicializa a instância única no momento do carregamento da classe
    private static final Logger instance = new Logger();

    // Buffer para armazenar mensagens de log
    private StringBuilder logBuffer = new StringBuilder();

    // Construtor privado para evitar criação de novas instâncias
    private Logger() {
        System.out.println("Iniciando o Logger...");
    }

    // Método público para obter a única instância
    public static Logger getInstance() {
        return instance;
    }

    // Método para adicionar mensagens ao log
    public void log(String message) {
        logBuffer.append(message + "\n");
    }

    // Método para mostrar o log
    public void showLog() {
        System.out.println(logBuffer.toString());
    }
}

// Classe principal para testar o Singleton
public class Main {

    public static void main(String[] args) {

        // Obtendo a instância única do Logger
        Logger logger1 = Logger.getInstance();

        // Logando algumas mensagens
        logger1.log("Primeira mensagem de log");
        logger1.log("Segunda mensagem de log");

        // Obtendo outra "instância" do Logger
        // Isso na verdade retornará a mesma instância que logger1
        Logger logger2 = Logger.getInstance();

        // Verificando se as duas instâncias são as mesmas
        if (logger1 == logger2) {
            System.out.println("logger1 e logger2 são a mesma instância.");
        }

        // Usando a segunda instância para logar outra mensagem
        // Isso demonstra que logger1 e logger2 são de fato a mesma instância
        logger2.log("Terceira mensagem de log");

        // Exibindo o log
        logger1.showLog();  // Mostrará todas as três mensagens
    }
}
