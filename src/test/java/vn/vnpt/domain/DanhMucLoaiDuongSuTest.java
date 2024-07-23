package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vn.vnpt.domain.DanhMucLoaiDuongSuTestSamples.*;
import static vn.vnpt.domain.DuongSuTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DanhMucLoaiDuongSuTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanhMucLoaiDuongSu.class);
        DanhMucLoaiDuongSu danhMucLoaiDuongSu1 = getDanhMucLoaiDuongSuSample1();
        DanhMucLoaiDuongSu danhMucLoaiDuongSu2 = new DanhMucLoaiDuongSu();
        assertThat(danhMucLoaiDuongSu1).isNotEqualTo(danhMucLoaiDuongSu2);

        danhMucLoaiDuongSu2.setId(danhMucLoaiDuongSu1.getId());
        assertThat(danhMucLoaiDuongSu1).isEqualTo(danhMucLoaiDuongSu2);

        danhMucLoaiDuongSu2 = getDanhMucLoaiDuongSuSample2();
        assertThat(danhMucLoaiDuongSu1).isNotEqualTo(danhMucLoaiDuongSu2);
    }

    @Test
    void duongSuTest() {
        DanhMucLoaiDuongSu danhMucLoaiDuongSu = getDanhMucLoaiDuongSuRandomSampleGenerator();
        DuongSu duongSuBack = getDuongSuRandomSampleGenerator();

        danhMucLoaiDuongSu.addDuongSu(duongSuBack);
        assertThat(danhMucLoaiDuongSu.getDuongSus()).containsOnly(duongSuBack);
        assertThat(duongSuBack.getIdLoaiDs()).isEqualTo(danhMucLoaiDuongSu);

        danhMucLoaiDuongSu.removeDuongSu(duongSuBack);
        assertThat(danhMucLoaiDuongSu.getDuongSus()).doesNotContain(duongSuBack);
        assertThat(duongSuBack.getIdLoaiDs()).isNull();

        danhMucLoaiDuongSu.duongSus(new HashSet<>(Set.of(duongSuBack)));
        assertThat(danhMucLoaiDuongSu.getDuongSus()).containsOnly(duongSuBack);
        assertThat(duongSuBack.getIdLoaiDs()).isEqualTo(danhMucLoaiDuongSu);

        danhMucLoaiDuongSu.setDuongSus(new HashSet<>());
        assertThat(danhMucLoaiDuongSu.getDuongSus()).doesNotContain(duongSuBack);
        assertThat(duongSuBack.getIdLoaiDs()).isNull();
    }
}
