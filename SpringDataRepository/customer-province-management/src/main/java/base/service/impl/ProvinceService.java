package base.service.impl;

import base.model.Province;
import base.repository.IProvinceRepository;
import base.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;
    @Override
    public Iterable<Province> findAll(){
        return iProvinceRepository.findAll();
    }
    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }
    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }
    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
