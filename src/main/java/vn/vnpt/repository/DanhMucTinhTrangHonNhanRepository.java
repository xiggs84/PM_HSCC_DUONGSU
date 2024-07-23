package vn.vnpt.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import vn.vnpt.domain.DanhMucTinhTrangHonNhan;

/**
 * Spring Data JPA repository for the DanhMucTinhTrangHonNhan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DanhMucTinhTrangHonNhanRepository extends JpaRepository<DanhMucTinhTrangHonNhan, Long> {}
