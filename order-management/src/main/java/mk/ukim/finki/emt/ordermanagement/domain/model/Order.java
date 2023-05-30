package mk.ukim.finki.emt.ordermanagement.domain.model;


import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.Address;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Money total;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Address address;

    private String phoneNumber;

    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderItemState orderItemState;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> productItemList;

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }


    public Money total() {
        return productItemList.stream()
                .map(OrderItem::subtotal)
                .reduce(new Money(this.currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Product product, int qty) {
        Objects.requireNonNull(product,"product must not be null");
        var item  = new OrderItem(product.getId(),product.getPrice(),qty);
        productItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        productItemList.removeIf(v->v.getId().equals(orderItemId));
    }
}
