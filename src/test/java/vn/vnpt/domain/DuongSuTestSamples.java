package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DuongSu getDuongSuSample1() {
        return new DuongSu()
            .id(1L)
            .idDuongSu(1L)
            .tenDuongSu("tenDuongSu1")
            .diaChi("diaChi1")
            .trangThai(1L)
            .thongTinDs("thongTinDs1")
            .nguoiThaoTac(1L)
            .idDsGoc(1L)
            .idMaster("idMaster1")
            .idDonVi(1L)
            .strSearch("strSearch1")
            .soGiayTo("soGiayTo1")
            .idLoaiNganChan(1L)
            .syncStatus(1L);
    }

    public static DuongSu getDuongSuSample2() {
        return new DuongSu()
            .id(2L)
            .idDuongSu(2L)
            .tenDuongSu("tenDuongSu2")
            .diaChi("diaChi2")
            .trangThai(2L)
            .thongTinDs("thongTinDs2")
            .nguoiThaoTac(2L)
            .idDsGoc(2L)
            .idMaster("idMaster2")
            .idDonVi(2L)
            .strSearch("strSearch2")
            .soGiayTo("soGiayTo2")
            .idLoaiNganChan(2L)
            .syncStatus(2L);
    }

    public static DuongSu getDuongSuRandomSampleGenerator() {
        return new DuongSu()
            .id(longCount.incrementAndGet())
            .idDuongSu(longCount.incrementAndGet())
            .tenDuongSu(UUID.randomUUID().toString())
            .diaChi(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet())
            .thongTinDs(UUID.randomUUID().toString())
            .nguoiThaoTac(longCount.incrementAndGet())
            .idDsGoc(longCount.incrementAndGet())
            .idMaster(UUID.randomUUID().toString())
            .idDonVi(longCount.incrementAndGet())
            .strSearch(UUID.randomUUID().toString())
            .soGiayTo(UUID.randomUUID().toString())
            .idLoaiNganChan(longCount.incrementAndGet())
            .syncStatus(longCount.incrementAndGet());
    }
}
