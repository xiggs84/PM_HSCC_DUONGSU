package vn.vnpt.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.DanhMucLoaiDuongSu} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanhMucLoaiDuongSuDTO implements Serializable {

    private Long id;

    private Long idLoaiDs;

    private String dienGiai;

    private Long trangThai;

    private String strSearch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLoaiDs() {
        return idLoaiDs;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
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

    public String getStrSearch() {
        return strSearch;
    }

    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DanhMucLoaiDuongSuDTO)) {
            return false;
        }

        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = (DanhMucLoaiDuongSuDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, danhMucLoaiDuongSuDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanhMucLoaiDuongSuDTO{" +
            "id=" + getId() +
            ", idLoaiDs=" + getIdLoaiDs() +
            ", dienGiai='" + getDienGiai() + "'" +
            ", trangThai=" + getTrangThai() +
            ", strSearch='" + getStrSearch() + "'" +
            "}";
    }
}
