package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.user.DataCreateUser;
import BrennerSouza.NutriFitAPI.domain.user.DataDetailsUser;
import BrennerSouza.NutriFitAPI.domain.user.User;
import BrennerSouza.NutriFitAPI.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid DataCreateUser data, UriComponentsBuilder uriBuilder) {
        var user = new User(data);
        repository.save(user);
        System.out.println(user);

        var uri = uriBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailsUser(user));
    }


}
