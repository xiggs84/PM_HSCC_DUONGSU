package vn.vnpt.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A QuanHeNhanThan.
 */
@Entity
@Table(name = "quan_he_nhan_than")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class QuanHeNhanThan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_quan_he")
    private Long idQuanHe;

    @Column(name = "dien_giai")
    private String dienGiai;

    @Column(name = "id_quan_he_doi_ung")
    private Long idQuanHeDoiUng;

    @Column(name = "id_gioi_tinh")
    private Long idGioiTinh;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public QuanHeNhanThan id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdQuanHe() {
        return this.idQuanHe;
    }

    public QuanHeNhanThan idQuanHe(Long idQuanHe) {
        this.setIdQuanHe(idQuanHe);
        return this;
    }

    public void setIdQuanHe(Long idQuanHe) {
        this.idQuanHe = idQuanHe;
    }

    public String getDienGiai() {
        return this.dienGiai;
    }

    public QuanHeNhanThan dienGiai(String dienGiai) {
        this.setDienGiai(dienGiai);
        return this;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public Long getIdQuanHeDoiUng() {
        return this.idQuanHeDoiUng;
    }

    public QuanHeNhanThan idQuanHeDoiUng(Long idQuanHeDoiUng) {
        this.setIdQuanHeDoiUng(idQuanHeDoiUng);
        return this;
    }

    public void setIdQuanHeDoiUng(Long idQuanHeDoiUng) {
        this.idQuanHeDoiUng = idQuanHeDoiUng;
    }

    public Long getIdGioiTinh() {
        return this.idGioiTinh;
    }

    public QuanHeNhanThan idGioiTinh(Long idGioiTinh) {
        this.setIdGioiTinh(idGioiTinh);
        return this;
    }

    public void setIdGioiTinh(Long idGioiTinh) {
        this.idGioiTinh = idGioiTinh;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuanHeNhanThan)) {
            return false;
        }
        return getId() != null && getId().equals(((QuanHeNhanThan) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuanHeNhanThan{" +
            "id=" + getId() +
            ", idQuanHe=" + getIdQuanHe() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", idQuanHeDoiUng=" + getIdQuanHeDoiUng() +
            ", idGioiTinh=" + getIdGioiTinh() +
            "}";
    }
}
