package vn.vnpt.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.domain.DuongSuTrungCmnd} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DuongSuTrungCmndDTO implements Serializable {

    private Long id;

    private Long idDuongSu;

    private String tenDuongSu;

    private Long idLoaiDs;

    private String diaChi;

    private Long trangThai;

    private String thongTinDs;

    private LocalDate ngayThaoTac;

    private Long nguoiThaoTac;

    private Long idDsGoc;

    private Long idTinhTrang;

    private String idMaster;

    private Long idDonVi;

    private String strSearch;

    private String soGiayTo;

    private Long idDuongSuMin;

    private Long idMasterMin;

    private Long idDuongSuMax;

    private Long idMasterMax;

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

    public String getThongTinDs() {
        return thongTinDs;
    }

    public void setThongTinDs(String thongTinDs) {
        this.thongTinDs = thongTinDs;
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

    public Long getIdDuongSuMin() {
        return idDuongSuMin;
    }

    public void setIdDuongSuMin(Long idDuongSuMin) {
        this.idDuongSuMin = idDuongSuMin;
    }

    public Long getIdMasterMin() {
        return idMasterMin;
    }

    public void setIdMasterMin(Long idMasterMin) {
        this.idMasterMin = idMasterMin;
    }

    public Long getIdDuongSuMax() {
        return idDuongSuMax;
    }

    public void setIdDuongSuMax(Long idDuongSuMax) {
        this.idDuongSuMax = idDuongSuMax;
    }

    public Long getIdMasterMax() {
        return idMasterMax;
    }

    public void setIdMasterMax(Long idMasterMax) {
        this.idMasterMax = idMasterMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DuongSuTrungCmndDTO)) {
            return false;
        }

        DuongSuTrungCmndDTO duongSuTrungCmndDTO = (DuongSuTrungCmndDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, duongSuTrungCmndDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DuongSuTrungCmndDTO{" +
            "id=" + getId() +
            ", idDuongSu=" + getIdDuongSu() +
            ", tenDuongSu='" + getTenDuongSu() + "'" +
            ", idLoaiDs=" + getIdLoaiDs() +
            ", diaChi='" + getDiaChi() + "'" +
            ", trangThai=" + getTrangThai() +
            ", thongTinDs='" + getThongTinDs() + "'" +
            ", ngayThaoTac='" + getNgayThaoTac() + "'" +
            ", nguoiThaoTac=" + getNguoiThaoTac() +
            ", idDsGoc=" + getIdDsGoc() +
            ", idTinhTrang=" + getIdTinhTrang() +
            ", idMaster='" + getIdMaster() + "'" +
            ", idDonVi=" + getIdDonVi() +
            ", strSearch='" + getStrSearch() + "'" +
            ", soGiayTo='" + getSoGiayTo() + "'" +
            ", idDuongSuMin=" + getIdDuongSuMin() +
            ", idMasterMin=" + getIdMasterMin() +
            ", idDuongSuMax=" + getIdDuongSuMax() +
            ", idMasterMax=" + getIdMasterMax() +
            "}";
    }
}
