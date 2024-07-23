package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class QuanHeNhanThanDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(QuanHeNhanThanDTO.class);
        QuanHeNhanThanDTO quanHeNhanThanDTO1 = new QuanHeNhanThanDTO();
        quanHeNhanThanDTO1.setId(1L);
        QuanHeNhanThanDTO quanHeNhanThanDTO2 = new QuanHeNhanThanDTO();
        assertThat(quanHeNhanThanDTO1).isNotEqualTo(quanHeNhanThanDTO2);
        quanHeNhanThanDTO2.setId(quanHeNhanThanDTO1.getId());
        assertThat(quanHeNhanThanDTO1).isEqualTo(quanHeNhanThanDTO2);
        quanHeNhanThanDTO2.setId(2L);
        assertThat(quanHeNhanThanDTO1).isNotEqualTo(quanHeNhanThanDTO2);
        quanHeNhanThanDTO1.setId(null);
        assertThat(quanHeNhanThanDTO1).isNotEqualTo(quanHeNhanThanDTO2);
    }
}
