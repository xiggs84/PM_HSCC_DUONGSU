package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.TinhTrangDuongSu;
import vn.vnpt.service.dto.TinhTrangDuongSuDTO;

/**
 * Mapper for the entity {@link TinhTrangDuongSu} and its DTO {@link TinhTrangDuongSuDTO}.
 */
@Mapper(componentModel = "spring")
public interface TinhTrangDuongSuMapper extends EntityMapper<TinhTrangDuongSuDTO, TinhTrangDuongSu> {}
