package mk.ukim.finki.emt.usermanagement.services.forms;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserForm {

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;
}
