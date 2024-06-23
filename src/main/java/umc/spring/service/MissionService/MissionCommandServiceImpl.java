package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreIdHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository MissionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.MissionAddDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreIdHandler(ErrorStatus.STORE_ID_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);
        return MissionRepository.save(newMission);
    }
}