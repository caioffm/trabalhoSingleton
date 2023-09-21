import java.util.HashMap;
import java.util.Map;
// Classe Singleton para gerenciar configurações do sistema
class ConfigurationManager {

    // Construtor privado para evitar criação de novas instâncias
    private ConfigurationManager() {
        System.out.println("Carregando configurações do sistema...");
        // Simulação do carregamento de algumas configurações
        settings.put("theme", "dark");
        settings.put("fontSize", "14");
    }

    // Inner Static Helper Class
    private static class Holder {
        // Criação da única instância de ConfigurationManager
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    // Método público para obter a instância única de ConfigurationManager
    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }

    // Simulação de um mapa para armazenar configurações do sistema
    private Map<String, String> settings = new HashMap<>();

    // Método para recuperar um valor de configuração
    public String getSetting(String key) {
        return settings.get(key);
    }

    // Método para definir um valor de configuração
    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
}

// Classe principal para testar o Singleton
public class Main {

    public static void main(String[] args) {

        // Obtendo a instância única de ConfigurationManager
        ConfigurationManager config1 = ConfigurationManager.getInstance();

        // Exibindo e modificando algumas configurações
        System.out.println("Tema atual: " + config1.getSetting("theme"));
        config1.setSetting("theme", "light");
        System.out.println("Novo tema: " + config1.getSetting("theme"));

        // Obtendo "outra" instância de ConfigurationManager
        // Isso na verdade retornará a mesma instância que config1
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        // Verificando se as duas instâncias são a mesma
        if (config1 == config2) {
            System.out.println("config1 e config2 são a mesma instância.");
        }

        // Exibindo as configurações usando a segunda instância
        // Isso mostra que config1 e config2 são de fato a mesma instância
        System.out.println("Tema usando config2: " + config2.getSetting("theme"));
    }
}
