package com.service;

import com.mapper.TeamMapper;
import com.model.MemberAuthorityModel;
import com.model.Team;
import com.model.TeamMember;
import com.model.TeamMemberInvite;
import com.model.TeamViewModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamMapper teamMapper;

    public int addTeam(Team team) {
        return teamMapper.addTeam(team);
    }

    public int addTeamMember(TeamMember teamMember) {
        return teamMapper.addTeamMember(teamMember);
    }

    public Boolean isContainMember(TeamMember teamMember) {
        return teamMapper.isContainMember(teamMember);
    }

    public int deleteTeamMember(TeamMember teamMember) {
        return teamMapper.deleteTeamMember(teamMember);
    }

    public int addMemberInvite(TeamMemberInvite invite) {

        return teamMapper.addMemberInvite(invite);
    }

    public int cancelInvite(TeamMemberInvite invite) {
        return teamMapper.cancelInvite(invite);
    }

    public Boolean isLinkInvite(String inviteCode) {
        return teamMapper.isLinkInvite(inviteCode);
    }

    public TeamViewModel findMyTeam(String memberId) {
        return teamMapper.findMyTeam(memberId);
    }

    public List<TeamViewModel> findTeamMembers(String teamId) {
        return teamMapper.findTeamMembers(teamId);
    }

    public List<MemberAuthorityModel> findMemberAuth(TeamViewModel teamViewModel) {
        return teamMapper.findMemberAuth(teamViewModel);
    }

}
