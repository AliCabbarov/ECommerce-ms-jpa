package model.entity;

import jakarta.persistence.*;
import lombok.*;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity(name = "_user")
@Builder
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String fin;
    private String phoneNumber;
    private BigDecimal account;
    private String email;
    private String password;
    private String address;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Cart cart;

    public User(long id, String name, String surname, LocalDate birthdate, String fin,String phoneNumber,BigDecimal account, String email, String password, String address, Cart cart) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        setBirthdate(birthdate);
        setFin(fin);
        this.phoneNumber = phoneNumber;
        this.account = account;
        setEmail(email);
        setPassword(password);
        this.address = address;
        this.cart = cart;
    }

    public void setFin(String fin) {
        if (fin.length() == 7){
            this.fin = fin;
        }else throw new ApplicationException(ExceptionEnums.WRONG_FIN_EXCEPTION);
    }

    public void setEmail(String email) {
        if (email.contains("@")){
            this.email = email;
        }else throw new ApplicationException(ExceptionEnums.WRONG_EMAIL_FORMAT_EXCEPTION);
    }

    public void setPassword(String password) {
        if (password.length() > 6){
            this.password = password;
        } else throw new ApplicationException(ExceptionEnums.WEAK_PASSWORD_EXCEPTION);
    }
    public void setBirthdate(LocalDate birthdate) {
        if (birthdate.getYear() < LocalDate.now().minusYears(18).getYear()){
            this.birthdate = birthdate;
        }else throw new ApplicationException(ExceptionEnums.LOW_BIRTHDATE_EXCEPTION);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", fin='" + fin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                ", address='" + address + '\'' +
                ", cart=" +
                '}';
    }
}
