package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.DanhSachDuongSu;
import vn.vnpt.service.dto.DanhSachDuongSuDTO;

/**
 * Mapper for the entity {@link DanhSachDuongSu} and its DTO {@link DanhSachDuongSuDTO}.
 */
@Mapper(componentModel = "spring")
public interface DanhSachDuongSuMapper extends EntityMapper<DanhSachDuongSuDTO, DanhSachDuongSu> {}
