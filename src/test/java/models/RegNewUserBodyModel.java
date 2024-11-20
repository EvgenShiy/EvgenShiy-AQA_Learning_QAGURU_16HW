package models;

import lombok.Data;

@Data
public class RegNewUserBodyModel {
    String username, email, password;
}
