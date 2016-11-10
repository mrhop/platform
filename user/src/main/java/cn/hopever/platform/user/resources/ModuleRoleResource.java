package cn.hopever.platform.user.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/31.
 */
@Data
@EqualsAndHashCode(callSuper=false)
//获取角色的一些信息并进行处理，
public class ModuleRoleResource extends ResourceSupport {

    @NotNull
    private long internalId;

    @NotNull
    private String authority;

    private String name;

    private short level;

    private List<ModuleResource> modules;

    private ClientResource client;

    private List<UserResource> users;

}
