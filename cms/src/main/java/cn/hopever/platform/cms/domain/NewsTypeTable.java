package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/12/19.
 */

@Entity
@Table(name = "platform_cms_news_type")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"website"})
public class NewsTypeTable {

    //id, title，区分不同的news类型，这个和news的top，newest，没有关系

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;

}
