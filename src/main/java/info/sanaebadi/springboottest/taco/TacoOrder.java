package info.sanaebadi.springboottest.taco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccnUMBER;
    private String ccExpireation;
    private String ccCv;
    private List<Taco> tacoList = new ArrayList<>();

    private void addTaco(Taco taco) {
        this.tacoList.add(taco);
    }
}
