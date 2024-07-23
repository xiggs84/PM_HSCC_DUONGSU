package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.TinhTrangDuongSu;
import vn.vnpt.repository.TinhTrangDuongSuRepository;
import vn.vnpt.service.dto.TinhTrangDuongSuDTO;
import vn.vnpt.service.mapper.TinhTrangDuongSuMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.TinhTrangDuongSu}.
 */
@Service
@Transactional
public class TinhTrangDuongSuService {

    private static final Logger log = LoggerFactory.getLogger(TinhTrangDuongSuService.class);

    private final TinhTrangDuongSuRepository tinhTrangDuongSuRepository;

    private final TinhTrangDuongSuMapper tinhTrangDuongSuMapper;

    public TinhTrangDuongSuService(TinhTrangDuongSuRepository tinhTrangDuongSuRepository, TinhTrangDuongSuMapper tinhTrangDuongSuMapper) {
        this.tinhTrangDuongSuRepository = tinhTrangDuongSuRepository;
        this.tinhTrangDuongSuMapper = tinhTrangDuongSuMapper;
    }

    /**
     * Save a tinhTrangDuongSu.
     *
     * @param tinhTrangDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public TinhTrangDuongSuDTO save(TinhTrangDuongSuDTO tinhTrangDuongSuDTO) {
        log.debug("Request to save TinhTrangDuongSu : {}", tinhTrangDuongSuDTO);
        TinhTrangDuongSu tinhTrangDuongSu = tinhTrangDuongSuMapper.toEntity(tinhTrangDuongSuDTO);
        tinhTrangDuongSu = tinhTrangDuongSuRepository.save(tinhTrangDuongSu);
        return tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);
    }

    /**
     * Update a tinhTrangDuongSu.
     *
     * @param tinhTrangDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public TinhTrangDuongSuDTO update(TinhTrangDuongSuDTO tinhTrangDuongSuDTO) {
        log.debug("Request to update TinhTrangDuongSu : {}", tinhTrangDuongSuDTO);
        TinhTrangDuongSu tinhTrangDuongSu = tinhTrangDuongSuMapper.toEntity(tinhTrangDuongSuDTO);
        tinhTrangDuongSu = tinhTrangDuongSuRepository.save(tinhTrangDuongSu);
        return tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);
    }

    /**
     * Partially update a tinhTrangDuongSu.
     *
     * @param tinhTrangDuongSuDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<TinhTrangDuongSuDTO> partialUpdate(TinhTrangDuongSuDTO tinhTrangDuongSuDTO) {
        log.debug("Request to partially update TinhTrangDuongSu : {}", tinhTrangDuongSuDTO);

        return tinhTrangDuongSuRepository
            .findById(tinhTrangDuongSuDTO.getId())
            .map(existingTinhTrangDuongSu -> {
                tinhTrangDuongSuMapper.partialUpdate(existingTinhTrangDuongSu, tinhTrangDuongSuDTO);

                return existingTinhTrangDuongSu;
            })
            .map(tinhTrangDuongSuRepository::save)
            .map(tinhTrangDuongSuMapper::toDto);
    }

    /**
     * Get all the tinhTrangDuongSus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TinhTrangDuongSuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TinhTrangDuongSus");
        return tinhTrangDuongSuRepository.findAll(pageable).map(tinhTrangDuongSuMapper::toDto);
    }

    /**
     * Get one tinhTrangDuongSu by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TinhTrangDuongSuDTO> findOne(Long id) {
        log.debug("Request to get TinhTrangDuongSu : {}", id);
        return tinhTrangDuongSuRepository.findById(id).map(tinhTrangDuongSuMapper::toDto);
    }

    /**
     * Delete the tinhTrangDuongSu by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TinhTrangDuongSu : {}", id);
        tinhTrangDuongSuRepository.deleteById(id);
    }
}
