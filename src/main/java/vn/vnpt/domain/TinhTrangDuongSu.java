package vn.vnpt.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TinhTrangDuongSu.
 */
@Entity
@Table(name = "tinh_trang_duong_su")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TinhTrangDuongSu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_tinh_trang")
    private Long idTinhTrang;

    @Column(name = "dien_giai")
    private String dienGiai;

    @Column(name = "id_loai_ds")
    private Long idLoaiDs;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public TinhTrangDuongSu id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTinhTrang() {
        return this.idTinhTrang;
    }

    public TinhTrangDuongSu idTinhTrang(Long idTinhTrang) {
        this.setIdTinhTrang(idTinhTrang);
        return this;
    }

    public void setIdTinhTrang(Long idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public String getDienGiai() {
        return this.dienGiai;
    }

    public TinhTrangDuongSu dienGiai(String dienGiai) {
        this.setDienGiai(dienGiai);
        return this;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public Long getIdLoaiDs() {
        return this.idLoaiDs;
    }

    public TinhTrangDuongSu idLoaiDs(Long idLoaiDs) {
        this.setIdLoaiDs(idLoaiDs);
        return this;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TinhTrangDuongSu)) {
            return false;
        }
        return getId() != null && getId().equals(((TinhTrangDuongSu) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TinhTrangDuongSu{" +
            "id=" + getId() +
            ", idTinhTrang=" + getIdTinhTrang() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", idLoaiDs=" + getIdLoaiDs() +
            "}";
    }
}
