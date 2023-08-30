package SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.http.StreamingHttpOutputMessage;

@Data
@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String userName;
    private String hashedPassword;
    private String phoneNumber;
}
