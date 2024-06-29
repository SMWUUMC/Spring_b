package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.MissionProgress;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionService;

    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> challenge(
            @RequestBody MemberMissionRequestDTO.MemberMissionDTO request,
            @PathVariable(name = "memberId") Long memberId,
            @MissionProgress @PathVariable(name = "missionId") Long missionId
    ){
        // UserMission userMission = missionCommandService.createUserMission(userId, missionId, request);
        //
        //        return ApiResponse.onSuccess(MissionConverter.toCreateUserMissionResultDTO(userMission));//
        MemberMission memberMission = memberMissionService.progressMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(memberMission));
    }
}