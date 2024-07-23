package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vn.vnpt.domain.DanhMucTinhTrangHonNhanTestSamples.*;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DanhMucTinhTrangHonNhanTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanhMucTinhTrangHonNhan.class);
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan1 = getDanhMucTinhTrangHonNhanSample1();
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan2 = new DanhMucTinhTrangHonNhan();
        assertThat(danhMucTinhTrangHonNhan1).isNotEqualTo(danhMucTinhTrangHonNhan2);

        danhMucTinhTrangHonNhan2.setId(danhMucTinhTrangHonNhan1.getId());
        assertThat(danhMucTinhTrangHonNhan1).isEqualTo(danhMucTinhTrangHonNhan2);

        danhMucTinhTrangHonNhan2 = getDanhMucTinhTrangHonNhanSample2();
        assertThat(danhMucTinhTrangHonNhan1).isNotEqualTo(danhMucTinhTrangHonNhan2);
    }
}
