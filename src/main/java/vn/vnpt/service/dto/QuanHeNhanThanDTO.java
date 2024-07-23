package vn.vnpt.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.QuanHeNhanThan} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class QuanHeNhanThanDTO implements Serializable {

    private Long id;

    private Long idQuanHe;

    private String dienGiai;

    private Long idQuanHeDoiUng;

    private Long idGioiTinh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdQuanHe() {
        return idQuanHe;
    }

    public void setIdQuanHe(Long idQuanHe) {
        this.idQuanHe = idQuanHe;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public Long getIdQuanHeDoiUng() {
        return idQuanHeDoiUng;
    }

    public void setIdQuanHeDoiUng(Long idQuanHeDoiUng) {
        this.idQuanHeDoiUng = idQuanHeDoiUng;
    }

    public Long getIdGioiTinh() {
        return idGioiTinh;
    }

    public void setIdGioiTinh(Long idGioiTinh) {
        this.idGioiTinh = idGioiTinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuanHeNhanThanDTO)) {
            return false;
        }

        QuanHeNhanThanDTO quanHeNhanThanDTO = (QuanHeNhanThanDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, quanHeNhanThanDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuanHeNhanThanDTO{" +
            "id=" + getId() +
            ", idQuanHe=" + getIdQuanHe() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", idQuanHeDoiUng=" + getIdQuanHeDoiUng() +
            ", idGioiTinh=" + getIdGioiTinh() +
            "}";
    }
}
