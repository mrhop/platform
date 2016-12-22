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
@Table(name = "platform_cms_block")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"templateBlocks","poll"})
public class BlockTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "block")
    private List<TemplateBlockTable> templateBlocks;

    //news poll  custom static 【hot-news newest-news poll 这些预制】
    @Column(nullable = false)
    private String type;

    //静态时的content，动态时的template
    @Column(columnDefinition="TEXT")
    private String content;

    //使用rest 方式获取 data，动态数据时的数据
    @Column(name = "data_url", nullable = false)
    private String dataUrl;

    //如何使用脚本来进行内容的替换和处理【前端使用】，动态时的数据处理
    @Column(columnDefinition="TEXT")
    private String script;

    @Column(name = "news_number")
    private int newsNumber;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private PollTable poll;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private WebsiteTable website;

}
