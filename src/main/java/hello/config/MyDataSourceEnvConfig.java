package hello.config;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.expression.spel.ast.Literal;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceEnvConfig {
    private final Environment env;

    // 스프링이 만든 Environment 주입
    public MyDataSourceEnvConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public MyDataSource myDataSource() {
        String url = env.getProperty("my.datasource.url");
        String username = env.getProperty("my.datasource.username");
        String password = env.getProperty("my.datasource.password");
        // 타입 줄 수 있음
        int maxConnection = env.getProperty("my.datasource.etc.max-connection", Integer.class);
        Duration timeout = env.getProperty("my.datasource.etc.timeout", Duration.class);
        List<String> options = env.getProperty("my.datasource.etc.option", List.class);

        return new MyDataSource(url, username, password, maxConnection, timeout, options);
    }

}
