package BrennerSouza.NutriFitAPI.domain.user;


import java.time.LocalDate;
import java.util.Date;

public record DataDetailsUser(
        Long id,
        String login,
        String password,
        String name,
        Date birthDate,
        String gender
        ) {

    public DataDetailsUser(User user) {
        this(user.getId(), user.getLogin(), user.getPassword(), user.getName(), user.getBirthDate(), user.getGender());
    }
}
