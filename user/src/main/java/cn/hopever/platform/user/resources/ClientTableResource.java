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
//用于获取client信息，用于注册client-通用或者内部
//用于返回注册后的client信息，或者列表信息
public class ClientTableResource extends ResourceSupport {

    @NotNull
    private String clientname;

    private String email;

    private String phone;

    private String additionalMessage;

}
