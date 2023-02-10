package info.sanaebadi.springboottest.controller;

import info.sanaebadi.springboottest.model.Ingredient;
import info.sanaebadi.springboottest.model.Taco;
import info.sanaebadi.springboottest.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    @ModelAttribute
    public void addIngrediendToModel(Model model) {
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("FLTO", "Flour tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn tORTILLA", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Deced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monerry jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Slasa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour cream", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredientList, Ingredient.Type type) {
        return ingredientList
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
