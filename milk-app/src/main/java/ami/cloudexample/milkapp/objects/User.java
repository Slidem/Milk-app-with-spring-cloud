package ami.cloudexample.milkapp.objects;

/**
 * @author Mihai Alexandru
 * @date 30.10.2018
 */
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }


    public static final class UserBuilder {
        private Integer id;
        private String firstName;
        private String lastName;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            User user = new User();
            user.id = id;
            user.lastName = lastName;
            user.firstName = firstName;
            return user;
        }
    }
}
