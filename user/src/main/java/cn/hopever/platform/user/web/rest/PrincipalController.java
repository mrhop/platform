package cn.hopever.platform.user.web.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Donghui Huo on 2016/9/6.
 */
@RestController
@RequestMapping(value = "/resources/principal", produces = "application/json")
public class PrincipalController {

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("")
    public Principal resource(Principal principal) {
        return principal;
    }
}
