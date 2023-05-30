package mk.ukim.finki.emt.productcatalog.services.forms;

import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {

    @NonNull
    private String productName;
    private Money price;
    private int sales;
}
