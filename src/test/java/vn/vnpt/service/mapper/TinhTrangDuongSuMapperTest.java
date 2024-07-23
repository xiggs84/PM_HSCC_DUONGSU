package vn.vnpt.service.mapper;

import static vn.vnpt.domain.TinhTrangDuongSuAsserts.*;
import static vn.vnpt.domain.TinhTrangDuongSuTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TinhTrangDuongSuMapperTest {

    private TinhTrangDuongSuMapper tinhTrangDuongSuMapper;

    @BeforeEach
    void setUp() {
        tinhTrangDuongSuMapper = new TinhTrangDuongSuMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTinhTrangDuongSuSample1();
        var actual = tinhTrangDuongSuMapper.toEntity(tinhTrangDuongSuMapper.toDto(expected));
        assertTinhTrangDuongSuAllPropertiesEquals(expected, actual);
    }
}
