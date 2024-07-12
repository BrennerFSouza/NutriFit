package BrennerSouza.NutriFitAPI.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;


public record DataCreateUser(
        @NotBlank
        String      login,
        @NotBlank
        String      password,
        @NotBlank
        String      name,
        @NotNull
        Date birthDate,
        @NotBlank
        String      gender

) {
}
