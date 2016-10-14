package cn.hopever.platform.user.domain;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_user")
@Data
@EqualsAndHashCode(of = {"id"})
public class UserTable implements UserDetails {

    @Transient
    Logger logger = LoggerFactory.getLogger(UserTable.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked = false;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "additional_message", nullable = true, length = 2000)
    private String additionalMessage;

    @Column(name = "limited_date", nullable = true)
    private Date limitedDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "platform_user_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<RoleTable> authorities;

    //client many-to-many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "platform_user_user_client", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"))
    private Set<ClientTable> clients;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "platform_user_user_module_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<ModuleRoleTable> modulesAuthorities;

    @Override
    public boolean isAccountNonExpired() {
        if (this.limitedDate != null) {
            return this.limitedDate.after(new Date());
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }

    public void setAdditionalMessage(Map<String, Object> additionalMessage) {
        if (additionalMessage != null) {
            try {
                this.additionalMessage = JacksonUtil.mapper.writeValueAsString(additionalMessage);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
    }

    public Map<String, Object> getAdditionalMessage() {
        if (this.additionalMessage != null) {
            try {
                return JacksonUtil.mapper.readValue(this.additionalMessage, Map.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }
}
