package BrennerSouza.NutriFitAPI.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String name;

    private Date birthDate;

    private String gender;

    public User(DataCreateUser data) {
        this.login = data.login();
        this.password = data.password();
        this.name = data.name();
        this.birthDate = data.birthDate();
        this.gender = data.gender();
    }
}
