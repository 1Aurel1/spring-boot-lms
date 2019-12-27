package com.aurel.lms.model;

import com.aurel.lms.model.authority.Authority;
import com.aurel.lms.model.authority.AuthorityName;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    private String username;

    @Column
    private String password;

    @NaturalId
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean enabled;

    @Column
    private boolean accountNonExpired;

    @Column
    private boolean credentialsNonExpired;

    @Column
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "user_role",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    public User() {
        authorities = new HashSet<>();
    }

    public void addAuthority(Authority authority){
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority){
        this.authorities.remove(authority);
    }
}
