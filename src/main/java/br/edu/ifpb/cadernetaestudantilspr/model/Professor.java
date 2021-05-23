package br.edu.ifpb.cadernetaestudantilspr.model;

import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String password; // TODO criptografar

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void hashPassword() {
        this.setPassword(BCrypt.withDefaults().hashToString(8, this.getPassword().toCharArray()));
    }

    public boolean verifyPassword(String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.getPassword());
        return result.verified;
    }
}
