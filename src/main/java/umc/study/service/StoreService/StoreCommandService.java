package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl {

    private final StoreRepository storeRepository;

    @Transactional
    public Store addStore(StoreRequestDTO request) {
        Store store = new Store(request.getName(), request.getLocation());
        return storeRepository.save(store);
    }
}
