package com.controller;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.jaq.model.v20161123.SpamRegisterPreventionRequest;
import com.common.utils.Result;
import com.model.AliyunVerifyModel;
import com.model.Member;
import com.service.MemberService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController  extends AbstractController{
    @Autowired
    private MemberService memberService;
    @Autowired
    private IAcsClient client;

    /**
     * @param
     * @return void
     * @Description:登录
     * @author xuguoli
     * @date 2018/8/9 15:23
     */
    @PostMapping("/check")
    public void check(@RequestBody AliyunVerifyModel loginModel) {
        SpamRegisterPreventionRequest request = new SpamRegisterPreventionRequest();
        // 必填参数
        request.setPhoneNumber("15087429695");
        request.setIp("192.167.10.11");
        request.setProtocolVersion("1.0.1");
        request.setSource(1); //注册来源。1：PC网页；2：移动网页；3：APP;4:其它
        request.setJsToken(""); //对应前端页面的afs_token，source来源为1&2&4时，必填;
        request.setSDKToken("");//对应sdk中获取的wtoken，source来源为3时，必填;

        // 选填参数
        request.setEmail("");
        request.setUserId("");
        request.setIdType(1);
        request.setCurrentUrl("");
        request.setAgent("");
        request.setCookie("");
        request.setSessionId("");
        request.setMacAddress("");
        request.setReferer("");
        request.setNickName("");
        request.setCompanyName("");
        request.setAddress("");
        request.setIDNumber("");
        request.setBankCardNumber("");
        request.setExtendData("");

//        AuthenticateSigRequest request = new AuthenticateSigRequest();
//
//        // 必填参数，从前端获取，不可更改
//        request.setSessionId(loginModel.getSessionId());
//        // 必填参数，从前端获取，不可更改
//        request.setSig(loginModel.getSig());
//        // 必填参数，从前端获取，不可更改
//        request.setToken(loginModel.getToken());
//        // 必填参数，从前端获取，不可更改
//        request.setScene(loginModel.getScene());
//        // 必填参数，后端填写
//        request.setAppKey(APP_KEY);
//        // 必填参数，后端填写
//        request.setRemoteIp(HttpRequest.getIpAddress(req));

        try {
            // response的code枚举：100验签通过，900验签失败
            Object response = client.getAcsResponse(request);
            if (response.toString().equals(1000)) {
                System.out.println("验签通过");
                //String phone = loginModel.getPhone();
                //String password = loginModel.getPassword();
                //TODO 请求server层 执行登录相关操作.

            } else {
                System.out.println("验签失败");

            }
        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    @PostMapping("/login")
    public Result login(@RequestBody Member model) {
        Member member = memberService.login(model);
        return member == null ? Result.error("账号或密码不正确") : Result.ok("登录成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody Member model) {
        if (model == null) {
            return Result.error("注册信息不能为空");
        }
        Member member = memberService.findMemberByPhone(model.getPhone());
        if (member == null) {
            return Result.ok("当前手机号已经注册");
        }

        model.setId(UUID.randomUUID().toString());
        model.setStatus(1);
        int result = memberService.register(model);
        return result > 0 ? Result.ok("注册成功") : Result.ok("注册失败");
    }

    @PostMapping("/setPassword")
    public Result setPassword(@RequestBody Member model) {
        int result = memberService.setPassword(model);
        return result > 0 ? Result.ok("设置成功") : Result.ok("设置失败");
    }

    @GetMapping("/findMemberByPhone")
    public Result findMemberByPhone(String phone) {
        Member member = memberService.findMemberByPhone(phone);
        return member == null ? Result.error("账号不存在") : Result.ok().put("data", member);
    }
}


