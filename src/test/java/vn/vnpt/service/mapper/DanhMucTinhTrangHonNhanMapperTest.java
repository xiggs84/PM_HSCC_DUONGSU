package vn.vnpt.service.mapper;

import static vn.vnpt.domain.DanhMucTinhTrangHonNhanAsserts.*;
import static vn.vnpt.domain.DanhMucTinhTrangHonNhanTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DanhMucTinhTrangHonNhanMapperTest {

    private DanhMucTinhTrangHonNhanMapper danhMucTinhTrangHonNhanMapper;

    @BeforeEach
    void setUp() {
        danhMucTinhTrangHonNhanMapper = new DanhMucTinhTrangHonNhanMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getDanhMucTinhTrangHonNhanSample1();
        var actual = danhMucTinhTrangHonNhanMapper.toEntity(danhMucTinhTrangHonNhanMapper.toDto(expected));
        assertDanhMucTinhTrangHonNhanAllPropertiesEquals(expected, actual);
    }
}
