package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vn.vnpt.domain.DanhMucLoaiDuongSuTestSamples.*;
import static vn.vnpt.domain.DuongSuTestSamples.*;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DuongSuTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DuongSu.class);
        DuongSu duongSu1 = getDuongSuSample1();
        DuongSu duongSu2 = new DuongSu();
        assertThat(duongSu1).isNotEqualTo(duongSu2);

        duongSu2.setId(duongSu1.getId());
        assertThat(duongSu1).isEqualTo(duongSu2);

        duongSu2 = getDuongSuSample2();
        assertThat(duongSu1).isNotEqualTo(duongSu2);
    }

    @Test
    void idLoaiDsTest() {
        DuongSu duongSu = getDuongSuRandomSampleGenerator();
        DanhMucLoaiDuongSu danhMucLoaiDuongSuBack = getDanhMucLoaiDuongSuRandomSampleGenerator();

        duongSu.setIdLoaiDs(danhMucLoaiDuongSuBack);
        assertThat(duongSu.getIdLoaiDs()).isEqualTo(danhMucLoaiDuongSuBack);

        duongSu.idLoaiDs(null);
        assertThat(duongSu.getIdLoaiDs()).isNull();
    }
}
