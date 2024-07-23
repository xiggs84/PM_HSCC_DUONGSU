package vn.vnpt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DanhMucLoaiDuongSu.
 */
@Entity
@Table(name = "danh_muc_loai_duong_su")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanhMucLoaiDuongSu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_loai_ds")
    private Long idLoaiDs;

    @Column(name = "dien_giai")
    private String dienGiai;

    @Column(name = "trang_thai")
    private Long trangThai;

    @Column(name = "str_search")
    private String strSearch;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idLoaiDs")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "idLoaiDs" }, allowSetters = true)
    private Set<DuongSu> duongSus = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DanhMucLoaiDuongSu id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLoaiDs() {
        return this.idLoaiDs;
    }

    public DanhMucLoaiDuongSu idLoaiDs(Long idLoaiDs) {
        this.setIdLoaiDs(idLoaiDs);
        return this;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
    }

    public String getDienGiai() {
        return this.dienGiai;
    }

    public DanhMucLoaiDuongSu dienGiai(String dienGiai) {
        this.setDienGiai(dienGiai);
        return this;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public Long getTrangThai() {
        return this.trangThai;
    }

    public DanhMucLoaiDuongSu trangThai(Long trangThai) {
        this.setTrangThai(trangThai);
        return this;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    public String getStrSearch() {
        return this.strSearch;
    }

    public DanhMucLoaiDuongSu strSearch(String strSearch) {
        this.setStrSearch(strSearch);
        return this;
    }

    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    public Set<DuongSu> getDuongSus() {
        return this.duongSus;
    }

    public void setDuongSus(Set<DuongSu> duongSus) {
        if (this.duongSus != null) {
            this.duongSus.forEach(i -> i.setIdLoaiDs(null));
        }
        if (duongSus != null) {
            duongSus.forEach(i -> i.setIdLoaiDs(this));
        }
        this.duongSus = duongSus;
    }

    public DanhMucLoaiDuongSu duongSus(Set<DuongSu> duongSus) {
        this.setDuongSus(duongSus);
        return this;
    }

    public DanhMucLoaiDuongSu addDuongSu(DuongSu duongSu) {
        this.duongSus.add(duongSu);
        duongSu.setIdLoaiDs(this);
        return this;
    }

    public DanhMucLoaiDuongSu removeDuongSu(DuongSu duongSu) {
        this.duongSus.remove(duongSu);
        duongSu.setIdLoaiDs(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DanhMucLoaiDuongSu)) {
            return false;
        }
        return getId() != null && getId().equals(((DanhMucLoaiDuongSu) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanhMucLoaiDuongSu{" +
            "id=" + getId() +
            ", idLoaiDs=" + getIdLoaiDs() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", trangThai=" + getTrangThai() +
            ", strSearch='" + getStrSearch() + "'" +
            "}";
    }
}
