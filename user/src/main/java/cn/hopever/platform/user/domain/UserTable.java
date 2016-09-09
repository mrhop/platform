package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_user")
@Data
@EqualsAndHashCode(of={"id"})
public class UserTable implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name",nullable = false,length= 50)
    private String username;

    @Column(name = "password",nullable = false,length= 120)
    private String password;

    @Column(name = "account_non_locked",nullable = false)
    private boolean accountNonLocked = false;

    @Column(name = "enabled",nullable = false)
    private boolean enabled = true;

    @Column(name = "email",nullable = false,length= 50)
    private String email;

    @Column(name = "phone",nullable = false,length= 50)
    private String phone;

    @Column(name = "additional_message",nullable = false,length= 2000)
    private String additionalMessage;

    @Column(name = "limited_date",nullable = true)
    private Date limitedDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "platform_user_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<RoleTable> authorities;

    @Override
    public boolean isAccountNonExpired() {
        if( this.limitedDate!=null){
            return this.limitedDate.after(new Date());
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
