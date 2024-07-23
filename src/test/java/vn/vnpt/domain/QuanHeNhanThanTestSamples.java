package vn.vnpt.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class QuanHeNhanThanTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static QuanHeNhanThan getQuanHeNhanThanSample1() {
        return new QuanHeNhanThan().id(1L).idQuanHe(1L).dienGiai("dienGiai1").idQuanHeDoiUng(1L).idGioiTinh(1L);
    }

    public static QuanHeNhanThan getQuanHeNhanThanSample2() {
        return new QuanHeNhanThan().id(2L).idQuanHe(2L).dienGiai("dienGiai2").idQuanHeDoiUng(2L).idGioiTinh(2L);
    }

    public static QuanHeNhanThan getQuanHeNhanThanRandomSampleGenerator() {
        return new QuanHeNhanThan()
            .id(longCount.incrementAndGet())
            .idQuanHe(longCount.incrementAndGet())
            .dienGiai(UUID.randomUUID().toString())
            .idQuanHeDoiUng(longCount.incrementAndGet())
            .idGioiTinh(longCount.incrementAndGet());
    }
}
