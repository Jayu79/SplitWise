package SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Expense extends BaseModel{
    private double amount;
    @ManyToOne
    private User createdBy;
    private String description;
    private Date createdAt;
    @ManyToOne
    private Currency baseCurrency;
    @ManyToMany
    private List<User> participants;


}
