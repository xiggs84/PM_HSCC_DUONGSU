package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DanhMucTinhTrangHonNhanTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DanhMucTinhTrangHonNhan getDanhMucTinhTrangHonNhanSample1() {
        return new DanhMucTinhTrangHonNhan().id(1L).idTinhTrang(1L).dienGiai("dienGiai1").trangThai(1L);
    }

    public static DanhMucTinhTrangHonNhan getDanhMucTinhTrangHonNhanSample2() {
        return new DanhMucTinhTrangHonNhan().id(2L).idTinhTrang(2L).dienGiai("dienGiai2").trangThai(2L);
    }

    public static DanhMucTinhTrangHonNhan getDanhMucTinhTrangHonNhanRandomSampleGenerator() {
        return new DanhMucTinhTrangHonNhan()
            .id(longCount.incrementAndGet())
            .idTinhTrang(longCount.incrementAndGet())
            .dienGiai(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet());
    }
}
