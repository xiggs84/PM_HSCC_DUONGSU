package vn.vnpt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.DuongSu;
import vn.vnpt.repository.DuongSuRepository;
import vn.vnpt.service.dto.DuongSuDTO;
import vn.vnpt.service.mapper.DuongSuMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.DuongSu}.
 */
@Service
@Transactional
public class DuongSuService {

    private static final Logger log = LoggerFactory.getLogger(DuongSuService.class);

    private final DuongSuRepository duongSuRepository;

    private final DuongSuMapper duongSuMapper;

    public DuongSuService(DuongSuRepository duongSuRepository, DuongSuMapper duongSuMapper) {
        this.duongSuRepository = duongSuRepository;
        this.duongSuMapper = duongSuMapper;
    }

    /**
     * Save a duongSu.
     *
     * @param duongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DuongSuDTO save(DuongSuDTO duongSuDTO) {
        log.debug("Request to save DuongSu : {}", duongSuDTO);
        DuongSu duongSu = duongSuMapper.toEntity(duongSuDTO);
        duongSu = duongSuRepository.save(duongSu);
        return duongSuMapper.toDto(duongSu);
    }

    /**
     * Update a duongSu.
     *
     * @param duongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public DuongSuDTO update(DuongSuDTO duongSuDTO) {
        log.debug("Request to update DuongSu : {}", duongSuDTO);
        DuongSu duongSu = duongSuMapper.toEntity(duongSuDTO);
        duongSu = duongSuRepository.save(duongSu);
        return duongSuMapper.toDto(duongSu);
    }

    /**
     * Partially update a duongSu.
     *
     * @param duongSuDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DuongSuDTO> partialUpdate(DuongSuDTO duongSuDTO) {
        log.debug("Request to partially update DuongSu : {}", duongSuDTO);

        return duongSuRepository
            .findById(duongSuDTO.getId())
            .map(existingDuongSu -> {
                duongSuMapper.partialUpdate(existingDuongSu, duongSuDTO);

                return existingDuongSu;
            })
            .map(duongSuRepository::save)
            .map(duongSuMapper::toDto);
    }

    /**
     * Get all the duongSus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DuongSuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DuongSus");
        return duongSuRepository.findAll(pageable).map(duongSuMapper::toDto);
    }

    /**
     * Get one duongSu by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DuongSuDTO> findOne(Long id) {
        log.debug("Request to get DuongSu : {}", id);
        return duongSuRepository.findById(id).map(duongSuMapper::toDto);
    }

    /**
     * Delete the duongSu by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DuongSu : {}", id);
        duongSuRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<DuongSuDTO> findByTenDuongSu(String tenDuongSu) {
        log.debug("Request to search DuongSus by tenDuongSu : {}", tenDuongSu);
        return duongSuRepository
            .findByTenDuongSuContainingIgnoreCase(tenDuongSu)
            .stream()
            .map(duongSuMapper::toDto)
            .collect(Collectors.toList());
    }
}
