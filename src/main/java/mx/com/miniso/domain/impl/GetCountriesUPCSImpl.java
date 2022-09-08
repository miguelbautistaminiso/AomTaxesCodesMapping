package mx.com.miniso.domain.impl;

import mx.com.miniso.domain.GetCountriesUPCS;
import mx.com.miniso.jpa.hana.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value = "getCountriesUPCS")
public class GetCountriesUPCSImpl implements GetCountriesUPCS{

    @Autowired
    private HanaDbMex hanaDbMex;

    @Autowired
    private HanaDbMfr hanaDbMfr;

    @Autowired
    private HanaDbPer hanaDbPer;

    @Autowired
    private HanaDbCol hanaDbCol;

    @Autowired
    private HanaDbChl hanaDbChl;

    public void getUpcs(){
        hanaDbMex.getMexUpcs();
        hanaDbMfr.getMfrUpcs();
        hanaDbPer.getPerUpcs();
        hanaDbCol.getColUpcs();
        hanaDbChl.getChlUpcs();
    }

}
