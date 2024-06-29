package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {


}