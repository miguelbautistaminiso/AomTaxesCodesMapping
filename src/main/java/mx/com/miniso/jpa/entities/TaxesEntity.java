package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TAXES", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class TaxesEntity {
    private int taxId;
    private String upc;
    private String sku;
    private String chlIva19;
    private String chlIva00;
    private String perIgv18;
    private String perIgv00;
    private String perIgvIcbper18;
    private String colIvag0119;
    private String colIvaexe0;
    private String colIvaexc0;
    private String colImpocon9;
    private String colImpocon00;
    private String mexV1616;
    private String mexV00;
    private String mexV0188;
    private String mexV16I8168;
    private String mfrV168;
    private String mfrV00;
    private String mfrV0I88;
    private String mfrV16I888;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
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
    @Column(name = "chl_iva_19")
    public String getChlIva19() {
        return chlIva19;
    }

    public void setChlIva19(String chlIva19) {
        this.chlIva19 = chlIva19;
    }

    @Basic
    @Column(name = "chl_iva0_0")
    public String getChlIva00() {
        return chlIva00;
    }

    public void setChlIva00(String chlIva00) {
        this.chlIva00 = chlIva00;
    }

    @Basic
    @Column(name = "per_igv_18")
    public String getPerIgv18() {
        return perIgv18;
    }

    public void setPerIgv18(String perIgv18) {
        this.perIgv18 = perIgv18;
    }

    @Basic
    @Column(name = "per_igv0_0")
    public String getPerIgv00() {
        return perIgv00;
    }

    public void setPerIgv00(String perIgv00) {
        this.perIgv00 = perIgv00;
    }

    @Basic
    @Column(name = "per_igv_icbper_18")
    public String getPerIgvIcbper18() {
        return perIgvIcbper18;
    }

    public void setPerIgvIcbper18(String perIgvIcbper18) {
        this.perIgvIcbper18 = perIgvIcbper18;
    }

    @Basic
    @Column(name = "col_ivag01_19")
    public String getColIvag0119() {
        return colIvag0119;
    }

    public void setColIvag0119(String colIvag0119) {
        this.colIvag0119 = colIvag0119;
    }

    @Basic
    @Column(name = "col_ivaexe_0")
    public String getColIvaexe0() {
        return colIvaexe0;
    }

    public void setColIvaexe0(String colIvaexe0) {
        this.colIvaexe0 = colIvaexe0;
    }

    @Basic
    @Column(name = "col_ivaexc_0")
    public String getColIvaexc0() {
        return colIvaexc0;
    }

    public void setColIvaexc0(String colIvaexc0) {
        this.colIvaexc0 = colIvaexc0;
    }

    @Basic
    @Column(name = "col_impocon_9")
    public String getColImpocon9() {
        return colImpocon9;
    }

    public void setColImpocon9(String colImpocon9) {
        this.colImpocon9 = colImpocon9;
    }

    @Basic
    @Column(name = "col_impocon0_0")
    public String getColImpocon00() {
        return colImpocon00;
    }

    public void setColImpocon00(String colImpocon00) {
        this.colImpocon00 = colImpocon00;
    }

    @Basic
    @Column(name = "mex_v16_16")
    public String getMexV1616() {
        return mexV1616;
    }

    public void setMexV1616(String mexV1616) {
        this.mexV1616 = mexV1616;
    }

    @Basic
    @Column(name = "mex_v0_0")
    public String getMexV00() {
        return mexV00;
    }

    public void setMexV00(String mexV00) {
        this.mexV00 = mexV00;
    }

    @Basic
    @Column(name = "mex_v018_8")
    public String getMexV0188() {
        return mexV0188;
    }

    public void setMexV0188(String mexV0188) {
        this.mexV0188 = mexV0188;
    }

    @Basic
    @Column(name = "mex_v16i8_168")
    public String getMexV16I8168() {
        return mexV16I8168;
    }

    public void setMexV16I8168(String mexV16I8168) {
        this.mexV16I8168 = mexV16I8168;
    }

    @Basic
    @Column(name = "mfr_v16_8")
    public String getMfrV168() {
        return mfrV168;
    }

    public void setMfrV168(String mfrV168) {
        this.mfrV168 = mfrV168;
    }

    @Basic
    @Column(name = "mfr_v0_0")
    public String getMfrV00() {
        return mfrV00;
    }

    public void setMfrV00(String mfrV00) {
        this.mfrV00 = mfrV00;
    }

    @Basic
    @Column(name = "mfr_v0i8_8")
    public String getMfrV0I88() {
        return mfrV0I88;
    }

    public void setMfrV0I88(String mfrV0I88) {
        this.mfrV0I88 = mfrV0I88;
    }

    @Basic
    @Column(name = "mfr_v16i8_88")
    public String getMfrV16I888() {
        return mfrV16I888;
    }

    public void setMfrV16I888(String mfrV16I888) {
        this.mfrV16I888 = mfrV16I888;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxesEntity that = (TaxesEntity) o;
        return taxId == that.taxId &&
                Objects.equals(upc, that.upc) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(chlIva19, that.chlIva19) &&
                Objects.equals(chlIva00, that.chlIva00) &&
                Objects.equals(perIgv18, that.perIgv18) &&
                Objects.equals(perIgv00, that.perIgv00) &&
                Objects.equals(perIgvIcbper18, that.perIgvIcbper18) &&
                Objects.equals(colIvag0119, that.colIvag0119) &&
                Objects.equals(colIvaexe0, that.colIvaexe0) &&
                Objects.equals(colIvaexc0, that.colIvaexc0) &&
                Objects.equals(colImpocon9, that.colImpocon9) &&
                Objects.equals(colImpocon00, that.colImpocon00) &&
                Objects.equals(mexV1616, that.mexV1616) &&
                Objects.equals(mexV00, that.mexV00) &&
                Objects.equals(mexV0188, that.mexV0188) &&
                Objects.equals(mexV16I8168, that.mexV16I8168) &&
                Objects.equals(mfrV168, that.mfrV168) &&
                Objects.equals(mfrV00, that.mfrV00) &&
                Objects.equals(mfrV0I88, that.mfrV0I88) &&
                Objects.equals(mfrV16I888, that.mfrV16I888);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxId, upc, sku, chlIva19, chlIva00, perIgv18, perIgv00, perIgvIcbper18, colIvag0119, colIvaexe0, colIvaexc0, colImpocon9, colImpocon00, mexV1616, mexV00, mexV0188, mexV16I8168, mfrV168, mfrV00, mfrV0I88, mfrV16I888);
    }
}
