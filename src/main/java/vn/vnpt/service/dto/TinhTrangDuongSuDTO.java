package vn.vnpt.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.TinhTrangDuongSu} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TinhTrangDuongSuDTO implements Serializable {

    private Long id;

    private Long idTinhTrang;

    private String dienGiai;

    private Long idLoaiDs;

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

    public Long getIdLoaiDs() {
        return idLoaiDs;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TinhTrangDuongSuDTO)) {
            return false;
        }

        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = (TinhTrangDuongSuDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tinhTrangDuongSuDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TinhTrangDuongSuDTO{" +
            "id=" + getId() +
            ", idTinhTrang=" + getIdTinhTrang() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", idLoaiDs=" + getIdLoaiDs() +
            "}";
    }
}
