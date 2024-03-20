package api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor

public class User {
    @JsonProperty("username")
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
