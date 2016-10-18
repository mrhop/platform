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
public class ModuleResource extends ResourceSupport {

    @NotNull
    private long internalId;

    private ClientResource client;

    private String moduleName;

    private Integer moduleOrder;

    private String moduleUrl;

    private String iconClass;

    private ModuleResource parent;

    private List<ModuleResource> children;

    private boolean available;

    private List<ModuleRoleResource> authorities;


}
