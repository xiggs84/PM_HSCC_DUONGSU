package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.DanhMucTinhTrangHonNhan;
import vn.vnpt.service.dto.DanhMucTinhTrangHonNhanDTO;

/**
 * Mapper for the entity {@link DanhMucTinhTrangHonNhan} and its DTO {@link DanhMucTinhTrangHonNhanDTO}.
 */
@Mapper(componentModel = "spring")
public interface DanhMucTinhTrangHonNhanMapper extends EntityMapper<DanhMucTinhTrangHonNhanDTO, DanhMucTinhTrangHonNhan> {}
