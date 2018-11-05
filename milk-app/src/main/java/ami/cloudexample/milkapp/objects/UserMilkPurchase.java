package ami.cloudexample.milkapp.objects;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
public class UserMilkPurchase {

    private User user;

    private List<MilkPurchase> milkPurchases;

    public User getUser() {
        return user;
    }

    public List<MilkPurchase> getMilkPurchases() {
        return milkPurchases;
    }


    public static final class UserMilkPurchaseBuilder {
        private User user;
        private List<MilkPurchase> milkPurchases;

        public UserMilkPurchaseBuilder() {
        }

        public static UserMilkPurchaseBuilder anUserMilkPurchase() {
            return new UserMilkPurchaseBuilder();
        }

        public UserMilkPurchaseBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public UserMilkPurchaseBuilder withMilkPurchases(List<MilkPurchase> milkPurchases) {
            this.milkPurchases = milkPurchases;
            return this;
        }

        public UserMilkPurchase build() {
            UserMilkPurchase userMilkPurchase = new UserMilkPurchase();
            userMilkPurchase.milkPurchases = unmodifiableList(new ArrayList<>(milkPurchases));
            userMilkPurchase.user = user;
            return userMilkPurchase;
        }
    }
}
