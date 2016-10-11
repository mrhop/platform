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
//获取角色的一些信息并进行处理，
public class RoleTableResource extends ResourceSupport {

    @NotNull
    private String username;

    private String email;

    private String phone;

    private String additionalMessage;

}
