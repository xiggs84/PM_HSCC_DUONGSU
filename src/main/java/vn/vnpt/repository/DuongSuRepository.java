package vn.vnpt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import vn.vnpt.domain.DuongSu;

/**
 * Spring Data JPA repository for the DuongSu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DuongSuRepository extends JpaRepository<DuongSu, Long> {
    List<DuongSu> findByTenDuongSuContainingIgnoreCase(String tenDuongSu);
}
