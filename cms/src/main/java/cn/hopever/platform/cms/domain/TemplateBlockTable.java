package cn.hopever.platform.cms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Donghui Huo on 2016/12/19.
 */
@Entity
@Table(name = "platform_cms_template_block")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"template", "block"})
public class TemplateBlockTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private TemplateTable template;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private BlockTable block;

    @Column(name = "block_position", nullable = false)
    private String blockPosition;

}
