package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.web.dto.RegionRequestDTO;
import umc.spring.web.dto.RegionResponseDTO;

import java.time.LocalDateTime;

public class RegionConverter {

    public static RegionResponseDTO.AddResultDTO toAddResultDTO(Store store){
        return RegionResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(RegionRequestDTO.AddDto request){
        
        return Store.builder()
                .address(request.getAddress())
                .score(request.getScore())
                .name(request.getName())
                .build();
    }
}
