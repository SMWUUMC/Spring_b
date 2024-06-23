package umc.spring.service.RegionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.RegionRequestDTO;

    @Service
    @RequiredArgsConstructor
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public class RegionCommandServiceImpl implements RegionCommandService{

        private final RegionRepository regionRepository;

        @Override
        @Transactional
        public Store joinStore(RegionRequestDTO.AddDto request) {

            Store newStore = RegionConverter.toStore(request);

            return regionRepository.save(newStore);
        }
    }