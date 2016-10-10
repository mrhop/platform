package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_client_role")
@Data
@EqualsAndHashCode(of={"id"})
public class ClientRoleTable implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "authority",nullable = false,length= 50)
    private String authority;

    @Column(name = "level",nullable = false)
    private short level;

    @ManyToMany(mappedBy = "authorities")
    private Set<ClientTable> clients;

}
