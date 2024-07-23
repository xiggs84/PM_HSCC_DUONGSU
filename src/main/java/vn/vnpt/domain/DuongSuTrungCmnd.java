package vn.vnpt.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DuongSuTrungCmnd.
 */
@Entity
@Table(name = "duong_su_trung_cmnd")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DuongSuTrungCmnd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_duong_su")
    private Long idDuongSu;

    @Column(name = "ten_duong_su")
    private String tenDuongSu;

    @Column(name = "id_loai_ds")
    private Long idLoaiDs;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "trang_thai")
    private Long trangThai;

    @Column(name = "thong_tin_ds")
    private String thongTinDs;

    @Column(name = "ngay_thao_tac")
    private LocalDate ngayThaoTac;

    @Column(name = "nguoi_thao_tac")
    private Long nguoiThaoTac;

    @Column(name = "id_ds_goc")
    private Long idDsGoc;

    @Column(name = "id_tinh_trang")
    private Long idTinhTrang;

    @Column(name = "id_master")
    private String idMaster;

    @Column(name = "id_don_vi")
    private Long idDonVi;

    @Column(name = "str_search")
    private String strSearch;

    @Column(name = "so_giay_to")
    private String soGiayTo;

    @Column(name = "id_duong_su_min")
    private Long idDuongSuMin;

    @Column(name = "id_master_min")
    private Long idMasterMin;

    @Column(name = "id_duong_su_max")
    private Long idDuongSuMax;

    @Column(name = "id_master_max")
    private Long idMasterMax;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DuongSuTrungCmnd id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDuongSu() {
        return this.idDuongSu;
    }

    public DuongSuTrungCmnd idDuongSu(Long idDuongSu) {
        this.setIdDuongSu(idDuongSu);
        return this;
    }

    public void setIdDuongSu(Long idDuongSu) {
        this.idDuongSu = idDuongSu;
    }

    public String getTenDuongSu() {
        return this.tenDuongSu;
    }

    public DuongSuTrungCmnd tenDuongSu(String tenDuongSu) {
        this.setTenDuongSu(tenDuongSu);
        return this;
    }

    public void setTenDuongSu(String tenDuongSu) {
        this.tenDuongSu = tenDuongSu;
    }

    public Long getIdLoaiDs() {
        return this.idLoaiDs;
    }

    public DuongSuTrungCmnd idLoaiDs(Long idLoaiDs) {
        this.setIdLoaiDs(idLoaiDs);
        return this;
    }

    public void setIdLoaiDs(Long idLoaiDs) {
        this.idLoaiDs = idLoaiDs;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public DuongSuTrungCmnd diaChi(String diaChi) {
        this.setDiaChi(diaChi);
        return this;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getTrangThai() {
        return this.trangThai;
    }

    public DuongSuTrungCmnd trangThai(Long trangThai) {
        this.setTrangThai(trangThai);
        return this;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    public String getThongTinDs() {
        return this.thongTinDs;
    }

    public DuongSuTrungCmnd thongTinDs(String thongTinDs) {
        this.setThongTinDs(thongTinDs);
        return this;
    }

    public void setThongTinDs(String thongTinDs) {
        this.thongTinDs = thongTinDs;
    }

    public LocalDate getNgayThaoTac() {
        return this.ngayThaoTac;
    }

    public DuongSuTrungCmnd ngayThaoTac(LocalDate ngayThaoTac) {
        this.setNgayThaoTac(ngayThaoTac);
        return this;
    }

    public void setNgayThaoTac(LocalDate ngayThaoTac) {
        this.ngayThaoTac = ngayThaoTac;
    }

    public Long getNguoiThaoTac() {
        return this.nguoiThaoTac;
    }

    public DuongSuTrungCmnd nguoiThaoTac(Long nguoiThaoTac) {
        this.setNguoiThaoTac(nguoiThaoTac);
        return this;
    }

    public void setNguoiThaoTac(Long nguoiThaoTac) {
        this.nguoiThaoTac = nguoiThaoTac;
    }

    public Long getIdDsGoc() {
        return this.idDsGoc;
    }

    public DuongSuTrungCmnd idDsGoc(Long idDsGoc) {
        this.setIdDsGoc(idDsGoc);
        return this;
    }

    public void setIdDsGoc(Long idDsGoc) {
        this.idDsGoc = idDsGoc;
    }

    public Long getIdTinhTrang() {
        return this.idTinhTrang;
    }

    public DuongSuTrungCmnd idTinhTrang(Long idTinhTrang) {
        this.setIdTinhTrang(idTinhTrang);
        return this;
    }

    public void setIdTinhTrang(Long idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public String getIdMaster() {
        return this.idMaster;
    }

    public DuongSuTrungCmnd idMaster(String idMaster) {
        this.setIdMaster(idMaster);
        return this;
    }

    public void setIdMaster(String idMaster) {
        this.idMaster = idMaster;
    }

    public Long getIdDonVi() {
        return this.idDonVi;
    }

    public DuongSuTrungCmnd idDonVi(Long idDonVi) {
        this.setIdDonVi(idDonVi);
        return this;
    }

    public void setIdDonVi(Long idDonVi) {
        this.idDonVi = idDonVi;
    }

    public String getStrSearch() {
        return this.strSearch;
    }

    public DuongSuTrungCmnd strSearch(String strSearch) {
        this.setStrSearch(strSearch);
        return this;
    }

    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    public String getSoGiayTo() {
        return this.soGiayTo;
    }

    public DuongSuTrungCmnd soGiayTo(String soGiayTo) {
        this.setSoGiayTo(soGiayTo);
        return this;
    }

    public void setSoGiayTo(String soGiayTo) {
        this.soGiayTo = soGiayTo;
    }

    public Long getIdDuongSuMin() {
        return this.idDuongSuMin;
    }

    public DuongSuTrungCmnd idDuongSuMin(Long idDuongSuMin) {
        this.setIdDuongSuMin(idDuongSuMin);
        return this;
    }

    public void setIdDuongSuMin(Long idDuongSuMin) {
        this.idDuongSuMin = idDuongSuMin;
    }

    public Long getIdMasterMin() {
        return this.idMasterMin;
    }

    public DuongSuTrungCmnd idMasterMin(Long idMasterMin) {
        this.setIdMasterMin(idMasterMin);
        return this;
    }

    public void setIdMasterMin(Long idMasterMin) {
        this.idMasterMin = idMasterMin;
    }

    public Long getIdDuongSuMax() {
        return this.idDuongSuMax;
    }

    public DuongSuTrungCmnd idDuongSuMax(Long idDuongSuMax) {
        this.setIdDuongSuMax(idDuongSuMax);
        return this;
    }

    public void setIdDuongSuMax(Long idDuongSuMax) {
        this.idDuongSuMax = idDuongSuMax;
    }

    public Long getIdMasterMax() {
        return this.idMasterMax;
    }

    public DuongSuTrungCmnd idMasterMax(Long idMasterMax) {
        this.setIdMasterMax(idMasterMax);
        return this;
    }

    public void setIdMasterMax(Long idMasterMax) {
        this.idMasterMax = idMasterMax;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DuongSuTrungCmnd)) {
            return false;
        }
        return getId() != null && getId().equals(((DuongSuTrungCmnd) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DuongSuTrungCmnd{" +
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
