package org.example.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
