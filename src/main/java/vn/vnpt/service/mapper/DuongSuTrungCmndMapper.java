package vn.vnpt.service.mapper;

import org.mapstruct.*;
import vn.vnpt.domain.DuongSuTrungCmnd;
import vn.vnpt.service.dto.DuongSuTrungCmndDTO;

/**
 * Mapper for the entity {@link DuongSuTrungCmnd} and its DTO {@link DuongSuTrungCmndDTO}.
 */
@Mapper(componentModel = "spring")
public interface DuongSuTrungCmndMapper extends EntityMapper<DuongSuTrungCmndDTO, DuongSuTrungCmnd> {}
