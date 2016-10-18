package cn.hopever.platform.user.domain;

import cn.hopever.platform.utils.json.JacksonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_client")
@Data
@EqualsAndHashCode(of = {"id"})
public class ClientTable implements ClientDetails {

    @Transient
    Logger logger = LoggerFactory.getLogger(ClientTable.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id", nullable = false, length = 50,unique = true)
    private String clientId;

    @Column(name = "client_secret", nullable = false, length = 120)
    private String clientSecret;

    @Column(name = "resource_ids", nullable = true)
    private String resourceIds;

    @Column(name = "secret_required", nullable = false)
    private boolean secretRequired = true;

    @Column(name = "scoped")
    private boolean scoped = true;

    @Column(name = "scope", nullable = true)
    private String scope;

    @Column(name = "authorized_grant_types", nullable = false)
    private String authorizedGrantTypes;

    @Column(name = "registered_redirect_uri", nullable = true)
    private String registeredRedirectUri;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "platform_user_client_client_role", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<ClientRoleTable> authorities;

    @Column(name = "access_token_validity_seconds", nullable = true)
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity_seconds", nullable = true)
    private Integer refreshTokenValiditySeconds;

    @Column(name = "additional_information", nullable = true, length = 2000)
    private String additionalInformation;

    @OneToMany(mappedBy = "client",cascade = {CascadeType.ALL})
    private List<ModuleTable> modules;

    @ManyToMany(mappedBy = "clients")
    private List<UserTable> users;



    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        if (resourceIds != null) {
            try {
                this.resourceIds = JacksonUtil.mapper.writeValueAsString(resourceIds);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("json format error", e);
            }
        } else {
            this.resourceIds = null;
        }
    }

    @Override
    public Set<String> getResourceIds() {
        if (this.resourceIds != null) {
            try {
                return JacksonUtil.mapper.readValue(this.resourceIds, Set.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setScope(Map<String,Boolean> scope) {
        if (scope != null) {
            try {
                this.scope = JacksonUtil.mapper.writeValueAsString(scope);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
    }


    @Override
    public Set<String> getScope() {
        if (this.scope != null) {
            try {
                return JacksonUtil.mapper.readValue(this.scope, Map.class).keySet();
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }

    public Map<String,Boolean> getScopeAndApprove() {
        if (this.scope != null) {
            try {
                return JacksonUtil.mapper.readValue(this.scope, Map.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        if (authorizedGrantTypes != null) {
            try {
                this.authorizedGrantTypes = JacksonUtil.mapper.writeValueAsString(authorizedGrantTypes);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if (this.authorizedGrantTypes != null) {
            try {
                return JacksonUtil.mapper.readValue(this.authorizedGrantTypes, Set.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }

    public void setRegisteredRedirectUri(String registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        if (registeredRedirectUri != null) {
            try {
                this.registeredRedirectUri = JacksonUtil.mapper.writeValueAsString(registeredRedirectUri);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (this.registeredRedirectUri != null) {
            try {
                return JacksonUtil.mapper.readValue(this.registeredRedirectUri, Set.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }


    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        if (additionalInformation != null) {
            try {
                this.additionalInformation = JacksonUtil.mapper.writeValueAsString(additionalInformation);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        if (this.additionalInformation != null) {
            try {
                return JacksonUtil.mapper.readValue(this.additionalInformation, Map.class);
            } catch (IOException e) {
                logger.error("json format error", e);
            }
        }
        return null;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        //需要根据scope来判定
        try {
            Map<String,Boolean> scopes = JacksonUtil.mapper.readValue(this.scope, Map.class);
            return scopes.get(scope);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Set<GrantedAuthority> getAuthorities(){
        Set<GrantedAuthority> set  = new HashSet<GrantedAuthority>();
        if(this.authorities!=null){
            for(GrantedAuthority ga:this.authorities){
                set.add(ga);
            }
            return set;
        }
        return null;
    }

    public List<ClientRoleTable> getAuthoritiesBasic(){
        return this.authorities;
    }
}
