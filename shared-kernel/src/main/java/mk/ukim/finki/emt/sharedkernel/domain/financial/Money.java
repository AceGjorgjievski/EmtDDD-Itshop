package mk.ukim.finki.emt.sharedkernel.domain.financial;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(EnumType.STRING)
    private final Currency currency;

    private final double amount;

    protected Money() {
        this.amount = 0;
        this.currency = null;
    }

    public Money(@NonNull Currency currency, @NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, int amount) {
        return new Money(currency, amount);
    }

    public Money add(Money money) {
        if(!this.currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(this.currency, this.amount + money.getAmount());
    }

    public Money subtract(Money money) {
        if(!this.currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException("Cannot subtract two Money objects with different currencies");
        }
        return new Money(this.currency, this.amount - money.getAmount());
    }

    public Money multiply(int m) {
        return new Money(this.currency, m * this.getAmount());
    }


}
