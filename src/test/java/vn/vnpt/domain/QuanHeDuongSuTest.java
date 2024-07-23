package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vn.vnpt.domain.QuanHeDuongSuTestSamples.*;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class QuanHeDuongSuTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(QuanHeDuongSu.class);
        QuanHeDuongSu quanHeDuongSu1 = getQuanHeDuongSuSample1();
        QuanHeDuongSu quanHeDuongSu2 = new QuanHeDuongSu();
        assertThat(quanHeDuongSu1).isNotEqualTo(quanHeDuongSu2);

        quanHeDuongSu2.setId(quanHeDuongSu1.getId());
        assertThat(quanHeDuongSu1).isEqualTo(quanHeDuongSu2);

        quanHeDuongSu2 = getQuanHeDuongSuSample2();
        assertThat(quanHeDuongSu1).isNotEqualTo(quanHeDuongSu2);
    }
}
