package ami.cloudexample.milkapp.objects;

import java.time.Instant;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
public class MilkPurchase {

    private Instant purchaseDate;

    private Integer quantity;

    public Instant getPurchaseDate() {
        return purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static final class MilkPurchaseBuilder {
        private Instant purchaseDate;
        private Integer quantity;

        public MilkPurchaseBuilder withPurchaseDate(Instant purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public MilkPurchaseBuilder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public MilkPurchase build() {
            MilkPurchase milkPurchase = new MilkPurchase();
            milkPurchase.purchaseDate = purchaseDate;
            milkPurchase.quantity = quantity;
            return milkPurchase;
        }
    }
}
