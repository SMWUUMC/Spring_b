package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RegionConverter;
import umc.spring.domain.Store;
import umc.spring.service.RegionService.RegionCommandService;
import umc.spring.web.dto.RegionRequestDTO;
import umc.spring.web.dto.RegionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {
    private final RegionCommandService regionCommandService;

    @PostMapping("/{region-id}/stores")
    public ApiResponse<RegionResponseDTO.AddResultDTO> join(@RequestBody @Valid RegionRequestDTO.AddDto request){
        Store store  = regionCommandService.joinStore(request);
        return ApiResponse.onSuccess(RegionConverter.toAddResultDTO(store));
    }
}
