package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.QuanHeDuongSu;
import vn.vnpt.service.dto.QuanHeDuongSuDTO;

/**
 * Mapper for the entity {@link QuanHeDuongSu} and its DTO {@link QuanHeDuongSuDTO}.
 */
@Mapper(componentModel = "spring")
public interface QuanHeDuongSuMapper extends EntityMapper<QuanHeDuongSuDTO, QuanHeDuongSu> {}
