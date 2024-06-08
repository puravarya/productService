package dev.purav.productservice09april.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyProductDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
 // dto for each req parameter so that in future if the request if the req needs additional
// params you can easily do it without much in it