package org.zerock.wcup.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.wcup.domain.Store;
import org.zerock.wcup.dto.StoreDTO;
import org.zerock.wcup.dto.UpdateTokenDTO;
import org.zerock.wcup.repository.StoreRepository;

@Service
@Log4j2
@RequiredArgsConstructor

public class StoreServiceImpl implements  StoreService {

    private final StoreRepository storeRepository;

    private final ModelMapper modelMapper;



    @Override
    public Long register(StoreDTO storeDTO) {

        Store store = modelMapper.map(storeDTO, Store.class);



        storeRepository.save(store);

        return store.getSno();
    }

    @Override
    public void updateToken(UpdateTokenDTO updateTokenDTO) {

            Store store = storeRepository.getOne(updateTokenDTO.getSno());

            store.changeToken(updateTokenDTO.getToken());

            storeRepository.save(store);
    }
}
