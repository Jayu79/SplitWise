package SplitWise.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ExpenseOwingUser extends BaseModel{

    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
}
