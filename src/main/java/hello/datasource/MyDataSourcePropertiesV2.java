package hello.datasource;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
// 외부설정을 주입받는 객체라는 뜻
// 여기에 외부 설정 key의 묶음 시작점인 my.datasource 적어줌
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {
    private String url;
    private String username;
    private String password;
    private Etc etc;

    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options;

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}
