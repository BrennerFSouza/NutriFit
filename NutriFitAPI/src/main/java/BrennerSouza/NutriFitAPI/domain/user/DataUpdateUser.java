package BrennerSouza.NutriFitAPI.domain.user;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
        @NotNull
        Long id,
        String password,
        String gender
) {
}
