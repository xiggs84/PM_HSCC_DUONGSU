package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.DanhMucLoaiDuongSu;
import vn.vnpt.repository.DanhMucLoaiDuongSuRepository;
import vn.vnpt.service.dto.DanhMucLoaiDuongSuDTO;
import vn.vnpt.service.mapper.DanhMucLoaiDuongSuMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.DanhMucLoaiDuongSu}.
 */
@Service
@Transactional
public class DanhMucLoaiDuongSuService {

    private static final Logger log = LoggerFactory.getLogger(DanhMucLoaiDuongSuService.class);

    private final DanhMucLoaiDuongSuRepository danhMucLoaiDuongSuRepository;

    private final DanhMucLoaiDuongSuMapper danhMucLoaiDuongSuMapper;

    public DanhMucLoaiDuongSuService(
        DanhMucLoaiDuongSuRepository danhMucLoaiDuongSuRepository,
        DanhMucLoaiDuongSuMapper danhMucLoaiDuongSuMapper
    ) {
        this.danhMucLoaiDuongSuRepository = danhMucLoaiDuongSuRepository;
        this.danhMucLoaiDuongSuMapper = danhMucLoaiDuongSuMapper;
    }

    /**
     * Save a danhMucLoaiDuongSu.
     *
     * @param danhMucLoaiDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhMucLoaiDuongSuDTO save(DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO) {
        log.debug("Request to save DanhMucLoaiDuongSu : {}", danhMucLoaiDuongSuDTO);
        DanhMucLoaiDuongSu danhMucLoaiDuongSu = danhMucLoaiDuongSuMapper.toEntity(danhMucLoaiDuongSuDTO);
        danhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.save(danhMucLoaiDuongSu);
        return danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);
    }

    /**
     * Update a danhMucLoaiDuongSu.
     *
     * @param danhMucLoaiDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhMucLoaiDuongSuDTO update(DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO) {
        log.debug("Request to update DanhMucLoaiDuongSu : {}", danhMucLoaiDuongSuDTO);
        DanhMucLoaiDuongSu danhMucLoaiDuongSu = danhMucLoaiDuongSuMapper.toEntity(danhMucLoaiDuongSuDTO);
        danhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.save(danhMucLoaiDuongSu);
        return danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);
    }

    /**
     * Partially update a danhMucLoaiDuongSu.
     *
     * @param danhMucLoaiDuongSuDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DanhMucLoaiDuongSuDTO> partialUpdate(DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO) {
        log.debug("Request to partially update DanhMucLoaiDuongSu : {}", danhMucLoaiDuongSuDTO);

        return danhMucLoaiDuongSuRepository
            .findById(danhMucLoaiDuongSuDTO.getId())
            .map(existingDanhMucLoaiDuongSu -> {
                danhMucLoaiDuongSuMapper.partialUpdate(existingDanhMucLoaiDuongSu, danhMucLoaiDuongSuDTO);

                return existingDanhMucLoaiDuongSu;
            })
            .map(danhMucLoaiDuongSuRepository::save)
            .map(danhMucLoaiDuongSuMapper::toDto);
    }

    /**
     * Get all the danhMucLoaiDuongSus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DanhMucLoaiDuongSuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DanhMucLoaiDuongSus");
        return danhMucLoaiDuongSuRepository.findAll(pageable).map(danhMucLoaiDuongSuMapper::toDto);
    }

    /**
     * Get one danhMucLoaiDuongSu by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DanhMucLoaiDuongSuDTO> findOne(Long id) {
        log.debug("Request to get DanhMucLoaiDuongSu : {}", id);
        return danhMucLoaiDuongSuRepository.findById(id).map(danhMucLoaiDuongSuMapper::toDto);
    }

    /**
     * Delete the danhMucLoaiDuongSu by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DanhMucLoaiDuongSu : {}", id);
        danhMucLoaiDuongSuRepository.deleteById(id);
    }
}
