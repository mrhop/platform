package cn.hopever.platform.user.domain;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_user")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"authorities", "clients", "modulesAuthorities"})
public class UserTable implements UserDetails {

    @Transient
    Logger logger = LoggerFactory.getLogger(UserTable.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked = true;

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

    @Column(name = "photo", nullable = true)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "create_user", nullable = true,insertable = true,updatable = true)
    private UserTable createUser;

    @Column(name = "created_date", nullable = true)
    private Date createdDate;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "platform_user_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleTable> authorities;

    //client many-to-many
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "platform_user_user_client", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"))
    private List<ClientTable> clients;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "platform_user_user_module_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<ModuleRoleTable> modulesAuthorities;

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
