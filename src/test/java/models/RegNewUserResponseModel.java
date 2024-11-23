package models;

import lombok.Data;

@Data
public class RegNewUserResponseModel {
    String token, error;
    int id;
}
