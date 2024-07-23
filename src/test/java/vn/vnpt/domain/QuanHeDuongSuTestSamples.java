package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class QuanHeDuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static QuanHeDuongSu getQuanHeDuongSuSample1() {
        return new QuanHeDuongSu().id(1L).idDuongSu(1L).idDuongSuQh(1L).idQuanHe(1L).thongTinQuanHe("thongTinQuanHe1").trangThai(1L);
    }

    public static QuanHeDuongSu getQuanHeDuongSuSample2() {
        return new QuanHeDuongSu().id(2L).idDuongSu(2L).idDuongSuQh(2L).idQuanHe(2L).thongTinQuanHe("thongTinQuanHe2").trangThai(2L);
    }

    public static QuanHeDuongSu getQuanHeDuongSuRandomSampleGenerator() {
        return new QuanHeDuongSu()
            .id(longCount.incrementAndGet())
            .idDuongSu(longCount.incrementAndGet())
            .idDuongSuQh(longCount.incrementAndGet())
            .idQuanHe(longCount.incrementAndGet())
            .thongTinQuanHe(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet());
    }
}
