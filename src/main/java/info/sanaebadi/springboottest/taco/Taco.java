package info.sanaebadi.springboottest.taco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taco {
    private String name;
    private List<Ingredient> ingredientList;
}
