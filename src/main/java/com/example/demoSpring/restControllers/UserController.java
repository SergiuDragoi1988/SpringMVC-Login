package com.example.demoSpring.restControllers;

import com.example.demoSpring.data.DTO.UserDTO;
import com.example.demoSpring.services.IUserService;
import com.example.demoSpring.services.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    /*public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }*/

    @GetMapping("user/all")
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @RequestMapping("user/{userId}/sendMail")
    public void sendMail(@PathVariable Integer userId, String subject, String content){
        userService.sendMail(userId, subject, content);

    }

    @GetMapping("user/{id}/modify")
    public void modifyUser(@PathVariable Integer id, Optional<String> name, Optional<String> email){
        userService.modifyUser(id, name, email);
    }

    @GetMapping("user/insert")
    public void insertUser(String name, String mail){
        userService.insertUser(name, mail);
    }

    @GetMapping("user/{id}/delete")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }

    @GetMapping("user/{userId}/changeAddress")
    public void changeAddress(@PathVariable Integer userId, Optional<String> city,
                              Optional<String> country, Optional<String> street){
        userService.changeAddress(userId, city, country, street);
    }

    @GetMapping("user/{userId}/getTitle")
    public String getUserTitle(@PathVariable Integer userId) throws NotFoundException {
        return userService.getServiceTitle(userId);
    }
}
