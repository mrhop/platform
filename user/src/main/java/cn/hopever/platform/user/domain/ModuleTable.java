package cn.hopever.platform.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/9/8.
 */
@Entity
@Table(name = "platform_user_module")
@Data
@EqualsAndHashCode(of={"id"})
public class ModuleTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private ClientTable client;

    @Column(name = "module_name", nullable = false, length = 50, unique = true)
    private String moduleName;

    @Column(name = "module_order", nullable = false)
    private Integer moduleOrder = 0;

    @Column(name = "module_url", length = 200)
    private String moduleUrl;

    @Column(name = "icon_class", length = 50)
    private String iconClass;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ModuleTable parent;

    @OneToMany(mappedBy = "parent",cascade = {CascadeType.ALL})
    @OrderBy("moduleOrder asc")
    private List<ModuleTable> children;

    @Column(name = "available",nullable = false)
    private boolean available = true;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "platform_user_module_module_role", joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<ModuleRoleTable> authorities;

}
