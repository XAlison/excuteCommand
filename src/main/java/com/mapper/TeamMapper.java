package com.mapper;


import com.model.MemberAuthorityModel;
import com.model.Team;
import com.model.TeamMember;
import com.model.TeamMemberInvite;
import com.model.TeamViewModel;
import java.util.List;

public interface TeamMapper {

    /**
     * 添加团队
     */
    int addTeam(Team team);

    /**
     * 添加团队成员
     */
    int addTeamMember(TeamMember teamMember);

    /**
     * 删除团队成员
     */
    int deleteTeamMember(TeamMember teamMember);

    /**
     * 是否存在当前成员
     */
    Boolean isContainMember(TeamMember teamMember);

    /**
     * 获取我的团队
     */
    TeamViewModel findMyTeam(String memberId);

    /**
     * 获取我的团队成员权限列表
     */
    List<MemberAuthorityModel> findMemberAuth(TeamViewModel teamViewModel);

    /**
     * 获取团队成员
     */
    List<TeamViewModel> findTeamMembers(String memberId);

    /**
     * 添加团队邀请
     */
    int addMemberInvite(TeamMemberInvite invite);

    /**
     * 取消团队邀请
     */
    int cancelInvite(TeamMemberInvite invite);

    /**
     * 邀请链接是否有效
     */
    Boolean isLinkInvite(String inviteCode);
}