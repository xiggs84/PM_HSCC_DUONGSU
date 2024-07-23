package vn.vnpt.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import vn.vnpt.web.rest.TestUtil;

class DanhMucLoaiDuongSuDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanhMucLoaiDuongSuDTO.class);
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO1 = new DanhMucLoaiDuongSuDTO();
        danhMucLoaiDuongSuDTO1.setId(1L);
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO2 = new DanhMucLoaiDuongSuDTO();
        assertThat(danhMucLoaiDuongSuDTO1).isNotEqualTo(danhMucLoaiDuongSuDTO2);
        danhMucLoaiDuongSuDTO2.setId(danhMucLoaiDuongSuDTO1.getId());
        assertThat(danhMucLoaiDuongSuDTO1).isEqualTo(danhMucLoaiDuongSuDTO2);
        danhMucLoaiDuongSuDTO2.setId(2L);
        assertThat(danhMucLoaiDuongSuDTO1).isNotEqualTo(danhMucLoaiDuongSuDTO2);
        danhMucLoaiDuongSuDTO1.setId(null);
        assertThat(danhMucLoaiDuongSuDTO1).isNotEqualTo(danhMucLoaiDuongSuDTO2);
    }
}
