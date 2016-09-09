package cn.hopever.platform.user.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;

/**
 * Created by Donghui Huo on 2016/8/31.
 */
@Data
@EqualsAndHashCode(callSuper=false)
//用于获取用户信息并授权第三方client
//其他用于后台管理部分的则需要考虑其他的userresource方案，用于管理用户的可用性
public class UserTableResource extends ResourceSupport {

    @NotNull
    private String username;

    private String email;

    private String phone;

    private String additionalMessage;

}
