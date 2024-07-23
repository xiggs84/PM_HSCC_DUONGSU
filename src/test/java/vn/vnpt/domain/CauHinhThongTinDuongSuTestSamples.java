package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class CauHinhThongTinDuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static CauHinhThongTinDuongSu getCauHinhThongTinDuongSuSample1() {
        return new CauHinhThongTinDuongSu()
            .id(1L)
            .idCauHinh(1L)
            .noiDung("noiDung1")
            .javascript("javascript1")
            .css("css1")
            .idLoaiDs(1L)
            .idDonVi(1L)
            .trangThai(1L);
    }

    public static CauHinhThongTinDuongSu getCauHinhThongTinDuongSuSample2() {
        return new CauHinhThongTinDuongSu()
            .id(2L)
            .idCauHinh(2L)
            .noiDung("noiDung2")
            .javascript("javascript2")
            .css("css2")
            .idLoaiDs(2L)
            .idDonVi(2L)
            .trangThai(2L);
    }

    public static CauHinhThongTinDuongSu getCauHinhThongTinDuongSuRandomSampleGenerator() {
        return new CauHinhThongTinDuongSu()
            .id(longCount.incrementAndGet())
            .idCauHinh(longCount.incrementAndGet())
            .noiDung(UUID.randomUUID().toString())
            .javascript(UUID.randomUUID().toString())
            .css(UUID.randomUUID().toString())
            .idLoaiDs(longCount.incrementAndGet())
            .idDonVi(longCount.incrementAndGet())
            .trangThai(longCount.incrementAndGet());
    }
}
