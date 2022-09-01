package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SKUS", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class SkusEntity {
    private int skuId;
    private String sku;
    private Integer taxGroupId;
    private String taxGroup;
    private Timestamp updateDate;
    private Timestamp registerDate;
    private TaxesGroupsEntity taxesGroupsByTaxGroupId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
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
    @Column(name = "tax_group_id")
    public Integer getTaxGroupId() {
        return taxGroupId;
    }

    public void setTaxGroupId(Integer taxGroupId) {
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
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "register_date")
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkusEntity that = (SkusEntity) o;
        return skuId == that.skuId &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(taxGroupId, that.taxGroupId) &&
                Objects.equals(taxGroup, that.taxGroup) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, sku, taxGroupId, taxGroup, updateDate, registerDate);
    }

    @ManyToOne
    @JoinColumn(name = "tax_group_id", referencedColumnName = "tax_group_id", insertable = false, updatable = false)
    public TaxesGroupsEntity getTaxesGroupsByTaxGroupId() {
        return taxesGroupsByTaxGroupId;
    }

    public void setTaxesGroupsByTaxGroupId(TaxesGroupsEntity taxesGroupsByTaxGroupId) {
        this.taxesGroupsByTaxGroupId = taxesGroupsByTaxGroupId;
    }
}
