package SplitWise.dtos;

import lombok.Data;

@Data
public class UpdateProfileRequestDTO {

    private Long userId;
    private String newPassword;

}
