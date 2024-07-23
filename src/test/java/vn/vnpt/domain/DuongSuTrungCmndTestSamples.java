package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DuongSuTrungCmndTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DuongSuTrungCmnd getDuongSuTrungCmndSample1() {
        return new DuongSuTrungCmnd()
            .id(1L)
            .idDuongSu(1L)
            .tenDuongSu("tenDuongSu1")
            .idLoaiDs(1L)
            .diaChi("diaChi1")
            .trangThai(1L)
            .thongTinDs("thongTinDs1")
            .nguoiThaoTac(1L)
            .idDsGoc(1L)
            .idTinhTrang(1L)
            .idMaster("idMaster1")
            .idDonVi(1L)
            .strSearch("strSearch1")
            .soGiayTo("soGiayTo1")
            .idDuongSuMin(1L)
            .idMasterMin(1L)
            .idDuongSuMax(1L)
            .idMasterMax(1L);
    }

    public static DuongSuTrungCmnd getDuongSuTrungCmndSample2() {
        return new DuongSuTrungCmnd()
            .id(2L)
            .idDuongSu(2L)
            .tenDuongSu("tenDuongSu2")
            .idLoaiDs(2L)
            .diaChi("diaChi2")
            .trangThai(2L)
            .thongTinDs("thongTinDs2")
            .nguoiThaoTac(2L)
            .idDsGoc(2L)
            .idTinhTrang(2L)
            .idMaster("idMaster2")
            .idDonVi(2L)
            .strSearch("strSearch2")
            .soGiayTo("soGiayTo2")
            .idDuongSuMin(2L)
            .idMasterMin(2L)
            .idDuongSuMax(2L)
            .idMasterMax(2L);
    }

    public static DuongSuTrungCmnd getDuongSuTrungCmndRandomSampleGenerator() {
        return new DuongSuTrungCmnd()
            .id(longCount.incrementAndGet())
            .idDuongSu(longCount.incrementAndGet())
            .tenDuongSu(UUID.randomUUID().toString())
            .idLoaiDs(longCount.incrementAndGet())
            .diaChi(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet())
            .thongTinDs(UUID.randomUUID().toString())
            .nguoiThaoTac(longCount.incrementAndGet())
            .idDsGoc(longCount.incrementAndGet())
            .idTinhTrang(longCount.incrementAndGet())
            .idMaster(UUID.randomUUID().toString())
            .idDonVi(longCount.incrementAndGet())
            .strSearch(UUID.randomUUID().toString())
            .soGiayTo(UUID.randomUUID().toString())
            .idDuongSuMin(longCount.incrementAndGet())
            .idMasterMin(longCount.incrementAndGet())
            .idDuongSuMax(longCount.incrementAndGet())
            .idMasterMax(longCount.incrementAndGet());
    }
}
