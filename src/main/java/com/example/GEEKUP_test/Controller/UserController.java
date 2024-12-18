package com.example.GEEKUP_test.Controller;


import com.example.GEEKUP_test.DTO.Response;
import com.example.GEEKUP_test.DTO.UserDTO;
import com.example.GEEKUP_test.Model.User;
import com.example.GEEKUP_test.Service.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Response> createUser(@RequestBody UserDTO user) {
        Response response = userService.createUser(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/update-user")
    public ResponseEntity<Response> updateUser(@RequestBody UserDTO user) {
        Response response = userService.updateUser(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable String id) {
        Response response = userService.deleteUser(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable String id) {
        Response response = userService.getUserById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<Response> getAllUsers() {
        Response response = userService.getAllUsers();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
