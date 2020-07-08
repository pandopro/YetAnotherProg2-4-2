package project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.Model.User;
import project.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String add(User user, Model model) {
        userService.add(user);
        model.addAttribute("listz", userService.listUsers());
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @GetMapping("/delete")
    public String delete(long id, Model model) {
        userService.remove(id);
        model.addAttribute("listz", userService.listUsers());
        return "list";
    }

    @GetMapping(value = "/demo")
    public String demo(ModelMap model) {
        userService.add(new User("Alex", "Detroit", "ihbb", "123"));
        userService.add(new User("Anton", "Chelyabinsk", "qwerty@qwerty.ru", "123"));
        userService.add(new User("Igor", "Omsk", "igorOmsk@qwerty.ru", "123"));
        userService.add(new User("Leska", "Murmansk", "leshka@qwerty.ru", "123"));
        model.addAttribute("listz", userService.listUsers());
        return "list";
    }

    @GetMapping("/list")
    public String allUser(Model model) {
        model.addAttribute("listz", userService.listUsers());
        return "list";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, User user) {
        userService.edit(user.getId(), user);
        model.addAttribute("listz", userService.listUsers());
        return "list";
    }
}
