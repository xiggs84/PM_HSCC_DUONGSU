package vn.vnpt.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import vn.vnpt.domain.DanhMucLoaiDuongSu;

/**
 * Spring Data JPA repository for the DanhMucLoaiDuongSu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DanhMucLoaiDuongSuRepository extends JpaRepository<DanhMucLoaiDuongSu, Long> {}
