package cn.hopever.platform.user.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omg.CORBA.Object;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/8/31.
 */
@Data
@EqualsAndHashCode(callSuper = false)
//用于获取client信息，用于注册client-通用或者内部
//用于返回注册后的client信息，或者列表信息
public class ClientResource extends ResourceSupport {

    @NotNull
    private long internalId;

    @NotNull
    private String clientId;

    private String clientSecret;

    private boolean secretRequired = true;

    private Set<String> resourceIds;

    private boolean scoped = true;

    private Set<String> scope;

    private Set<String> authorizedGrantTypes;

    private String registeredRedirectUri;

    private List<ClientRoleResource> authorities;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private Map<String, Object> additionalInformation;

    private List<ModuleResource> modules;

    private List<UserResource> users;

}
