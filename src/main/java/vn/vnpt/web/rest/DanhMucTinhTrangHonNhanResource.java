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
import vn.vnpt.repository.DanhMucTinhTrangHonNhanRepository;
import vn.vnpt.service.DanhMucTinhTrangHonNhanService;
import vn.vnpt.service.dto.DanhMucTinhTrangHonNhanDTO;
import vn.vnpt.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vnpt.domain.DanhMucTinhTrangHonNhan}.
 */
@RestController
@RequestMapping("/api/danh-muc-tinh-trang-hon-nhans")
public class DanhMucTinhTrangHonNhanResource {

    private static final Logger log = LoggerFactory.getLogger(DanhMucTinhTrangHonNhanResource.class);

    private static final String ENTITY_NAME = "duongSuDanhMucTinhTrangHonNhan";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DanhMucTinhTrangHonNhanService danhMucTinhTrangHonNhanService;

    private final DanhMucTinhTrangHonNhanRepository danhMucTinhTrangHonNhanRepository;

    public DanhMucTinhTrangHonNhanResource(
        DanhMucTinhTrangHonNhanService danhMucTinhTrangHonNhanService,
        DanhMucTinhTrangHonNhanRepository danhMucTinhTrangHonNhanRepository
    ) {
        this.danhMucTinhTrangHonNhanService = danhMucTinhTrangHonNhanService;
        this.danhMucTinhTrangHonNhanRepository = danhMucTinhTrangHonNhanRepository;
    }

    /**
     * {@code POST  /danh-muc-tinh-trang-hon-nhans} : Create a new danhMucTinhTrangHonNhan.
     *
     * @param danhMucTinhTrangHonNhanDTO the danhMucTinhTrangHonNhanDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new danhMucTinhTrangHonNhanDTO, or with status {@code 400 (Bad Request)} if the danhMucTinhTrangHonNhan has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<DanhMucTinhTrangHonNhanDTO> createDanhMucTinhTrangHonNhan(
        @RequestBody DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO
    ) throws URISyntaxException {
        log.debug("REST request to save DanhMucTinhTrangHonNhan : {}", danhMucTinhTrangHonNhanDTO);
        if (danhMucTinhTrangHonNhanDTO.getId() != null) {
            throw new BadRequestAlertException("A new danhMucTinhTrangHonNhan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanService.save(danhMucTinhTrangHonNhanDTO);
        return ResponseEntity.created(new URI("/api/danh-muc-tinh-trang-hon-nhans/" + danhMucTinhTrangHonNhanDTO.getId()))
            .headers(
                HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, danhMucTinhTrangHonNhanDTO.getId().toString())
            )
            .body(danhMucTinhTrangHonNhanDTO);
    }

    /**
     * {@code PUT  /danh-muc-tinh-trang-hon-nhans/:id} : Updates an existing danhMucTinhTrangHonNhan.
     *
     * @param id the id of the danhMucTinhTrangHonNhanDTO to save.
     * @param danhMucTinhTrangHonNhanDTO the danhMucTinhTrangHonNhanDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated danhMucTinhTrangHonNhanDTO,
     * or with status {@code 400 (Bad Request)} if the danhMucTinhTrangHonNhanDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the danhMucTinhTrangHonNhanDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DanhMucTinhTrangHonNhanDTO> updateDanhMucTinhTrangHonNhan(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DanhMucTinhTrangHonNhan : {}, {}", id, danhMucTinhTrangHonNhanDTO);
        if (danhMucTinhTrangHonNhanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, danhMucTinhTrangHonNhanDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!danhMucTinhTrangHonNhanRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanService.update(danhMucTinhTrangHonNhanDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, danhMucTinhTrangHonNhanDTO.getId().toString()))
            .body(danhMucTinhTrangHonNhanDTO);
    }

    /**
     * {@code PATCH  /danh-muc-tinh-trang-hon-nhans/:id} : Partial updates given fields of an existing danhMucTinhTrangHonNhan, field will ignore if it is null
     *
     * @param id the id of the danhMucTinhTrangHonNhanDTO to save.
     * @param danhMucTinhTrangHonNhanDTO the danhMucTinhTrangHonNhanDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated danhMucTinhTrangHonNhanDTO,
     * or with status {@code 400 (Bad Request)} if the danhMucTinhTrangHonNhanDTO is not valid,
     * or with status {@code 404 (Not Found)} if the danhMucTinhTrangHonNhanDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the danhMucTinhTrangHonNhanDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DanhMucTinhTrangHonNhanDTO> partialUpdateDanhMucTinhTrangHonNhan(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DanhMucTinhTrangHonNhan partially : {}, {}", id, danhMucTinhTrangHonNhanDTO);
        if (danhMucTinhTrangHonNhanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, danhMucTinhTrangHonNhanDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!danhMucTinhTrangHonNhanRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DanhMucTinhTrangHonNhanDTO> result = danhMucTinhTrangHonNhanService.partialUpdate(danhMucTinhTrangHonNhanDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, danhMucTinhTrangHonNhanDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /danh-muc-tinh-trang-hon-nhans} : get all the danhMucTinhTrangHonNhans.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of danhMucTinhTrangHonNhans in body.
     */
    @GetMapping("")
    public ResponseEntity<List<DanhMucTinhTrangHonNhanDTO>> getAllDanhMucTinhTrangHonNhans(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of DanhMucTinhTrangHonNhans");
        Page<DanhMucTinhTrangHonNhanDTO> page = danhMucTinhTrangHonNhanService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /danh-muc-tinh-trang-hon-nhans/:id} : get the "id" danhMucTinhTrangHonNhan.
     *
     * @param id the id of the danhMucTinhTrangHonNhanDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the danhMucTinhTrangHonNhanDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DanhMucTinhTrangHonNhanDTO> getDanhMucTinhTrangHonNhan(@PathVariable("id") Long id) {
        log.debug("REST request to get DanhMucTinhTrangHonNhan : {}", id);
        Optional<DanhMucTinhTrangHonNhanDTO> danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(danhMucTinhTrangHonNhanDTO);
    }

    /**
     * {@code DELETE  /danh-muc-tinh-trang-hon-nhans/:id} : delete the "id" danhMucTinhTrangHonNhan.
     *
     * @param id the id of the danhMucTinhTrangHonNhanDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDanhMucTinhTrangHonNhan(@PathVariable("id") Long id) {
        log.debug("REST request to delete DanhMucTinhTrangHonNhan : {}", id);
        danhMucTinhTrangHonNhanService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
