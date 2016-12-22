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
@Table(name = "platform_cms_poll")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"pollOptions", "blocks", "website"})
public class PollTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @OneToMany(mappedBy = "poll")
    private List<PollOptionTable> pollOptions;

    @OneToMany(mappedBy = "poll")
    private List<BlockTable> blocks;

    @ManyToOne
    @JoinColumn(name = "website_id", nullable = false)
    private WebsiteTable website;
}
