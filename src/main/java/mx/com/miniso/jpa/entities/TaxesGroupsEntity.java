package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TAXES_GROUPS", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class TaxesGroupsEntity {
    private int taxGroupId;
    private String taxGroup;
    private String colTax;
    private String chlTax;
    private String perTax;
    private String mexTax;
    private String mfrTax;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_group_id")
    public int getTaxGroupId() {
        return taxGroupId;
    }

    public void setTaxGroupId(int taxGroupId) {
        this.taxGroupId = taxGroupId;
    }

    @Basic
    @Column(name = "tax_group")
    public String getTaxGroup() {
        return taxGroup;
    }

    public void setTaxGroup(String taxGroup) {
        this.taxGroup = taxGroup;
    }

    @Basic
    @Column(name = "col_tax")
    public String getColTax() {
        return colTax;
    }

    public void setColTax(String colTax) {
        this.colTax = colTax;
    }

    @Basic
    @Column(name = "chl_tax")
    public String getChlTax() {
        return chlTax;
    }

    public void setChlTax(String chlTax) {
        this.chlTax = chlTax;
    }

    @Basic
    @Column(name = "per_tax")
    public String getPerTax() {
        return perTax;
    }

    public void setPerTax(String perTax) {
        this.perTax = perTax;
    }

    @Basic
    @Column(name = "mex_tax")
    public String getMexTax() {
        return mexTax;
    }

    public void setMexTax(String mexTax) {
        this.mexTax = mexTax;
    }

    @Basic
    @Column(name = "mfr_tax")
    public String getMfrTax() {
        return mfrTax;
    }

    public void setMfrTax(String mfrTax) {
        this.mfrTax = mfrTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxesGroupsEntity that = (TaxesGroupsEntity) o;
        return taxGroupId == that.taxGroupId &&
                Objects.equals(taxGroup, that.taxGroup) &&
                Objects.equals(colTax, that.colTax) &&
                Objects.equals(chlTax, that.chlTax) &&
                Objects.equals(perTax, that.perTax) &&
                Objects.equals(mexTax, that.mexTax) &&
                Objects.equals(mfrTax, that.mfrTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxGroupId, taxGroup, colTax, chlTax, perTax, mexTax, mfrTax);
    }
}
