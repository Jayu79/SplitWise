package SplitWise.dtos;

import SplitWise.services.settleup.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpGroupResponseDTO {

    private List<Transaction> transactions;

}
