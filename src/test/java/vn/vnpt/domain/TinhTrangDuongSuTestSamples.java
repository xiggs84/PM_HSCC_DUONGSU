package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TinhTrangDuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TinhTrangDuongSu getTinhTrangDuongSuSample1() {
        return new TinhTrangDuongSu().id(1L).idTinhTrang(1L).dienGiai("dienGiai1").idLoaiDs(1L);
    }

    public static TinhTrangDuongSu getTinhTrangDuongSuSample2() {
        return new TinhTrangDuongSu().id(2L).idTinhTrang(2L).dienGiai("dienGiai2").idLoaiDs(2L);
    }

    public static TinhTrangDuongSu getTinhTrangDuongSuRandomSampleGenerator() {
        return new TinhTrangDuongSu()
            .id(longCount.incrementAndGet())
            .idTinhTrang(longCount.incrementAndGet())
            .dienGiai(UUID.randomUUID().toString())
            .idLoaiDs(longCount.incrementAndGet());
    }
}
