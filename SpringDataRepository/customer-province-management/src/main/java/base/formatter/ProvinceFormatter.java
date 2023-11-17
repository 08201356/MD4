package base.formatter;

import base.model.Province;
import base.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    public final IProvinceService iProvinceService;
    @Autowired
    public ProvinceFormatter(IProvinceService provinceService){
        this.iProvinceService = provinceService;
    }
    @Override
    public Province parse(String text, Locale locale){
        Optional<Province> provinceOptional = iProvinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }
    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
