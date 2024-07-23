package vn.vnpt.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;
import vn.vnpt.repository.DanhMucLoaiDuongSuRepository;
import vn.vnpt.service.DanhMucLoaiDuongSuService;
import vn.vnpt.service.dto.DanhMucLoaiDuongSuDTO;
import vn.vnpt.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vnpt.domain.DanhMucLoaiDuongSu}.
 */
@RestController
@RequestMapping("/api/danh-muc-loai-duong-sus")
public class DanhMucLoaiDuongSuResource {

    private static final Logger log = LoggerFactory.getLogger(DanhMucLoaiDuongSuResource.class);

    private static final String ENTITY_NAME = "duongSuDanhMucLoaiDuongSu";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DanhMucLoaiDuongSuService danhMucLoaiDuongSuService;

    private final DanhMucLoaiDuongSuRepository danhMucLoaiDuongSuRepository;

    public DanhMucLoaiDuongSuResource(
        DanhMucLoaiDuongSuService danhMucLoaiDuongSuService,
        DanhMucLoaiDuongSuRepository danhMucLoaiDuongSuRepository
    ) {
        this.danhMucLoaiDuongSuService = danhMucLoaiDuongSuService;
        this.danhMucLoaiDuongSuRepository = danhMucLoaiDuongSuRepository;
    }

    /**
     * {@code POST  /danh-muc-loai-duong-sus} : Create a new danhMucLoaiDuongSu.
     *
     * @param danhMucLoaiDuongSuDTO the danhMucLoaiDuongSuDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new danhMucLoaiDuongSuDTO, or with status {@code 400 (Bad Request)} if the danhMucLoaiDuongSu has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<DanhMucLoaiDuongSuDTO> createDanhMucLoaiDuongSu(@RequestBody DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO)
        throws URISyntaxException {
        log.debug("REST request to save DanhMucLoaiDuongSu : {}", danhMucLoaiDuongSuDTO);
        if (danhMucLoaiDuongSuDTO.getId() != null) {
            throw new BadRequestAlertException("A new danhMucLoaiDuongSu cannot already have an ID", ENTITY_NAME, "idexists");
        }
        danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuService.save(danhMucLoaiDuongSuDTO);
        return ResponseEntity.created(new URI("/api/danh-muc-loai-duong-sus/" + danhMucLoaiDuongSuDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, danhMucLoaiDuongSuDTO.getId().toString()))
            .body(danhMucLoaiDuongSuDTO);
    }

    /**
     * {@code PUT  /danh-muc-loai-duong-sus/:id} : Updates an existing danhMucLoaiDuongSu.
     *
     * @param id the id of the danhMucLoaiDuongSuDTO to save.
     * @param danhMucLoaiDuongSuDTO the danhMucLoaiDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated danhMucLoaiDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the danhMucLoaiDuongSuDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the danhMucLoaiDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DanhMucLoaiDuongSuDTO> updateDanhMucLoaiDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DanhMucLoaiDuongSu : {}, {}", id, danhMucLoaiDuongSuDTO);
        if (danhMucLoaiDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, danhMucLoaiDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!danhMucLoaiDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuService.update(danhMucLoaiDuongSuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, danhMucLoaiDuongSuDTO.getId().toString()))
            .body(danhMucLoaiDuongSuDTO);
    }

    /**
     * {@code PATCH  /danh-muc-loai-duong-sus/:id} : Partial updates given fields of an existing danhMucLoaiDuongSu, field will ignore if it is null
     *
     * @param id the id of the danhMucLoaiDuongSuDTO to save.
     * @param danhMucLoaiDuongSuDTO the danhMucLoaiDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated danhMucLoaiDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the danhMucLoaiDuongSuDTO is not valid,
     * or with status {@code 404 (Not Found)} if the danhMucLoaiDuongSuDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the danhMucLoaiDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DanhMucLoaiDuongSuDTO> partialUpdateDanhMucLoaiDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DanhMucLoaiDuongSu partially : {}, {}", id, danhMucLoaiDuongSuDTO);
        if (danhMucLoaiDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, danhMucLoaiDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!danhMucLoaiDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DanhMucLoaiDuongSuDTO> result = danhMucLoaiDuongSuService.partialUpdate(danhMucLoaiDuongSuDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, danhMucLoaiDuongSuDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /danh-muc-loai-duong-sus} : get all the danhMucLoaiDuongSus.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of danhMucLoaiDuongSus in body.
     */
    @GetMapping("")
    public ResponseEntity<List<DanhMucLoaiDuongSuDTO>> getAllDanhMucLoaiDuongSus(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of DanhMucLoaiDuongSus");
        Page<DanhMucLoaiDuongSuDTO> page = danhMucLoaiDuongSuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /danh-muc-loai-duong-sus/:id} : get the "id" danhMucLoaiDuongSu.
     *
     * @param id the id of the danhMucLoaiDuongSuDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the danhMucLoaiDuongSuDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DanhMucLoaiDuongSuDTO> getDanhMucLoaiDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to get DanhMucLoaiDuongSu : {}", id);
        Optional<DanhMucLoaiDuongSuDTO> danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuService.findOne(id);
        return ResponseUtil.wrapOrNotFound(danhMucLoaiDuongSuDTO);
    }

    /**
     * {@code DELETE  /danh-muc-loai-duong-sus/:id} : delete the "id" danhMucLoaiDuongSu.
     *
     * @param id the id of the danhMucLoaiDuongSuDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDanhMucLoaiDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to delete DanhMucLoaiDuongSu : {}", id);
        danhMucLoaiDuongSuService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
