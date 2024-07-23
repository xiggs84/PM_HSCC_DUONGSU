package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class TinhTrangDuongSuDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TinhTrangDuongSuDTO.class);
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO1 = new TinhTrangDuongSuDTO();
        tinhTrangDuongSuDTO1.setId(1L);
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO2 = new TinhTrangDuongSuDTO();
        assertThat(tinhTrangDuongSuDTO1).isNotEqualTo(tinhTrangDuongSuDTO2);
        tinhTrangDuongSuDTO2.setId(tinhTrangDuongSuDTO1.getId());
        assertThat(tinhTrangDuongSuDTO1).isEqualTo(tinhTrangDuongSuDTO2);
        tinhTrangDuongSuDTO2.setId(2L);
        assertThat(tinhTrangDuongSuDTO1).isNotEqualTo(tinhTrangDuongSuDTO2);
        tinhTrangDuongSuDTO1.setId(null);
        assertThat(tinhTrangDuongSuDTO1).isNotEqualTo(tinhTrangDuongSuDTO2);
    }
}
