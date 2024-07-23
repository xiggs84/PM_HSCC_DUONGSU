package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class QuanHeDuongSuDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(QuanHeDuongSuDTO.class);
        QuanHeDuongSuDTO quanHeDuongSuDTO1 = new QuanHeDuongSuDTO();
        quanHeDuongSuDTO1.setId(1L);
        QuanHeDuongSuDTO quanHeDuongSuDTO2 = new QuanHeDuongSuDTO();
        assertThat(quanHeDuongSuDTO1).isNotEqualTo(quanHeDuongSuDTO2);
        quanHeDuongSuDTO2.setId(quanHeDuongSuDTO1.getId());
        assertThat(quanHeDuongSuDTO1).isEqualTo(quanHeDuongSuDTO2);
        quanHeDuongSuDTO2.setId(2L);
        assertThat(quanHeDuongSuDTO1).isNotEqualTo(quanHeDuongSuDTO2);
        quanHeDuongSuDTO1.setId(null);
        assertThat(quanHeDuongSuDTO1).isNotEqualTo(quanHeDuongSuDTO2);
    }
}
