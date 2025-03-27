package main.resources.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Configuration
public class DatabaseConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public CommandLineRunner onCreate() {
        return args -> {
            try (Connection conn = dataSource.getConnection();
                 Statement stmt = conn.createStatement()) {
                
                // Cria a tabela se não existir (simulando o onCreate())
                stmt.execute(
                    "CREATE TABLE IF NOT EXISTS formulario (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "sobrenome TEXT NOT NULL, " +
                    "idade INTERGER NOT NULL, " +
                    "endereco TEXT, "+
                    "email TEXT NOT NULL)"
                );
                
                System.out.println("✅ Tabela 'formulario' criada/pronta!");
            } catch (Exception e) {
                System.err.println("❌ Erro ao criar tabela: " + e.getMessage());
            }
        };
    }
}