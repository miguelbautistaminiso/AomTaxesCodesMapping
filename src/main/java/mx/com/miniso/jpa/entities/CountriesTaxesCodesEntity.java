package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "COUNTRIES_TAXES_CODES", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class CountriesTaxesCodesEntity {
    private int countryTaxCodeId;
    private String aomTaxId;
    private String country;
    private String sapTaxCode;
    private BigDecimal value;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_tax_code_id")
    public int getCountryTaxCodeId() {
        return countryTaxCodeId;
    }

    public void setCountryTaxCodeId(int countryTaxCodeId) {
        this.countryTaxCodeId = countryTaxCodeId;
    }

    @Basic
    @Column(name = "aom_tax_id")
    public String getAomTaxId() {
        return aomTaxId;
    }

    public void setAomTaxId(String aomTaxId) {
        this.aomTaxId = aomTaxId;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "sap_tax_code")
    public String getSapTaxCode() {
        return sapTaxCode;
    }

    public void setSapTaxCode(String sapTaxCode) {
        this.sapTaxCode = sapTaxCode;
    }

    @Basic
    @Column(name = "value")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesTaxesCodesEntity that = (CountriesTaxesCodesEntity) o;
        return countryTaxCodeId == that.countryTaxCodeId &&
                Objects.equals(aomTaxId, that.aomTaxId) &&
                Objects.equals(country, that.country) &&
                Objects.equals(sapTaxCode, that.sapTaxCode) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryTaxCodeId, aomTaxId, country, sapTaxCode, value);
    }
}
