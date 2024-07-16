package BrennerSouza.NutriFitAPI.controller;

import BrennerSouza.NutriFitAPI.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DataUserList>> listAllUsers(Pageable pageable) {
        var page = repository.findAll(pageable).map(DataUserList::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailUser(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsUser(user));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUser(@RequestBody @Valid DataUpdateUser data) {
        var user = repository.getReferenceById(data.id());
        user.updateDataUser(data);
        return ResponseEntity.ok(new DataDetailsUser(user));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
