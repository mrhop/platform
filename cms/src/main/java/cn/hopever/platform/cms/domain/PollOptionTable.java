package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/12/19.
 */
@Entity
@Table(name = "platform_cms_poll_option")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"poll"})
public class PollOptionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( nullable = false)
    private String title;

    @Column(name = "vote_times",nullable = false)
    private int voteTimes = 0;

    @ManyToOne
    @JoinColumn(name = "website_id")
    private WebsiteTable website;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private PollTable poll;
}
