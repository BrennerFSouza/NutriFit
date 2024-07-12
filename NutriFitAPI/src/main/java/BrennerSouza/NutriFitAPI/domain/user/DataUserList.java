package BrennerSouza.NutriFitAPI.domain.user;

import java.util.Date;

public record DataUserList(
        Long id,
        String login,
        String password,
        String name,
        Date birthDate,
        String gender
) {
    public DataUserList(User user) {
        this(user.getId(), user.getLogin(), user.getPassword(), user.getName(), user.getBirthDate(), user.getGender());
    }
}
