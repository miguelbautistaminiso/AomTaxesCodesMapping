package mx.com.miniso.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "UPCS", schema = "dbo", catalog = "AOM_TAXES_CODES_MAPPING")
public class UpcsEntity {
    private int upcId;
    private String upc;
    private Integer taxGroupId;
    private String taxGroup;
    private Timestamp updateDate;
    private Timestamp registerDate;
    private TaxesGroupsEntity taxesGroupsByTaxGroupId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upc_id")
    public int getUpcId() {
        return upcId;
    }

    public void setUpcId(int upcId) {
        this.upcId = upcId;
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
        UpcsEntity that = (UpcsEntity) o;
        return upcId == that.upcId &&
                Objects.equals(upc, that.upc) &&
                Objects.equals(taxGroupId, that.taxGroupId) &&
                Objects.equals(taxGroup, that.taxGroup) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upcId, upc, taxGroupId, taxGroup, updateDate, registerDate);
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
