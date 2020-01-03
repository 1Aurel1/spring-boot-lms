package com.aurel.lms.model;

import com.aurel.lms.model.authority.Authority;
import com.aurel.lms.model.courseUser.CourseUser;
import com.aurel.lms.model.file.ImageFile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String langKey;

    @NaturalId
    @Column(unique = true)
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

    @OneToOne
    @JoinColumn
    private ImageFile profileImage;

    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable( name = "authority_user",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    @OneToMany(mappedBy = "participant")
    private Set<Attendance> attendances;

    @OneToMany(mappedBy = "owner")
    private Set<Content> contents;

    @OneToMany(mappedBy = "user")
    private Set<CourseUser> courses;

    @OneToMany(mappedBy = "user")
    private Set<Notice> notices;

    public User() {

        this.authorities = new HashSet<>();
        this.attendances = new HashSet<>();
        this.contents = new HashSet<>();
        this.courses = new HashSet<>();
        this.notices = new HashSet<>();
    }

    public void addAuthority(Authority authority){
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority){
        this.authorities.remove(authority);
    }
}
