package mx.com.miniso.domain.impl;

import mx.com.miniso.domain.MailService;
import mx.com.miniso.domain.UpdateTaxesCodes;
import mx.com.miniso.jpa.entities.*;
import mx.com.miniso.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;


@Component(value = "uptadeTaxesCodes")
public class UpdateTaxesCodesImpl implements UpdateTaxesCodes {

    protected Logger log = Logger.getLogger(UpdateTaxesCodesImpl.class.getName());

    @Autowired
    private UpcsRepository upcsRepository;

    @Autowired
    private TaxesRepository taxesRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private ChlTaxCodeRepository chlTaxCodeRepository;

    @Autowired
    private ColTaxCodeRepository colTaxCodeRepository;

    @Autowired
    private MexTaxCodeRepository mexTaxCodeRepository;

    @Autowired
    private MfrTaxCodeRepository mfrTaxCodeRepository;

    @Autowired
    private PerTaxCodeRepository perTaxCodeRepository;

    @Autowired
    private CountriesTaxesCodesRepository countriesTaxesCodesRepository;

    @Autowired
    private TaxesGroupsRepository taxesGroupsRepository;

    @Override
    public void updateAomId() {

        updatesChl();
        updatesCol();
        updatesMex();
        updatesMfr();
        updatesPer();

    }

    @Override
    public void updateTaxesGroupsId() {

        updateTaxGroupId();

    }

    @Override
    public void validateAomTaxesCodes() {

        ArrayList<ChlTaxCodeEntity> chlArrayList = chlTaxCodeRepository.findAllByAomTaxIdIsNull();
        ArrayList<ColTaxCodeEntity> colArrayList = colTaxCodeRepository.findAllByAomTaxIdIsNull();
        ArrayList<MexTaxCodeEntity> mexArrayList = mexTaxCodeRepository.findAllByAomTaxIdIsNull();
        ArrayList<MfrTaxCodeEntity> mfrArrayList = mfrTaxCodeRepository.findAllByAomTaxIdIsNull();
        ArrayList<PerTaxCodeEntity> perArayList = perTaxCodeRepository.findAllByAomTaxIdIsNull();

        if(chlArrayList.size() > 0 || colArrayList.size() > 0 || mexArrayList.size() > 0 || mfrArrayList.size()>0 || perArayList.size()>0){
            try {
                mailService.sendMail();
            }catch (Exception e){
                log.info(e.getMessage());
            }
        }

    }

    private void updatesChl() {

        ArrayList<CountriesTaxesCodesEntity> chlCountryList = countriesTaxesCodesRepository.findAllByCountry("CHL");

        chlCountryList.forEach(chl -> {

            log.info("Actualizando: " + chl + " " + chl.getSapTaxCode() + " " + chl.getAomTaxId());
            chlTaxCodeRepository.updateAomTaxId(chl.getAomTaxId(), chl.getSapTaxCode());
        });


        /*
        ArrayList<ChlTaxCodeEntity> chlList = chlTaxCodeRepository.findAll();

        chlList.forEach(chl -> {

//            AtomicReference<ChlTaxCodeEntity> updated = chl.get();
            chlCountryList.forEach(chlc -> {
                if (chlc.getSapTaxCode().equals(chl.getCode())) {
                    chl.setAomTaxId(chlc.getAomTaxId());
                    chlTaxCodeRepository.save(chl);
                    return;
                }

                switch (chl.getCode()) {
                    case "IVA":
                        log.info(chl.getUpc() + " " +chl.getAomTaxId() );
                        taxesRepository.updateChlIva19(chl.getAomTaxId(), chl.getUpc() );
                        break;
                    case "IVA0":
                        log.info(chl.getUpc() + " " +chl.getAomTaxId() );
                        taxesRepository.updateChlIva0(chl.getAomTaxId(), chl.getUpc() );
                        break;
                }

            });


        });

         */
    }

    private void updatesCol() {

        ArrayList<CountriesTaxesCodesEntity> colCountryList = countriesTaxesCodesRepository.findAllByCountry("COL");


        colCountryList.forEach(col -> {

            log.info("Actualizando: " + col.getSapTaxCode() + " " + col.getAomTaxId());
            colTaxCodeRepository.updateAomTaxId(col.getAomTaxId(), col.getSapTaxCode());
        });

/*
        ArrayList<ColTaxCodeEntity> colList = colTaxCodeRepository.findAll();

        colList.forEach(col -> {

            colCountryList.forEach(colc -> {
                if (colc.getSapTaxCode().equals(col.getCode())) {
                    col.setAomTaxId(colc.getAomTaxId());
                    colTaxCodeRepository.save(col);
                    return;
                }
            });

            switch (col.getCode()) {
                case "IVAG01":
                    taxesRepository.updateColIvag0119(col.getAomTaxId(), col.getUpc());
                    break;
                case "IVA_EXE":
                    taxesRepository.updateColIvaexe0(col.getAomTaxId(), col.getUpc());
                    break;
                case "IVA_EXC":
                    taxesRepository.updateColIvaexc0(col.getAomTaxId(), col.getUpc());
                    break;
                case "IMPOCON":
                    taxesRepository.updateColImpocon9(col.getAomTaxId(), col.getUpc());
                    break;
                case "IMPOCON0":
                    taxesRepository.updateColImpocon00(col.getAomTaxId(), col.getUpc());
                    break;
            }
        });

 */
    }

    private void updatesMex() {

        ArrayList<CountriesTaxesCodesEntity> mexCountryList = countriesTaxesCodesRepository.findAllByCountry("MEX");


        mexCountryList.forEach(mex -> {

            log.info("Actualizando: " + mex.getSapTaxCode() + " " + mex.getAomTaxId());
            mexTaxCodeRepository.updateAomTaxId(mex.getAomTaxId(), mex.getSapTaxCode());
        });


        /*
        ArrayList<MexTaxCodeEntity> mexList = mexTaxCodeRepository.findAll();

        mexList.forEach(mex -> {

            mexCountryList.forEach(mexc -> {
                if (mexc.getSapTaxCode().equals(mex.getCode())) {
                    mex.setAomTaxId(mexc.getAomTaxId());
                    mexTaxCodeRepository.save(mex);
                    return;
                }
            });

            switch (mex.getCode()) {
                case "V16":
                    taxesRepository.updateMexV1616(mex.getAomTaxId(), mex.getUpc());
                    break;
                case "V0":
                    taxesRepository.updateMexV00(mex.getAomTaxId(), mex.getUpc());
                    break;
                case "V0I8":
                    taxesRepository.updateMexV0188(mex.getAomTaxId(), mex.getUpc());
                    break;
                case "V16I8":
                    taxesRepository.updateMexV16I8168(mex.getAomTaxId(), mex.getUpc());
                    break;
            }
        });

         */
    }

    private void updatesMfr() {

        ArrayList<CountriesTaxesCodesEntity> mfrCountryList = countriesTaxesCodesRepository.findAllByCountry("MFR");

        mfrCountryList.forEach(mfr -> {

            log.info("Actualizando: " + mfr.getSapTaxCode() + " " + mfr.getAomTaxId());
            mfrTaxCodeRepository.updateAomTaxId(mfr.getAomTaxId(), mfr.getSapTaxCode());
        });


        /*
        ArrayList<MfrTaxCodeEntity> mfrList = mfrTaxCodeRepository.findAll();

        mfrList.forEach(mfr -> {

            mfrCountryList.forEach(mfrc -> {
                if (mfrc.getSapTaxCode().equals(mfr.getCode())) {
                    mfr.setAomTaxId(mfrc.getAomTaxId());
                    mfrTaxCodeRepository.save(mfr);
                    return;
                }
            });

            switch (mfr.getCode()) {
                case "V16":
                    taxesRepository.updateMfrV168(mfr.getAomTaxId(), mfr.getUpc());
                    break;
                case "V0":
                    taxesRepository.updateMfrV00(mfr.getAomTaxId(), mfr.getUpc());
                    break;
                case "V0I8":
                    taxesRepository.updateMfrV0I88(mfr.getAomTaxId(), mfr.getUpc());
                    break;
                case "V16I8":
                    taxesRepository.updateMfrV16I888(mfr.getAomTaxId(), mfr.getUpc());
                    break;
            }
        });

         */
    }

    private void updatesPer() {

        ArrayList<CountriesTaxesCodesEntity> perCountryList = countriesTaxesCodesRepository.findAllByCountry("PER");

        perCountryList.forEach(per -> {

            log.info("Actualizando: " + per.getSapTaxCode() + " " + per.getAomTaxId());
            perTaxCodeRepository.updateAomTaxId(per.getAomTaxId(), per.getSapTaxCode());
        });


        /*
        ArrayList<PerTaxCodeEntity> perList = perTaxCodeRepository.findAll();

        perList.forEach(per -> {

            perCountryList.forEach(perc -> {
                if (perc.getSapTaxCode().equals(per.getCode())) {
                    per.setAomTaxId(perc.getAomTaxId());
                    perTaxCodeRepository.save(per);
                    return;
                }
            });
            switch (per.getCode()) {
                case "IGV":
                    taxesRepository.updatePerIgv18(per.getAomTaxId(), per.getUpc());
                    break;
                case "IGV0":
                    taxesRepository.updatePerIgv00(per.getAomTaxId(), per.getUpc());
                    break;
                case "IGV_ICBPER":
                    taxesRepository.updatePerIgvIcbper18(per.getAomTaxId(), per.getUpc());
                    break;
            }
        });*/

    }

    private void updateTaxGroupId() {

        taxesGroupsRepository.findAll().forEach(tg -> {

            upcsRepository.updateTaxGroupId(tg.getTaxGroupId(), tg.getTaxGroup());

        });

    }




}
