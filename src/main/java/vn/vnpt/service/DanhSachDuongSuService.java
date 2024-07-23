package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.DanhSachDuongSu;
import vn.vnpt.repository.DanhSachDuongSuRepository;
import vn.vnpt.service.dto.DanhSachDuongSuDTO;
import vn.vnpt.service.mapper.DanhSachDuongSuMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.DanhSachDuongSu}.
 */
@Service
@Transactional
public class DanhSachDuongSuService {

    private static final Logger log = LoggerFactory.getLogger(DanhSachDuongSuService.class);

    private final DanhSachDuongSuRepository danhSachDuongSuRepository;

    private final DanhSachDuongSuMapper danhSachDuongSuMapper;

    public DanhSachDuongSuService(DanhSachDuongSuRepository danhSachDuongSuRepository, DanhSachDuongSuMapper danhSachDuongSuMapper) {
        this.danhSachDuongSuRepository = danhSachDuongSuRepository;
        this.danhSachDuongSuMapper = danhSachDuongSuMapper;
    }

    /**
     * Save a danhSachDuongSu.
     *
     * @param danhSachDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhSachDuongSuDTO save(DanhSachDuongSuDTO danhSachDuongSuDTO) {
        log.debug("Request to save DanhSachDuongSu : {}", danhSachDuongSuDTO);
        DanhSachDuongSu danhSachDuongSu = danhSachDuongSuMapper.toEntity(danhSachDuongSuDTO);
        danhSachDuongSu = danhSachDuongSuRepository.save(danhSachDuongSu);
        return danhSachDuongSuMapper.toDto(danhSachDuongSu);
    }

    /**
     * Update a danhSachDuongSu.
     *
     * @param danhSachDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhSachDuongSuDTO update(DanhSachDuongSuDTO danhSachDuongSuDTO) {
        log.debug("Request to update DanhSachDuongSu : {}", danhSachDuongSuDTO);
        DanhSachDuongSu danhSachDuongSu = danhSachDuongSuMapper.toEntity(danhSachDuongSuDTO);
        danhSachDuongSu = danhSachDuongSuRepository.save(danhSachDuongSu);
        return danhSachDuongSuMapper.toDto(danhSachDuongSu);
    }

    /**
     * Partially update a danhSachDuongSu.
     *
     * @param danhSachDuongSuDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DanhSachDuongSuDTO> partialUpdate(DanhSachDuongSuDTO danhSachDuongSuDTO) {
        log.debug("Request to partially update DanhSachDuongSu : {}", danhSachDuongSuDTO);

        return danhSachDuongSuRepository
            .findById(danhSachDuongSuDTO.getId())
            .map(existingDanhSachDuongSu -> {
                danhSachDuongSuMapper.partialUpdate(existingDanhSachDuongSu, danhSachDuongSuDTO);

                return existingDanhSachDuongSu;
            })
            .map(danhSachDuongSuRepository::save)
            .map(danhSachDuongSuMapper::toDto);
    }

    /**
     * Get all the danhSachDuongSus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DanhSachDuongSuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DanhSachDuongSus");
        return danhSachDuongSuRepository.findAll(pageable).map(danhSachDuongSuMapper::toDto);
    }

    /**
     * Get one danhSachDuongSu by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DanhSachDuongSuDTO> findOne(Long id) {
        log.debug("Request to get DanhSachDuongSu : {}", id);
        return danhSachDuongSuRepository.findById(id).map(danhSachDuongSuMapper::toDto);
    }

    /**
     * Delete the danhSachDuongSu by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DanhSachDuongSu : {}", id);
        danhSachDuongSuRepository.deleteById(id);
    }
}
