package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/12/21.
 */
@Entity
@Table(name = "platform_cms_website")
@Data
@EqualsAndHashCode(of = {"id"})
public class WebsiteTable {
    //title , description,keywords
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String keywords;

    @Column
    private String description;

    //关联的管理用户名【这个用户名由管理员指定，而且是可以有多个，使用[a,b,c]的方式来实现】
    @Column(name = "related_usernames")
    private String relatedUsernames;

    @Column(name = "resource_address")
    private String resourceAddress;

    @Column(name = "resource_url_prefix")
    private String resourceUrlPrefix;

}
