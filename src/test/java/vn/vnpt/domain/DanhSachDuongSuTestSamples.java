package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DanhSachDuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DanhSachDuongSu getDanhSachDuongSuSample1() {
        return new DanhSachDuongSu()
            .id(1L)
            .idDuongSu(1L)
            .tenDuongSu("tenDuongSu1")
            .idLoaiDs(1L)
            .diaChi("diaChi1")
            .trangThai(1L)
            .nguoiThaoTac(1L)
            .idDsGoc(1L)
            .idTinhTrang(1L)
            .idMaster("idMaster1")
            .idDonVi(1L)
            .strSearch("strSearch1")
            .soGiayTo("soGiayTo1")
            .idLoaiNganChan(1L);
    }

    public static DanhSachDuongSu getDanhSachDuongSuSample2() {
        return new DanhSachDuongSu()
            .id(2L)
            .idDuongSu(2L)
            .tenDuongSu("tenDuongSu2")
            .idLoaiDs(2L)
            .diaChi("diaChi2")
            .trangThai(2L)
            .nguoiThaoTac(2L)
            .idDsGoc(2L)
            .idTinhTrang(2L)
            .idMaster("idMaster2")
            .idDonVi(2L)
            .strSearch("strSearch2")
            .soGiayTo("soGiayTo2")
            .idLoaiNganChan(2L);
    }

    public static DanhSachDuongSu getDanhSachDuongSuRandomSampleGenerator() {
        return new DanhSachDuongSu()
            .id(longCount.incrementAndGet())
            .idDuongSu(longCount.incrementAndGet())
            .tenDuongSu(UUID.randomUUID().toString())
            .idLoaiDs(longCount.incrementAndGet())
            .diaChi(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet())
            .nguoiThaoTac(longCount.incrementAndGet())
            .idDsGoc(longCount.incrementAndGet())
            .idTinhTrang(longCount.incrementAndGet())
            .idMaster(UUID.randomUUID().toString())
            .idDonVi(longCount.incrementAndGet())
            .strSearch(UUID.randomUUID().toString())
            .soGiayTo(UUID.randomUUID().toString())
            .idLoaiNganChan(longCount.incrementAndGet());
    }
}
