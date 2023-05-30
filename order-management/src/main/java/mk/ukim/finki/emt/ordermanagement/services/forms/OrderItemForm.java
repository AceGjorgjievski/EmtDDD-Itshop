package mk.ukim.finki.emt.ordermanagement.services.forms;


import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Product product;

    @Min(1)
    private int quantity = 1;
}
