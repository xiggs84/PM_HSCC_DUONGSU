package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DanhMucLoaiDuongSuTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DanhMucLoaiDuongSu getDanhMucLoaiDuongSuSample1() {
        return new DanhMucLoaiDuongSu().id(1L).idLoaiDs(1L).dienGiai("dienGiai1").trangThai(1L).strSearch("strSearch1");
    }

    public static DanhMucLoaiDuongSu getDanhMucLoaiDuongSuSample2() {
        return new DanhMucLoaiDuongSu().id(2L).idLoaiDs(2L).dienGiai("dienGiai2").trangThai(2L).strSearch("strSearch2");
    }

    public static DanhMucLoaiDuongSu getDanhMucLoaiDuongSuRandomSampleGenerator() {
        return new DanhMucLoaiDuongSu()
            .id(longCount.incrementAndGet())
            .idLoaiDs(longCount.incrementAndGet())
            .dienGiai(UUID.randomUUID().toString())
            .trangThai(longCount.incrementAndGet())
            .strSearch(UUID.randomUUID().toString());
    }
}
