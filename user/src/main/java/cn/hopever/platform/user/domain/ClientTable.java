package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_client")
@Data
@EqualsAndHashCode(of={"id"})
public class ClientTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_name",nullable = false,length= 50)
    private String clientname;

    @Column(name = "password",nullable = false,length= 120)
    private String password;

    @Column(name = "client_non_locked",nullable = false)
    private boolean clientNonLocked = false;

    @Column(name = "enabled",nullable = false)
    private boolean enabled = true;

    @Column(name = "email",nullable = true,length= 50)
    private String email;

    @Column(name = "phone",nullable = true,length= 50)
    private String phone;

    @Column(name = "additional_message",nullable = true,length= 2000)
    private String additionalMessage;

    @Column(name = "limited_date",nullable = true)
    private Date limitedDate;

    @Column(name = "grant_types",nullable = false)
    private String grantTypes;

    @Column(name = "grant_types",nullable = true,length= 2000)
    private String redirectUris;

    @Column(name = "scopes",nullable = true)
    private String scopes;

    public boolean isClientNonExpired() {
        if( this.limitedDate!=null){
            return this.limitedDate.after(new Date());
        }
        return true;
    }

}
