package vn.vnpt.service.mapper;

import static vn.vnpt.domain.DanhMucLoaiDuongSuAsserts.*;
import static vn.vnpt.domain.DanhMucLoaiDuongSuTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DanhMucLoaiDuongSuMapperTest {

    private DanhMucLoaiDuongSuMapper danhMucLoaiDuongSuMapper;

    @BeforeEach
    void setUp() {
        danhMucLoaiDuongSuMapper = new DanhMucLoaiDuongSuMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getDanhMucLoaiDuongSuSample1();
        var actual = danhMucLoaiDuongSuMapper.toEntity(danhMucLoaiDuongSuMapper.toDto(expected));
        assertDanhMucLoaiDuongSuAllPropertiesEquals(expected, actual);
    }
}
