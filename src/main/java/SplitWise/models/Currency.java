package SplitWise.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Currency extends BaseModel{
    private String name;
}
