package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Account {
    String username;
    String password;
    int id;
    int issell;
    int isAdmin;
    public Account(String username, String password, int id, int issell, int isAdmin) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.issell = issell;
        this.isAdmin = isAdmin;
    }



}
