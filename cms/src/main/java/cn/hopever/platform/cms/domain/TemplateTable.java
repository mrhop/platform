package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/12/19.
 */
@Entity
@Table(name = "platform_cms_template")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"templateBlocks","templateResources","website"})
public class TemplateTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "layout_type", nullable = false)
    private String layoutType;

    @Column(name = "layout_scale", nullable = false)
    private String layoutScale;

    @Column(name = "content_position", nullable = false)
    private String contentPosition;//使用model 弹出的方式来进行处理--content or news ,核心部分

    @Column(name = "content_script")
    private String contentScript;//重新排版文章或者新闻内容时使用

    @OneToMany(mappedBy = "template")
    private List<TemplateBlockTable> templateBlocks;

    @OneToMany(mappedBy = "template")
    private List<TemplateResourceTable> templateResources;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private WebsiteTable website;

    //缓存后的template不存在表里面，而是存储在redis里面，而且是自动cache和更新cache的
    //每第一次访问时，如果没有缓存，则进行缓存
    //每次更新时，将其关联的cache删除即可，不进行再次生成，只在访问时进行生成
    //同时给出一个批量缓存的处理

}
