package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.DuongSuTrungCmnd;
import vn.vnpt.repository.DuongSuTrungCmndRepository;
import vn.vnpt.service.dto.DuongSuTrungCmndDTO;
import vn.vnpt.service.mapper.DuongSuTrungCmndMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.DuongSuTrungCmnd}.
 */
@Service
@Transactional
public class DuongSuTrungCmndService {

    private static final Logger log = LoggerFactory.getLogger(DuongSuTrungCmndService.class);

    private final DuongSuTrungCmndRepository duongSuTrungCmndRepository;

    private final DuongSuTrungCmndMapper duongSuTrungCmndMapper;

    public DuongSuTrungCmndService(DuongSuTrungCmndRepository duongSuTrungCmndRepository, DuongSuTrungCmndMapper duongSuTrungCmndMapper) {
        this.duongSuTrungCmndRepository = duongSuTrungCmndRepository;
        this.duongSuTrungCmndMapper = duongSuTrungCmndMapper;
    }

    /**
     * Save a duongSuTrungCmnd.
     *
     * @param duongSuTrungCmndDTO the entity to save.
     * @return the persisted entity.
     */
    public DuongSuTrungCmndDTO save(DuongSuTrungCmndDTO duongSuTrungCmndDTO) {
        log.debug("Request to save DuongSuTrungCmnd : {}", duongSuTrungCmndDTO);
        DuongSuTrungCmnd duongSuTrungCmnd = duongSuTrungCmndMapper.toEntity(duongSuTrungCmndDTO);
        duongSuTrungCmnd = duongSuTrungCmndRepository.save(duongSuTrungCmnd);
        return duongSuTrungCmndMapper.toDto(duongSuTrungCmnd);
    }

    /**
     * Update a duongSuTrungCmnd.
     *
     * @param duongSuTrungCmndDTO the entity to save.
     * @return the persisted entity.
     */
    public DuongSuTrungCmndDTO update(DuongSuTrungCmndDTO duongSuTrungCmndDTO) {
        log.debug("Request to update DuongSuTrungCmnd : {}", duongSuTrungCmndDTO);
        DuongSuTrungCmnd duongSuTrungCmnd = duongSuTrungCmndMapper.toEntity(duongSuTrungCmndDTO);
        duongSuTrungCmnd = duongSuTrungCmndRepository.save(duongSuTrungCmnd);
        return duongSuTrungCmndMapper.toDto(duongSuTrungCmnd);
    }

    /**
     * Partially update a duongSuTrungCmnd.
     *
     * @param duongSuTrungCmndDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DuongSuTrungCmndDTO> partialUpdate(DuongSuTrungCmndDTO duongSuTrungCmndDTO) {
        log.debug("Request to partially update DuongSuTrungCmnd : {}", duongSuTrungCmndDTO);

        return duongSuTrungCmndRepository
            .findById(duongSuTrungCmndDTO.getId())
            .map(existingDuongSuTrungCmnd -> {
                duongSuTrungCmndMapper.partialUpdate(existingDuongSuTrungCmnd, duongSuTrungCmndDTO);

                return existingDuongSuTrungCmnd;
            })
            .map(duongSuTrungCmndRepository::save)
            .map(duongSuTrungCmndMapper::toDto);
    }

    /**
     * Get all the duongSuTrungCmnds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DuongSuTrungCmndDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DuongSuTrungCmnds");
        return duongSuTrungCmndRepository.findAll(pageable).map(duongSuTrungCmndMapper::toDto);
    }

    /**
     * Get one duongSuTrungCmnd by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DuongSuTrungCmndDTO> findOne(Long id) {
        log.debug("Request to get DuongSuTrungCmnd : {}", id);
        return duongSuTrungCmndRepository.findById(id).map(duongSuTrungCmndMapper::toDto);
    }

    /**
     * Delete the duongSuTrungCmnd by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DuongSuTrungCmnd : {}", id);
        duongSuTrungCmndRepository.deleteById(id);
    }
}
