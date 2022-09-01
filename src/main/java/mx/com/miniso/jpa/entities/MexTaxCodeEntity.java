package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEX_TAX_CODE", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class MexTaxCodeEntity {
    private int mexTaxCodeId;
    private String upc;
    private String sku;
    private String code;
    private String aomTaxId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mex_tax_code_id")
    public int getMexTaxCodeId() {
        return mexTaxCodeId;
    }

    public void setMexTaxCodeId(int mexTaxCodeId) {
        this.mexTaxCodeId = mexTaxCodeId;
    }

    @Basic
    @Column(name = "upc")
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Basic
    @Column(name = "sku")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "aom_tax_id")
    public String getAomTaxId() {
        return aomTaxId;
    }

    public void setAomTaxId(String aomTaxId) {
        this.aomTaxId = aomTaxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MexTaxCodeEntity that = (MexTaxCodeEntity) o;
        return mexTaxCodeId == that.mexTaxCodeId &&
                Objects.equals(upc, that.upc) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(code, that.code) &&
                Objects.equals(aomTaxId, that.aomTaxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mexTaxCodeId, upc, sku, code, aomTaxId);
    }
}
