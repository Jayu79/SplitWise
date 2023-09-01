package SplitWise.services.settleup;
import SplitWise.models.User;
import lombok.Data;

@Data
public class Transaction {

    private User from;
    private User to;
    private double amount;

}
