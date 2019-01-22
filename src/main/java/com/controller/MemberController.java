package com.controller;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigRequest;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigResponse;
import com.common.utils.Result;
import com.model.AliyunVerifyModel;
import com.model.Member;
import com.service.MemberService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController extends AbstractController {
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
        AuthenticateSigRequest request = new AuthenticateSigRequest();
        request.setSessionId("xxx");// 必填参数，从前端获取，不可更改，android和ios只传这个参数即可
        request.setSig("xxx");// 必填参数，从前端获取，不可更改
        request.setToken("xxx");// 必填参数，从前端获取，不可更改
        request.setScene("xxx");// 必填参数，从前端获取，不可更改
        request.setAppKey("xxx");// 必填参数，后端填写
        request.setRemoteIp("xxx");// 必填参数，后端填写

        try {
            AuthenticateSigResponse response = client.getAcsResponse(request);
            if (response.getCode() == 100) {
                System.out.println("验签通过");
            } else {
                System.out.println("验签失败");
            }
            // TODO
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


