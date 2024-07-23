package vn.vnpt.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.DanhMucTinhTrangHonNhan} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanhMucTinhTrangHonNhanDTO implements Serializable {

    private Long id;

    private Long idTinhTrang;

    private String dienGiai;

    private Long trangThai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(Long idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public Long getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DanhMucTinhTrangHonNhanDTO)) {
            return false;
        }

        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = (DanhMucTinhTrangHonNhanDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, danhMucTinhTrangHonNhanDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanhMucTinhTrangHonNhanDTO{" +
            "id=" + getId() +
            ", idTinhTrang=" + getIdTinhTrang() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", trangThai=" + getTrangThai() +
            "}";
    }
}
