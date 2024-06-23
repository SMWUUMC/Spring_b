package umc.spring.service.RegionService;

import umc.spring.domain.Store;
import umc.spring.web.dto.RegionRequestDTO;

public interface RegionCommandService {
    Store joinStore(RegionRequestDTO.AddDto request);
}
