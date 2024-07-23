package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DanhMucTinhTrangHonNhanDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanhMucTinhTrangHonNhanDTO.class);
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO1 = new DanhMucTinhTrangHonNhanDTO();
        danhMucTinhTrangHonNhanDTO1.setId(1L);
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO2 = new DanhMucTinhTrangHonNhanDTO();
        assertThat(danhMucTinhTrangHonNhanDTO1).isNotEqualTo(danhMucTinhTrangHonNhanDTO2);
        danhMucTinhTrangHonNhanDTO2.setId(danhMucTinhTrangHonNhanDTO1.getId());
        assertThat(danhMucTinhTrangHonNhanDTO1).isEqualTo(danhMucTinhTrangHonNhanDTO2);
        danhMucTinhTrangHonNhanDTO2.setId(2L);
        assertThat(danhMucTinhTrangHonNhanDTO1).isNotEqualTo(danhMucTinhTrangHonNhanDTO2);
        danhMucTinhTrangHonNhanDTO1.setId(null);
        assertThat(danhMucTinhTrangHonNhanDTO1).isNotEqualTo(danhMucTinhTrangHonNhanDTO2);
    }
}
