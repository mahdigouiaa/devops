package tn.iit.storemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto {
    private long id;
    private String name;
    private float dosage;
    private float price;
    private Date expiredDate;
    private long categoryId;
    private String categoryName;
}
