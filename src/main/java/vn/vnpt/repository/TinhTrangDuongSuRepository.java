package vn.vnpt.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import vn.vnpt.domain.TinhTrangDuongSu;

/**
 * Spring Data JPA repository for the TinhTrangDuongSu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TinhTrangDuongSuRepository extends JpaRepository<TinhTrangDuongSu, Long> {}
