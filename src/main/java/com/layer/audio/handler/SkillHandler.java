package com.layer.audio.handler;

import com.jd.alpha.skill.sdk.RequestHandler;
import com.jd.alpha.skill.sdk.entity.request.SkillData;
import com.jd.alpha.skill.sdk.entity.response.SkillResponse;
import com.jd.alpha.skill.sdk.entity.response.SkillResponseDetails;
import com.jd.alpha.skill.sdk.entity.response.SkillResponseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Skill 核心逻辑处理
 *
 * @author cdyangyang18
 */
@Slf4j
@Component
public class SkillHandler extends RequestHandler {

    private static final String WELCOME_MSG = "欢迎使用技能服务";
    private static final String HELP_MSG = "欢迎使用技能服务";
    private static final String CANCEL_MSG = "期待您再次使用";

    /**
     * 处理 LaunchRequest
     *
     * @param skillData 技能请求数据
     * @return 技能响应数据
     */
    @Override
    public SkillResponse onLaunchRequest(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(WELCOME_MSG)
                                .build())
                        .build())
                .build();
    }

    /**
     * 处理 IntentRequest（意图处理）
     *
     * @param skillData 技能请求数据
     * @return 技能响应数据
     */
    @Override
    public SkillResponse onIntentRequest(SkillData skillData) {
        try {
            // 获取意图名称
            String intentName = skillData.getRequest().getIntent().getName();
            // 通过意图名称判断当前意图请求的具体意图
            switch (intentName) {
                // hello 意图情况下的逻辑处理
                case "hello":
                    return SkillResponse.builder()
                            .shouldEndSession(true)
                            .response(SkillResponseDetails.builder()
                                    .output(SkillResponseOutput.builder()
                                            .text("Hello World")
                                            .build())
                                    .build())
                            .build();
                // 默认意图的逻辑处理
                default:
                    return SkillResponse.builder()
                            .shouldEndSession(false)
                            .response(SkillResponseDetails.builder()
                                    .output(SkillResponseOutput.builder()
                                            .text("Unknown Intent")
                                            .build())
                                    .build())
                            .build();
            }
        } catch (Exception e) {
            return onCancelIntent(skillData);
        }
    }

    /**
     * 处理 CancelIntent（通常返回退出语句）
     *
     * @param skillData 技能请求数据
     * @return 技能响应数据
     */
    @Override
    public SkillResponse onCancelIntent(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(CANCEL_MSG)
                                .build())
                        .build())
                .build();
    }

    /**
     * 处理 HelpIntent（通常返回帮助信息）
     *
     * @param skillData 技能请求数据
     * @return 技能响应数据
     */
    @Override
    public SkillResponse onHelpIntent(SkillData skillData) {
        return SkillResponse.builder()
                .shouldEndSession(false)
                .response(SkillResponseDetails.builder()
                        .output(SkillResponseOutput.builder()
                                .text(HELP_MSG)
                                .build())
                        .build())
                .build();
    }

    /**
     * 技能默认响应
     *
     * @param skillData 技能请求数据
     * @return 技能响应数据
     */
    @Override
    public SkillResponse defaultResponse(SkillData skillData) {
        return onHelpIntent(skillData);
    }

}
