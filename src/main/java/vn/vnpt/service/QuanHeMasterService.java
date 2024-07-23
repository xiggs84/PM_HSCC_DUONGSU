package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.QuanHeMaster;
import vn.vnpt.repository.QuanHeMasterRepository;
import vn.vnpt.service.dto.QuanHeMasterDTO;
import vn.vnpt.service.mapper.QuanHeMasterMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.QuanHeMaster}.
 */
@Service
@Transactional
public class QuanHeMasterService {

    private static final Logger log = LoggerFactory.getLogger(QuanHeMasterService.class);

    private final QuanHeMasterRepository quanHeMasterRepository;

    private final QuanHeMasterMapper quanHeMasterMapper;

    public QuanHeMasterService(QuanHeMasterRepository quanHeMasterRepository, QuanHeMasterMapper quanHeMasterMapper) {
        this.quanHeMasterRepository = quanHeMasterRepository;
        this.quanHeMasterMapper = quanHeMasterMapper;
    }

    /**
     * Save a quanHeMaster.
     *
     * @param quanHeMasterDTO the entity to save.
     * @return the persisted entity.
     */
    public QuanHeMasterDTO save(QuanHeMasterDTO quanHeMasterDTO) {
        log.debug("Request to save QuanHeMaster : {}", quanHeMasterDTO);
        QuanHeMaster quanHeMaster = quanHeMasterMapper.toEntity(quanHeMasterDTO);
        quanHeMaster = quanHeMasterRepository.save(quanHeMaster);
        return quanHeMasterMapper.toDto(quanHeMaster);
    }

    /**
     * Update a quanHeMaster.
     *
     * @param quanHeMasterDTO the entity to save.
     * @return the persisted entity.
     */
    public QuanHeMasterDTO update(QuanHeMasterDTO quanHeMasterDTO) {
        log.debug("Request to update QuanHeMaster : {}", quanHeMasterDTO);
        QuanHeMaster quanHeMaster = quanHeMasterMapper.toEntity(quanHeMasterDTO);
        quanHeMaster = quanHeMasterRepository.save(quanHeMaster);
        return quanHeMasterMapper.toDto(quanHeMaster);
    }

    /**
     * Partially update a quanHeMaster.
     *
     * @param quanHeMasterDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<QuanHeMasterDTO> partialUpdate(QuanHeMasterDTO quanHeMasterDTO) {
        log.debug("Request to partially update QuanHeMaster : {}", quanHeMasterDTO);

        return quanHeMasterRepository
            .findById(quanHeMasterDTO.getId())
            .map(existingQuanHeMaster -> {
                quanHeMasterMapper.partialUpdate(existingQuanHeMaster, quanHeMasterDTO);

                return existingQuanHeMaster;
            })
            .map(quanHeMasterRepository::save)
            .map(quanHeMasterMapper::toDto);
    }

    /**
     * Get all the quanHeMasters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuanHeMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuanHeMasters");
        return quanHeMasterRepository.findAll(pageable).map(quanHeMasterMapper::toDto);
    }

    /**
     * Get one quanHeMaster by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuanHeMasterDTO> findOne(Long id) {
        log.debug("Request to get QuanHeMaster : {}", id);
        return quanHeMasterRepository.findById(id).map(quanHeMasterMapper::toDto);
    }

    /**
     * Delete the quanHeMaster by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuanHeMaster : {}", id);
        quanHeMasterRepository.deleteById(id);
    }
}
