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
@Table(name = "platform_cms_resource")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"templateResources", "website"})
public class ResourceTable {
    //资源库，比如css，js等，注意js css关联的文件只放置在nginx的静态lib中，不向moglifs或者tomcat中存储，另外js和css也是，更新时需要做好备份
    //form表单的个性化势在必行
    //须知：建议仍然通过上传方式，在WebsiteTable里面给出 静态资源的上传起始路径和访问路径
    //这些资源只是用来形成样式和格式的（比如滑动，图片灯箱等），不对数据进行处理，需要处理数据的部分，放置在内置资源中
    //仍然使用多website的方式
    //如果没有website，则为通用资源，比如jquery或者bootstrap css

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    //资源的类型
    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "resource")
    private List<TemplateResourceTable> templateResources;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private WebsiteTable website;

}
