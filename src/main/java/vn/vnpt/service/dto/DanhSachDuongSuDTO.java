package vn.vnpt.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.DanhSachDuongSu} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DanhSachDuongSuDTO implements Serializable {

    private Long id;

    private Long idDuongSu;

    private String tenDuongSu;

    private Long idLoaiDs;

    private String diaChi;

    private Long trangThai;

    private LocalDate ngayThaoTac;

    private Long nguoiThaoTac;

    private Long idDsGoc;

    private Long idTinhTrang;

    private String idMaster;

    private Long idDonVi;

    private String strSearch;

    private String soGiayTo;

    private Long idLoaiNganChan;

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

    public String getTenDuongSu() {
        return tenDuongSu;
    }

    public void setTenDuongSu(String tenDuongSu) {
        this.tenDuongSu = tenDuongSu;
    }

    public Long getIdLoaiDs() {
        return idLoaiDs;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDate getNgayThaoTac() {
        return ngayThaoTac;
    }

    public void setNgayThaoTac(LocalDate ngayThaoTac) {
        this.ngayThaoTac = ngayThaoTac;
    }

    public Long getNguoiThaoTac() {
        return nguoiThaoTac;
    }

    public void setNguoiThaoTac(Long nguoiThaoTac) {
        this.nguoiThaoTac = nguoiThaoTac;
    }

    public Long getIdDsGoc() {
        return idDsGoc;
    }

    public void setIdDsGoc(Long idDsGoc) {
        this.idDsGoc = idDsGoc;
    }

    public Long getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(Long idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public String getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(String idMaster) {
        this.idMaster = idMaster;
    }

    public Long getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(Long idDonVi) {
        this.idDonVi = idDonVi;
    }

    public String getStrSearch() {
        return strSearch;
    }

    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    public String getSoGiayTo() {
        return soGiayTo;
    }

    public void setSoGiayTo(String soGiayTo) {
        this.soGiayTo = soGiayTo;
    }

    public Long getIdLoaiNganChan() {
        return idLoaiNganChan;
    }

    public void setIdLoaiNganChan(Long idLoaiNganChan) {
        this.idLoaiNganChan = idLoaiNganChan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DanhSachDuongSuDTO)) {
            return false;
        }

        DanhSachDuongSuDTO danhSachDuongSuDTO = (DanhSachDuongSuDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, danhSachDuongSuDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DanhSachDuongSuDTO{" +
            "id=" + getId() +
            ", idDuongSu=" + getIdDuongSu() +
            ", tenDuongSu='" + getTenDuongSu() + "'" +
            ", idLoaiDs=" + getIdLoaiDs() +
            ", diaChi='" + getDiaChi() + "'" +
            ", trangThai=" + getTrangThai() +
            ", ngayThaoTac='" + getNgayThaoTac() + "'" +
            ", nguoiThaoTac=" + getNguoiThaoTac() +
            ", idDsGoc=" + getIdDsGoc() +
            ", idTinhTrang=" + getIdTinhTrang() +
            ", idMaster='" + getIdMaster() + "'" +
            ", idDonVi=" + getIdDonVi() +
            ", strSearch='" + getStrSearch() + "'" +
            ", soGiayTo='" + getSoGiayTo() + "'" +
            ", idLoaiNganChan=" + getIdLoaiNganChan() +
            "}";
    }
}
