package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.DanhMucLoaiDuongSu;
import vn.vnpt.domain.DuongSu;
import vn.vnpt.service.dto.DanhMucLoaiDuongSuDTO;
import vn.vnpt.service.dto.DuongSuDTO;

/**
 * Mapper for the entity {@link DuongSu} and its DTO {@link DuongSuDTO}.
 */
@Mapper(componentModel = "spring")
public interface DuongSuMapper extends EntityMapper<DuongSuDTO, DuongSu> {
    @Mapping(target = "idLoaiDs", source = "idLoaiDs", qualifiedByName = "danhMucLoaiDuongSuId")
    DuongSuDTO toDto(DuongSu s);

    @Named("danhMucLoaiDuongSuId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DanhMucLoaiDuongSuDTO toDtoDanhMucLoaiDuongSuId(DanhMucLoaiDuongSu danhMucLoaiDuongSu);
}
