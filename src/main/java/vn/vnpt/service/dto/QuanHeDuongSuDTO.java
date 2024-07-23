package vn.vnpt.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.QuanHeDuongSu} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class QuanHeDuongSuDTO implements Serializable {

    private Long id;

    private Long idDuongSu;

    private Long idDuongSuQh;

    private Long idQuanHe;

    private String thongTinQuanHe;

    private Long trangThai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDuongSu() {
        return idDuongSu;
    }

    public void setIdDuongSu(Long idDuongSu) {
        this.idDuongSu = idDuongSu;
    }

    public Long getIdDuongSuQh() {
        return idDuongSuQh;
    }

    public void setIdDuongSuQh(Long idDuongSuQh) {
        this.idDuongSuQh = idDuongSuQh;
    }

    public Long getIdQuanHe() {
        return idQuanHe;
    }

    public void setIdQuanHe(Long idQuanHe) {
        this.idQuanHe = idQuanHe;
    }

    public String getThongTinQuanHe() {
        return thongTinQuanHe;
    }

    public void setThongTinQuanHe(String thongTinQuanHe) {
        this.thongTinQuanHe = thongTinQuanHe;
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
        if (!(o instanceof QuanHeDuongSuDTO)) {
            return false;
        }

        QuanHeDuongSuDTO quanHeDuongSuDTO = (QuanHeDuongSuDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, quanHeDuongSuDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuanHeDuongSuDTO{" +
            "id=" + getId() +
            ", idDuongSu=" + getIdDuongSu() +
            ", idDuongSuQh=" + getIdDuongSuQh() +
            ", idQuanHe=" + getIdQuanHe() +
            ", thongTinQuanHe='" + getThongTinQuanHe() + "'" +
            ", trangThai=" + getTrangThai() +
            "}";
    }
}
