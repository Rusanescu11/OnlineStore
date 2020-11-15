package com.project.demo.controller;

import com.project.demo.persitance.dto.PromoCodeDto;
import com.project.demo.service.PromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PromoCodeController {

    @Autowired
    private PromoCodeService promoCodeService;

    @PostMapping("/promo")
    public void add(@RequestBody PromoCodeDto promoCodeDto) {
        promoCodeService.add(promoCodeDto);
    }
    @DeleteMapping("/promo/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        promoCodeService.delete(id);
    }
    @GetMapping("/promo")
    public List<PromoCodeDto> getAll() {
        return promoCodeService.getAll();
    }

    @GetMapping("/promo/{id}")
    public PromoCodeDto get(@PathVariable(name = "id") Long id) {
        return promoCodeService.getPromoCode(id);
    }

    @PutMapping("/promo")
    public void update(@RequestBody PromoCodeDto promoCodeDto) {
        promoCodeService.update(promoCodeDto);
    }

    @GetMapping("/promos/{code}")
    public PromoCodeDto get(@PathVariable(name = "code") String code) {
        return promoCodeService.getPromoCodeByCode(code);
    }
}
