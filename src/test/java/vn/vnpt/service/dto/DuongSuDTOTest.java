package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DuongSuDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DuongSuDTO.class);
        DuongSuDTO duongSuDTO1 = new DuongSuDTO();
        duongSuDTO1.setId(1L);
        DuongSuDTO duongSuDTO2 = new DuongSuDTO();
        assertThat(duongSuDTO1).isNotEqualTo(duongSuDTO2);
        duongSuDTO2.setId(duongSuDTO1.getId());
        assertThat(duongSuDTO1).isEqualTo(duongSuDTO2);
        duongSuDTO2.setId(2L);
        assertThat(duongSuDTO1).isNotEqualTo(duongSuDTO2);
        duongSuDTO1.setId(null);
        assertThat(duongSuDTO1).isNotEqualTo(duongSuDTO2);
    }
}
