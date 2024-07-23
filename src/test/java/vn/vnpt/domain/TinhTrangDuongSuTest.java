package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vn.vnpt.domain.TinhTrangDuongSuTestSamples.*;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class TinhTrangDuongSuTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TinhTrangDuongSu.class);
        TinhTrangDuongSu tinhTrangDuongSu1 = getTinhTrangDuongSuSample1();
        TinhTrangDuongSu tinhTrangDuongSu2 = new TinhTrangDuongSu();
        assertThat(tinhTrangDuongSu1).isNotEqualTo(tinhTrangDuongSu2);

        tinhTrangDuongSu2.setId(tinhTrangDuongSu1.getId());
        assertThat(tinhTrangDuongSu1).isEqualTo(tinhTrangDuongSu2);

        tinhTrangDuongSu2 = getTinhTrangDuongSuSample2();
        assertThat(tinhTrangDuongSu1).isNotEqualTo(tinhTrangDuongSu2);
    }
}
