package com.project.demo.service;

import com.project.demo.persitance.dto.PromoCodeDto;
import com.project.demo.persitance.model.PromoCode;
import com.project.demo.repository.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PromoCodeService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    public List<PromoCodeDto> getAll(){
        List<PromoCode> promoCodes = promoCodeRepository.findAll();
        List<PromoCodeDto> promoCodeDtos = new ArrayList<>();
        for (PromoCode promoCode: promoCodes){
            PromoCodeDto promoCodeDto = new PromoCodeDto();
            promoCodeDto.setId(promoCode.getId());
            promoCodeDto.setCode(promoCode.getCode());
            promoCodeDto.setPromoNumber(promoCode.getPromoNumber());
            promoCodeDtos.add(promoCodeDto);
        }
        return promoCodeDtos;
    }

    public void add(PromoCodeDto promoCodeDto){
        PromoCode promoCode = new PromoCode();
        promoCode.setCode(promoCodeDto.getCode());
        promoCode.setPromoNumber(promoCodeDto.getPromoNumber());
        if (ifCodeExist(promoCode)) {
            promoCodeRepository.save(promoCode);
        }
    }

    public PromoCodeDto getPromoCode(long id){
        PromoCode promoCode  = promoCodeRepository.findById(id).orElse(null);
        PromoCodeDto promoCodeDto = new PromoCodeDto();
        promoCodeDto.setId(promoCode.getId());
        promoCodeDto.setCode(promoCode.getCode());
        promoCodeDto.setPromoNumber(promoCode.getPromoNumber());

        return promoCodeDto;
    }

    public void delete(long id){
        promoCodeRepository.deleteById(id);
    }

    public void update(PromoCodeDto promoCodeDto) {
        PromoCode promoCode = promoCodeRepository.findById(promoCodeDto.getId()).orElse(null);
        List<PromoCode> promoCodes = promoCodeRepository.findAll();
        promoCode.setCode(promoCodeDto.getCode());
        promoCode.setPromoNumber(promoCodeDto.getPromoNumber());

        if (ifCodeExist(promoCode)) {
            promoCodeRepository.save(promoCode);
        }
    }

    private boolean ifCodeExist(PromoCode promoCode){
        List<PromoCode> promoCodes = promoCodeRepository.findAll();
        for (PromoCode promoCode1: promoCodes){
           if (promoCode.getCode().equals(promoCode1.getCode())){
             return false;
            }
        }
        return true;
    }

    public PromoCodeDto getPromoCodeByCode(String code){
        PromoCode promoCode  = promoCodeRepository.getByCode(code).orElse(null);
        PromoCodeDto promoCodeDto = new PromoCodeDto();
        assert promoCode != null;
        promoCodeDto.setId(promoCode.getId());
        promoCodeDto.setCode(promoCode.getCode());
        promoCodeDto.setPromoNumber(promoCode.getPromoNumber());

        return promoCodeDto;
    }
}
