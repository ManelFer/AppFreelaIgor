package main.java.com.formulario.backend_pais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:src/main/resources/db/paises.db");
        return dataSource;
    }

    private void initializeDatabase(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            stmt.execute = "CREATE TABLE IF NOT EXISTS pais (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(255) NOT NULL," +
                    "sObrenome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL" +
                    "idade INTEGER NOT NULL," +
                    "endereco VARCHAR(255) NOT NULL," +
                    ");";
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao iniciar o banco de dados", e);
        }
    }
}