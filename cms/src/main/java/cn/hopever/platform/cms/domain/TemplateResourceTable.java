package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/12/19.
 */
@Entity
@Table(name = "platform_cms_template_resource")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"template", "resource"})
public class  TemplateResourceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //是放置在head中还是body的尾部
    @Column(name = "is_top", nullable = false)
    private boolean isTop = true;

    //资源在模板中的排序,0 最先
    @Column(name = "order_num", nullable = false)
    private int orderNum;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private TemplateTable template;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceTable resource;

}
