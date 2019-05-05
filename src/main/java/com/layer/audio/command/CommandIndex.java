package com.layer.audio.command;

import com.alibaba.fastjson.JSON;
import com.jd.alpha.skill.sdk.entity.request.SkillData;
import com.jd.alpha.skill.sdk.entity.response.SkillResponse;
import com.layer.audio.handler.SkillHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandIndex {

    private final static Logger LOG = LoggerFactory.getLogger(CommandIndex.class);

    @Autowired
    private SkillHandler skillHandler;

    @PostMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    public SkillResponse index(@RequestBody String requestBody) {
        LOG.info("Skill Request Body: {}", requestBody);
        SkillData data = JSON.parseObject(requestBody, SkillData.class);
        SkillResponse response = skillHandler.handle(data);
        LOG.info("Skill Response: {}", JSON.toJSONString(response));
        return response;
    }
}
