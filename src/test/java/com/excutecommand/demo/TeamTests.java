package com.excutecommand.demo;

import com.model.MemberAuthorityModel;
import com.model.Team;
import com.model.TeamMember;
import com.model.TeamMemberInvite;
import com.model.TeamViewModel;
import com.service.MemberService;
import com.service.TeamService;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.lang3.text.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TeamService teamService;

    @Test
    public void contextLoads() {

//     String str=   RandomStringUtils.randomAlphanumeric(12);
//
//
//
//
////        Team team =new Team();
////        team.setId(UUID.randomUUID().toString());
////        team.setTeamName("巅峰娱乐城");
////        team.setCreator(UUID.randomUUID().toString());
////        team.setCreateTime(new Date());
////        team.setUpdateTime(null);
////        team.setStatus(1);
////        int obj = teamService.addTeam(team);
//
//
//        TeamMember teamMember =new TeamMember();
//        teamMember.setId("2e63ba75-7e55-408d-8e41-7d4ccb1d7351");
//        teamMember.setTeamName("李逵");
//        teamMember.setMemberId("222ef3b8-9525-4f97-aa6e-081efb66df43");
//        teamMember.setStatus(1);
//        teamMember.setJoinTime(new Date());
//        //Boolean obj = teamService.isContainMember(teamMember);
//
//        //int obj1 = teamService.deleteTeamMember(teamMember);
//
//        LocalDateTime createTime = LocalDateTime.now();
//        LocalDateTime invalidTime = createTime.plusDays(1);
//
//
//        TeamMemberInvite invite=new TeamMemberInvite();
//        invite.setId(UUID.randomUUID().toString());
//        invite.setMemberId("222ef3b8-9525-4f97-aa6e-081efb66df43");
//        invite.setTeamId("1");
//        invite.setInviteCode("78956");
//        invite.setStatus(1);
//        invite.setCreateTime(createTime.toDate());
//        invite.setInvalidTime(invalidTime.toDate());
//        Boolean obj3 = teamService.isLinkInvite("78956");

        TeamViewModel teamViewModel = new TeamViewModel();
        teamViewModel.setTeamId("1");
        teamViewModel.setMemberId("1");
        List<MemberAuthorityModel> obj = teamService.findMemberAuth(teamViewModel);


        System.err.print(obj);
    }

}

