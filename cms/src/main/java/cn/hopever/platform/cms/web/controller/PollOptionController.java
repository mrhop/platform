package cn.hopever.platform.cms.web.controller;

import cn.hopever.platform.cms.domain.PollOptionTable;
import cn.hopever.platform.cms.service.PollOptionTableService;
import cn.hopever.platform.cms.service.PollTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
@RequestMapping(value = "/polloption", produces = "application/json")
public class PollOptionController {
    Logger logger = LoggerFactory.getLogger(PollOptionController.class);
    @Autowired
    private PollTableService pollTableService;
    @Autowired
    private PollOptionTableService pollOptionTableService;

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public List getListByPoll(@RequestParam Long pollId, Principal principal) {
        List<HashMap<String, Object>> listReturn = null;
        Iterable<PollOptionTable> list = pollOptionTableService.getListByPoll(pollId);
        if (list.iterator().hasNext()) {
            listReturn = new ArrayList<>();
            for (PollOptionTable pot : list) {
                HashMap<String, Object> mapTemp = new HashMap<>();
                mapTemp.put("key", pot.getId());
                List<Object> listTmp = new ArrayList<>();
                listTmp.add("");
                listTmp.add(pot.getTitle());
                listTmp.add(pot.getVoteTimes());
                if (pot.getPoll() != null) {
                    listTmp.add(pot.getPoll().getTitle());
                } else {
                    listTmp.add(null);
                }
                mapTemp.put("value", listTmp);
                listReturn.add(mapTemp);
            }
        }
        return listReturn;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public void delete(@RequestParam Long id, Principal principal) {
        //需要判断是否普通用户有相关的website可处理权限
        this.pollOptionTableService.delete(id);
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public Map info(@RequestParam Long id, Principal principal) {
        PollOptionTable pot = this.pollOptionTableService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", pot.getId());
        map.put("title", pot.getTitle());
        map.put("voteTimes", pot.getVoteTimes());
        if (pot.getPoll() != null) {
            HashMap<String, Object> mapPoll = new HashMap<>();
            mapPoll.put("id", pot.getPoll().getId());
            mapPoll.put("title", pot.getPoll().getTitle());
            map.put("poll", mapPoll);
        } else {
            map.put("poll", null);
        }
        return map;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Map updatePollOption(@RequestBody Map<String, Object> body, Principal principal) {
        //this.pollOptionTableService.save();
        long id = Long.valueOf(body.get("id").toString());
        PollOptionTable pollOptionTable = this.pollOptionTableService.get(id);
        if (body.get("title") != null) {
            pollOptionTable.setTitle(body.get("title").toString());
        }
        if (body.get("voteTimes") != null) {
            pollOptionTable.setVoteTimes(Integer.valueOf(body.get("voteTimes").toString()));
        }
        if (body.get("poll") != null) {
            pollOptionTable.setPoll(pollTableService.get(Long.valueOf(body.get("poll").toString())));
        }
        this.pollOptionTableService.save(pollOptionTable);
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('cms_admin_client')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Map savePollOption(@RequestBody Map<String, Object> body, Principal principal) {
        //this.pollOptionTableService.save();
        PollOptionTable pollOptionTable = new PollOptionTable();
        if (body.get("title") != null) {
            pollOptionTable.setTitle(body.get("title").toString());
        }
        if (body.get("voteTimes") != null) {
            pollOptionTable.setVoteTimes(Integer.valueOf(body.get("voteTimes").toString()));
        }else{
            pollOptionTable.setVoteTimes(0);
        }
        if (body.get("poll") != null) {
            pollOptionTable.setPoll(pollTableService.get(Long.valueOf(body.get("poll").toString())));
        }
        this.pollOptionTableService.save(pollOptionTable);
        return null;
    }

}
