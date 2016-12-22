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
@Table(name = "platform_cms_navigate")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"article", "newsType", "website"})
public class NavigateTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private NavigateTable parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL})
    @OrderBy("orderNum asc")
    private List<NavigateTable> children;

    @Column(nullable = false)
    private int orderNum = 0;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleTable article;

    @ManyToOne
    @JoinColumn(name = "news_type_id")
    private NewsTypeTable newsType;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
