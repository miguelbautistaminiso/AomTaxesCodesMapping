package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MFR_TAX_CODE", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class MfrTaxCodeEntity {
    private int mfrTaxCodeId;
    private String upc;
    private String sku;
    private String code;
    private String aomTaxId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mfr_tax_code_id")
    public int getMfrTaxCodeId() {
        return mfrTaxCodeId;
    }

    public void setMfrTaxCodeId(int mfrTaxCodeId) {
        this.mfrTaxCodeId = mfrTaxCodeId;
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
        MfrTaxCodeEntity that = (MfrTaxCodeEntity) o;
        return mfrTaxCodeId == that.mfrTaxCodeId &&
                Objects.equals(upc, that.upc) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(code, that.code) &&
                Objects.equals(aomTaxId, that.aomTaxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mfrTaxCodeId, upc, sku, code, aomTaxId);
    }
}
