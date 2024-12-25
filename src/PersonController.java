import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", personService.findAll());
        return "user_list";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", personService.findById(id));
        return "user_detail";
    }

    @PostMapping
    public String createUser(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/users";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute Person person) {
        person.setId(id);
        personService.save(person);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        personService.delete(id);
        return "redirect:/users";
    }
}