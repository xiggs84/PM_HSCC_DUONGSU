package vn.vnpt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A DuongSu.
 */
@Entity
@Table(name = "duong_su")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DuongSu implements Serializable {

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

    @Column(name = "id_master")
    private String idMaster;

    @Column(name = "id_don_vi")
    private Long idDonVi;

    @Column(name = "str_search")
    private String strSearch;

    @Column(name = "so_giay_to")
    private String soGiayTo;

    @Column(name = "id_loai_ngan_chan")
    private Long idLoaiNganChan;

    @Column(name = "sync_status")
    private Long syncStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "duongSus" }, allowSetters = true)
    private DanhMucLoaiDuongSu idLoaiDs;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DuongSu id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDuongSu() {
        return this.idDuongSu;
    }

    public DuongSu idDuongSu(Long idDuongSu) {
        this.setIdDuongSu(idDuongSu);
        return this;
    }

    public void setIdDuongSu(Long idDuongSu) {
        this.idDuongSu = idDuongSu;
    }

    public String getTenDuongSu() {
        return this.tenDuongSu;
    }

    public DuongSu tenDuongSu(String tenDuongSu) {
        this.setTenDuongSu(tenDuongSu);
        return this;
    }

    public void setTenDuongSu(String tenDuongSu) {
        this.tenDuongSu = tenDuongSu;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public DuongSu diaChi(String diaChi) {
        this.setDiaChi(diaChi);
        return this;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getTrangThai() {
        return this.trangThai;
    }

    public DuongSu trangThai(Long trangThai) {
        this.setTrangThai(trangThai);
        return this;
    }

    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    public String getThongTinDs() {
        return this.thongTinDs;
    }

    public DuongSu thongTinDs(String thongTinDs) {
        this.setThongTinDs(thongTinDs);
        return this;
    }

    public void setThongTinDs(String thongTinDs) {
        this.thongTinDs = thongTinDs;
    }

    public LocalDate getNgayThaoTac() {
        return this.ngayThaoTac;
    }

    public DuongSu ngayThaoTac(LocalDate ngayThaoTac) {
        this.setNgayThaoTac(ngayThaoTac);
        return this;
    }

    public void setNgayThaoTac(LocalDate ngayThaoTac) {
        this.ngayThaoTac = ngayThaoTac;
    }

    public Long getNguoiThaoTac() {
        return this.nguoiThaoTac;
    }

    public DuongSu nguoiThaoTac(Long nguoiThaoTac) {
        this.setNguoiThaoTac(nguoiThaoTac);
        return this;
    }

    public void setNguoiThaoTac(Long nguoiThaoTac) {
        this.nguoiThaoTac = nguoiThaoTac;
    }

    public Long getIdDsGoc() {
        return this.idDsGoc;
    }

    public DuongSu idDsGoc(Long idDsGoc) {
        this.setIdDsGoc(idDsGoc);
        return this;
    }

    public void setIdDsGoc(Long idDsGoc) {
        this.idDsGoc = idDsGoc;
    }

    public String getIdMaster() {
        return this.idMaster;
    }

    public DuongSu idMaster(String idMaster) {
        this.setIdMaster(idMaster);
        return this;
    }

    public void setIdMaster(String idMaster) {
        this.idMaster = idMaster;
    }

    public Long getIdDonVi() {
        return this.idDonVi;
    }

    public DuongSu idDonVi(Long idDonVi) {
        this.setIdDonVi(idDonVi);
        return this;
    }

    public void setIdDonVi(Long idDonVi) {
        this.idDonVi = idDonVi;
    }

    public String getStrSearch() {
        return this.strSearch;
    }

    public DuongSu strSearch(String strSearch) {
        this.setStrSearch(strSearch);
        return this;
    }

    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    public String getSoGiayTo() {
        return this.soGiayTo;
    }

    public DuongSu soGiayTo(String soGiayTo) {
        this.setSoGiayTo(soGiayTo);
        return this;
    }

    public void setSoGiayTo(String soGiayTo) {
        this.soGiayTo = soGiayTo;
    }

    public Long getIdLoaiNganChan() {
        return this.idLoaiNganChan;
    }

    public DuongSu idLoaiNganChan(Long idLoaiNganChan) {
        this.setIdLoaiNganChan(idLoaiNganChan);
        return this;
    }

    public void setIdLoaiNganChan(Long idLoaiNganChan) {
        this.idLoaiNganChan = idLoaiNganChan;
    }

    public Long getSyncStatus() {
        return this.syncStatus;
    }

    public DuongSu syncStatus(Long syncStatus) {
        this.setSyncStatus(syncStatus);
        return this;
    }

    public void setSyncStatus(Long syncStatus) {
        this.syncStatus = syncStatus;
    }

    public DanhMucLoaiDuongSu getIdLoaiDs() {
        return this.idLoaiDs;
    }

    public void setIdLoaiDs(DanhMucLoaiDuongSu danhMucLoaiDuongSu) {
        this.idLoaiDs = danhMucLoaiDuongSu;
    }

    public DuongSu idLoaiDs(DanhMucLoaiDuongSu danhMucLoaiDuongSu) {
        this.setIdLoaiDs(danhMucLoaiDuongSu);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DuongSu)) {
            return false;
        }
        return getId() != null && getId().equals(((DuongSu) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DuongSu{" +
            "id=" + getId() +
            ", idDuongSu=" + getIdDuongSu() +
            ", tenDuongSu='" + getTenDuongSu() + "'" +
            ", diaChi='" + getDiaChi() + "'" +
            ", trangThai=" + getTrangThai() +
            ", thongTinDs='" + getThongTinDs() + "'" +
            ", ngayThaoTac='" + getNgayThaoTac() + "'" +
            ", nguoiThaoTac=" + getNguoiThaoTac() +
            ", idDsGoc=" + getIdDsGoc() +
            ", idMaster='" + getIdMaster() + "'" +
            ", idDonVi=" + getIdDonVi() +
            ", strSearch='" + getStrSearch() + "'" +
            ", soGiayTo='" + getSoGiayTo() + "'" +
            ", idLoaiNganChan=" + getIdLoaiNganChan() +
            ", syncStatus=" + getSyncStatus() +
            "}";
    }
}
