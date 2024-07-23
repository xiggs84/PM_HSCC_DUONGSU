package vn.vnpt.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A QuanHeDuongSu.
 */
@Entity
@Table(name = "quan_he_duong_su")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class QuanHeDuongSu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_duong_su")
    private Long idDuongSu;

    @Column(name = "id_duong_su_qh")
    private Long idDuongSuQh;

    @Column(name = "id_quan_he")
    private Long idQuanHe;

    @Column(name = "thong_tin_quan_he")
    private String thongTinQuanHe;

    @Column(name = "trang_thai")
    private Long trangThai;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public QuanHeDuongSu id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDuongSu() {
        return this.idDuongSu;
    }

    public QuanHeDuongSu idDuongSu(Long idDuongSu) {
        this.setIdDuongSu(idDuongSu);
        return this;
    }

    public void setIdDuongSu(Long idDuongSu) {
        this.idDuongSu = idDuongSu;
    }

    public Long getIdDuongSuQh() {
        return this.idDuongSuQh;
    }

    public QuanHeDuongSu idDuongSuQh(Long idDuongSuQh) {
        this.setIdDuongSuQh(idDuongSuQh);
        return this;
    }

    public void setIdDuongSuQh(Long idDuongSuQh) {
        this.idDuongSuQh = idDuongSuQh;
    }

    public Long getIdQuanHe() {
        return this.idQuanHe;
    }

    public QuanHeDuongSu idQuanHe(Long idQuanHe) {
        this.setIdQuanHe(idQuanHe);
        return this;
    }

    public void setIdQuanHe(Long idQuanHe) {
        this.idQuanHe = idQuanHe;
    }

    public String getThongTinQuanHe() {
        return this.thongTinQuanHe;
    }

    public QuanHeDuongSu thongTinQuanHe(String thongTinQuanHe) {
        this.setThongTinQuanHe(thongTinQuanHe);
        return this;
    }

    public void setThongTinQuanHe(String thongTinQuanHe) {
        this.thongTinQuanHe = thongTinQuanHe;
    }

    public Long getTrangThai() {
        return this.trangThai;
    }

    public QuanHeDuongSu trangThai(Long trangThai) {
        this.setTrangThai(trangThai);
        return this;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuanHeDuongSu)) {
            return false;
        }
        return getId() != null && getId().equals(((QuanHeDuongSu) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuanHeDuongSu{" +
            "id=" + getId() +
            ", idDuongSu=" + getIdDuongSu() +
            ", idDuongSuQh=" + getIdDuongSuQh() +
            ", idQuanHe=" + getIdQuanHe() +
            ", thongTinQuanHe='" + getThongTinQuanHe() + "'" +
            ", trangThai=" + getTrangThai() +
            "}";
    }
}
