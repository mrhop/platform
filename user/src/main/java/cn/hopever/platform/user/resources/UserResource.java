package cn.hopever.platform.user.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omg.CORBA.Object;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/8/31.
 */
@Data
@EqualsAndHashCode(callSuper=false)
//用于获取用户信息并授权第三方client
//其他用于后台管理部分的则需要考虑其他的userresource方案，用于管理用户的可用性
public class UserResource extends ResourceSupport {

    @NotNull
    private long internalId;

    @NotNull
    private String username;

    private String password;

    private boolean accountNonLocked = false;

    private String email;

    private String phone;

    private  boolean enabled;

    private Date limitedDate;

    private Set<RoleResource> authorities;

    private Set<ClientResource> clients;

    private Map<String,Object> additionalMessage;

    private Set<ModuleRoleResource> modulesAuthorities;
}
