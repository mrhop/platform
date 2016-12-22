package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Donghui Huo on 2016/12/19.
 */

@Entity
@Table(name = "platform_cms_article")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"website"})
public class ArticleTable {
    // title,content
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition="TEXT")
    private String content;

    @Column(name = "is_published",nullable = false)
    private boolean isPublished = true;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_user")
    private String createUser;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
