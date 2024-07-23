package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.QuanHeNhanThan;
import vn.vnpt.repository.QuanHeNhanThanRepository;
import vn.vnpt.service.dto.QuanHeNhanThanDTO;
import vn.vnpt.service.mapper.QuanHeNhanThanMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.QuanHeNhanThan}.
 */
@Service
@Transactional
public class QuanHeNhanThanService {

    private static final Logger log = LoggerFactory.getLogger(QuanHeNhanThanService.class);

    private final QuanHeNhanThanRepository quanHeNhanThanRepository;

    private final QuanHeNhanThanMapper quanHeNhanThanMapper;

    public QuanHeNhanThanService(QuanHeNhanThanRepository quanHeNhanThanRepository, QuanHeNhanThanMapper quanHeNhanThanMapper) {
        this.quanHeNhanThanRepository = quanHeNhanThanRepository;
        this.quanHeNhanThanMapper = quanHeNhanThanMapper;
    }

    /**
     * Save a quanHeNhanThan.
     *
     * @param quanHeNhanThanDTO the entity to save.
     * @return the persisted entity.
     */
    public QuanHeNhanThanDTO save(QuanHeNhanThanDTO quanHeNhanThanDTO) {
        log.debug("Request to save QuanHeNhanThan : {}", quanHeNhanThanDTO);
        QuanHeNhanThan quanHeNhanThan = quanHeNhanThanMapper.toEntity(quanHeNhanThanDTO);
        quanHeNhanThan = quanHeNhanThanRepository.save(quanHeNhanThan);
        return quanHeNhanThanMapper.toDto(quanHeNhanThan);
    }

    /**
     * Update a quanHeNhanThan.
     *
     * @param quanHeNhanThanDTO the entity to save.
     * @return the persisted entity.
     */
    public QuanHeNhanThanDTO update(QuanHeNhanThanDTO quanHeNhanThanDTO) {
        log.debug("Request to update QuanHeNhanThan : {}", quanHeNhanThanDTO);
        QuanHeNhanThan quanHeNhanThan = quanHeNhanThanMapper.toEntity(quanHeNhanThanDTO);
        quanHeNhanThan = quanHeNhanThanRepository.save(quanHeNhanThan);
        return quanHeNhanThanMapper.toDto(quanHeNhanThan);
    }

    /**
     * Partially update a quanHeNhanThan.
     *
     * @param quanHeNhanThanDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<QuanHeNhanThanDTO> partialUpdate(QuanHeNhanThanDTO quanHeNhanThanDTO) {
        log.debug("Request to partially update QuanHeNhanThan : {}", quanHeNhanThanDTO);

        return quanHeNhanThanRepository
            .findById(quanHeNhanThanDTO.getId())
            .map(existingQuanHeNhanThan -> {
                quanHeNhanThanMapper.partialUpdate(existingQuanHeNhanThan, quanHeNhanThanDTO);

                return existingQuanHeNhanThan;
            })
            .map(quanHeNhanThanRepository::save)
            .map(quanHeNhanThanMapper::toDto);
    }

    /**
     * Get all the quanHeNhanThans.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<QuanHeNhanThanDTO> findAll(Pageable pageable) {
        log.debug("Request to get all QuanHeNhanThans");
        return quanHeNhanThanRepository.findAll(pageable).map(quanHeNhanThanMapper::toDto);
    }

    /**
     * Get one quanHeNhanThan by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<QuanHeNhanThanDTO> findOne(Long id) {
        log.debug("Request to get QuanHeNhanThan : {}", id);
        return quanHeNhanThanRepository.findById(id).map(quanHeNhanThanMapper::toDto);
    }

    /**
     * Delete the quanHeNhanThan by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete QuanHeNhanThan : {}", id);
        quanHeNhanThanRepository.deleteById(id);
    }
}
