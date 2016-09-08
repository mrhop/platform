package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_user")
@Data
@EqualsAndHashCode(exclude={"id"})
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "additional_message",nullable = false)
    private String additionalMessage;
}
