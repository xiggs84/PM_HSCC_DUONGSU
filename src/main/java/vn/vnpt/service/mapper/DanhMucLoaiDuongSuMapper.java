package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.DanhMucLoaiDuongSu;
import vn.vnpt.service.dto.DanhMucLoaiDuongSuDTO;

/**
 * Mapper for the entity {@link DanhMucLoaiDuongSu} and its DTO {@link DanhMucLoaiDuongSuDTO}.
 */
@Mapper(componentModel = "spring")
public interface DanhMucLoaiDuongSuMapper extends EntityMapper<DanhMucLoaiDuongSuDTO, DanhMucLoaiDuongSu> {}
