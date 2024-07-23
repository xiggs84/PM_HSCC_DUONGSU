package vn.vnpt.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.domain.DanhMucTinhTrangHonNhan;
import vn.vnpt.repository.DanhMucTinhTrangHonNhanRepository;
import vn.vnpt.service.dto.DanhMucTinhTrangHonNhanDTO;
import vn.vnpt.service.mapper.DanhMucTinhTrangHonNhanMapper;

/**
 * Service Implementation for managing {@link vn.vnpt.domain.DanhMucTinhTrangHonNhan}.
 */
@Service
@Transactional
public class DanhMucTinhTrangHonNhanService {

    private static final Logger log = LoggerFactory.getLogger(DanhMucTinhTrangHonNhanService.class);

    private final DanhMucTinhTrangHonNhanRepository danhMucTinhTrangHonNhanRepository;

    private final DanhMucTinhTrangHonNhanMapper danhMucTinhTrangHonNhanMapper;

    public DanhMucTinhTrangHonNhanService(
        DanhMucTinhTrangHonNhanRepository danhMucTinhTrangHonNhanRepository,
        DanhMucTinhTrangHonNhanMapper danhMucTinhTrangHonNhanMapper
    ) {
        this.danhMucTinhTrangHonNhanRepository = danhMucTinhTrangHonNhanRepository;
        this.danhMucTinhTrangHonNhanMapper = danhMucTinhTrangHonNhanMapper;
    }

    /**
     * Save a danhMucTinhTrangHonNhan.
     *
     * @param danhMucTinhTrangHonNhanDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhMucTinhTrangHonNhanDTO save(DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO) {
        log.debug("Request to save DanhMucTinhTrangHonNhan : {}", danhMucTinhTrangHonNhanDTO);
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanMapper.toEntity(danhMucTinhTrangHonNhanDTO);
        danhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.save(danhMucTinhTrangHonNhan);
        return danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);
    }

    /**
     * Update a danhMucTinhTrangHonNhan.
     *
     * @param danhMucTinhTrangHonNhanDTO the entity to save.
     * @return the persisted entity.
     */
    public DanhMucTinhTrangHonNhanDTO update(DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO) {
        log.debug("Request to update DanhMucTinhTrangHonNhan : {}", danhMucTinhTrangHonNhanDTO);
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanMapper.toEntity(danhMucTinhTrangHonNhanDTO);
        danhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.save(danhMucTinhTrangHonNhan);
        return danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);
    }

    /**
     * Partially update a danhMucTinhTrangHonNhan.
     *
     * @param danhMucTinhTrangHonNhanDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DanhMucTinhTrangHonNhanDTO> partialUpdate(DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO) {
        log.debug("Request to partially update DanhMucTinhTrangHonNhan : {}", danhMucTinhTrangHonNhanDTO);

        return danhMucTinhTrangHonNhanRepository
            .findById(danhMucTinhTrangHonNhanDTO.getId())
            .map(existingDanhMucTinhTrangHonNhan -> {
                danhMucTinhTrangHonNhanMapper.partialUpdate(existingDanhMucTinhTrangHonNhan, danhMucTinhTrangHonNhanDTO);

                return existingDanhMucTinhTrangHonNhan;
            })
            .map(danhMucTinhTrangHonNhanRepository::save)
            .map(danhMucTinhTrangHonNhanMapper::toDto);
    }

    /**
     * Get all the danhMucTinhTrangHonNhans.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DanhMucTinhTrangHonNhanDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DanhMucTinhTrangHonNhans");
        return danhMucTinhTrangHonNhanRepository.findAll(pageable).map(danhMucTinhTrangHonNhanMapper::toDto);
    }

    /**
     * Get one danhMucTinhTrangHonNhan by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DanhMucTinhTrangHonNhanDTO> findOne(Long id) {
        log.debug("Request to get DanhMucTinhTrangHonNhan : {}", id);
        return danhMucTinhTrangHonNhanRepository.findById(id).map(danhMucTinhTrangHonNhanMapper::toDto);
    }

    /**
     * Delete the danhMucTinhTrangHonNhan by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DanhMucTinhTrangHonNhan : {}", id);
        danhMucTinhTrangHonNhanRepository.deleteById(id);
    }
}
