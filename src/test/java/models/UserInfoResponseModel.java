package models;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoResponseModel {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserPerPageBodyModel> data;
    private SupportResponseModel support;
}
