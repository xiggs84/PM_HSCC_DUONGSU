package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.CauHinhThongTinDuongSu;
import vn.vnpt.repository.CauHinhThongTinDuongSuRepository;
import vn.vnpt.service.dto.CauHinhThongTinDuongSuDTO;
import vn.vnpt.service.mapper.CauHinhThongTinDuongSuMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.CauHinhThongTinDuongSu}.
 */
@Service
@Transactional
public class CauHinhThongTinDuongSuService {

    private static final Logger log = LoggerFactory.getLogger(CauHinhThongTinDuongSuService.class);

    private final CauHinhThongTinDuongSuRepository cauHinhThongTinDuongSuRepository;

    private final CauHinhThongTinDuongSuMapper cauHinhThongTinDuongSuMapper;

    public CauHinhThongTinDuongSuService(
        CauHinhThongTinDuongSuRepository cauHinhThongTinDuongSuRepository,
        CauHinhThongTinDuongSuMapper cauHinhThongTinDuongSuMapper
    ) {
        this.cauHinhThongTinDuongSuRepository = cauHinhThongTinDuongSuRepository;
        this.cauHinhThongTinDuongSuMapper = cauHinhThongTinDuongSuMapper;
    }

    /**
     * Save a cauHinhThongTinDuongSu.
     *
     * @param cauHinhThongTinDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public CauHinhThongTinDuongSuDTO save(CauHinhThongTinDuongSuDTO cauHinhThongTinDuongSuDTO) {
        log.debug("Request to save CauHinhThongTinDuongSu : {}", cauHinhThongTinDuongSuDTO);
        CauHinhThongTinDuongSu cauHinhThongTinDuongSu = cauHinhThongTinDuongSuMapper.toEntity(cauHinhThongTinDuongSuDTO);
        cauHinhThongTinDuongSu = cauHinhThongTinDuongSuRepository.save(cauHinhThongTinDuongSu);
        return cauHinhThongTinDuongSuMapper.toDto(cauHinhThongTinDuongSu);
    }

    /**
     * Update a cauHinhThongTinDuongSu.
     *
     * @param cauHinhThongTinDuongSuDTO the entity to save.
     * @return the persisted entity.
     */
    public CauHinhThongTinDuongSuDTO update(CauHinhThongTinDuongSuDTO cauHinhThongTinDuongSuDTO) {
        log.debug("Request to update CauHinhThongTinDuongSu : {}", cauHinhThongTinDuongSuDTO);
        CauHinhThongTinDuongSu cauHinhThongTinDuongSu = cauHinhThongTinDuongSuMapper.toEntity(cauHinhThongTinDuongSuDTO);
        cauHinhThongTinDuongSu = cauHinhThongTinDuongSuRepository.save(cauHinhThongTinDuongSu);
        return cauHinhThongTinDuongSuMapper.toDto(cauHinhThongTinDuongSu);
    }

    /**
     * Partially update a cauHinhThongTinDuongSu.
     *
     * @param cauHinhThongTinDuongSuDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CauHinhThongTinDuongSuDTO> partialUpdate(CauHinhThongTinDuongSuDTO cauHinhThongTinDuongSuDTO) {
        log.debug("Request to partially update CauHinhThongTinDuongSu : {}", cauHinhThongTinDuongSuDTO);

        return cauHinhThongTinDuongSuRepository
            .findById(cauHinhThongTinDuongSuDTO.getId())
            .map(existingCauHinhThongTinDuongSu -> {
                cauHinhThongTinDuongSuMapper.partialUpdate(existingCauHinhThongTinDuongSu, cauHinhThongTinDuongSuDTO);

                return existingCauHinhThongTinDuongSu;
            })
            .map(cauHinhThongTinDuongSuRepository::save)
            .map(cauHinhThongTinDuongSuMapper::toDto);
    }

    /**
     * Get all the cauHinhThongTinDuongSus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CauHinhThongTinDuongSuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CauHinhThongTinDuongSus");
        return cauHinhThongTinDuongSuRepository.findAll(pageable).map(cauHinhThongTinDuongSuMapper::toDto);
    }

    /**
     * Get one cauHinhThongTinDuongSu by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CauHinhThongTinDuongSuDTO> findOne(Long id) {
        log.debug("Request to get CauHinhThongTinDuongSu : {}", id);
        return cauHinhThongTinDuongSuRepository.findById(id).map(cauHinhThongTinDuongSuMapper::toDto);
    }

    /**
     * Delete the cauHinhThongTinDuongSu by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CauHinhThongTinDuongSu : {}", id);
        cauHinhThongTinDuongSuRepository.deleteById(id);
    }
}
