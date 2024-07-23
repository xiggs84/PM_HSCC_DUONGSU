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
import vn.vnpt.repository.TinhTrangDuongSuRepository;
import vn.vnpt.service.TinhTrangDuongSuService;
import vn.vnpt.service.dto.TinhTrangDuongSuDTO;
import vn.vnpt.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vnpt.domain.TinhTrangDuongSu}.
 */
@RestController
@RequestMapping("/api/tinh-trang-duong-sus")
public class TinhTrangDuongSuResource {

    private static final Logger log = LoggerFactory.getLogger(TinhTrangDuongSuResource.class);

    private static final String ENTITY_NAME = "duongSuTinhTrangDuongSu";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TinhTrangDuongSuService tinhTrangDuongSuService;

    private final TinhTrangDuongSuRepository tinhTrangDuongSuRepository;

    public TinhTrangDuongSuResource(
        TinhTrangDuongSuService tinhTrangDuongSuService,
        TinhTrangDuongSuRepository tinhTrangDuongSuRepository
    ) {
        this.tinhTrangDuongSuService = tinhTrangDuongSuService;
        this.tinhTrangDuongSuRepository = tinhTrangDuongSuRepository;
    }

    /**
     * {@code POST  /tinh-trang-duong-sus} : Create a new tinhTrangDuongSu.
     *
     * @param tinhTrangDuongSuDTO the tinhTrangDuongSuDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tinhTrangDuongSuDTO, or with status {@code 400 (Bad Request)} if the tinhTrangDuongSu has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TinhTrangDuongSuDTO> createTinhTrangDuongSu(@RequestBody TinhTrangDuongSuDTO tinhTrangDuongSuDTO)
        throws URISyntaxException {
        log.debug("REST request to save TinhTrangDuongSu : {}", tinhTrangDuongSuDTO);
        if (tinhTrangDuongSuDTO.getId() != null) {
            throw new BadRequestAlertException("A new tinhTrangDuongSu cannot already have an ID", ENTITY_NAME, "idexists");
        }
        tinhTrangDuongSuDTO = tinhTrangDuongSuService.save(tinhTrangDuongSuDTO);
        return ResponseEntity.created(new URI("/api/tinh-trang-duong-sus/" + tinhTrangDuongSuDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, tinhTrangDuongSuDTO.getId().toString()))
            .body(tinhTrangDuongSuDTO);
    }

    /**
     * {@code PUT  /tinh-trang-duong-sus/:id} : Updates an existing tinhTrangDuongSu.
     *
     * @param id the id of the tinhTrangDuongSuDTO to save.
     * @param tinhTrangDuongSuDTO the tinhTrangDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tinhTrangDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the tinhTrangDuongSuDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tinhTrangDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TinhTrangDuongSuDTO> updateTinhTrangDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TinhTrangDuongSuDTO tinhTrangDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TinhTrangDuongSu : {}, {}", id, tinhTrangDuongSuDTO);
        if (tinhTrangDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tinhTrangDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tinhTrangDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        tinhTrangDuongSuDTO = tinhTrangDuongSuService.update(tinhTrangDuongSuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tinhTrangDuongSuDTO.getId().toString()))
            .body(tinhTrangDuongSuDTO);
    }

    /**
     * {@code PATCH  /tinh-trang-duong-sus/:id} : Partial updates given fields of an existing tinhTrangDuongSu, field will ignore if it is null
     *
     * @param id the id of the tinhTrangDuongSuDTO to save.
     * @param tinhTrangDuongSuDTO the tinhTrangDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tinhTrangDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the tinhTrangDuongSuDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tinhTrangDuongSuDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tinhTrangDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<TinhTrangDuongSuDTO> partialUpdateTinhTrangDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TinhTrangDuongSuDTO tinhTrangDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TinhTrangDuongSu partially : {}, {}", id, tinhTrangDuongSuDTO);
        if (tinhTrangDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tinhTrangDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tinhTrangDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TinhTrangDuongSuDTO> result = tinhTrangDuongSuService.partialUpdate(tinhTrangDuongSuDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tinhTrangDuongSuDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tinh-trang-duong-sus} : get all the tinhTrangDuongSus.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tinhTrangDuongSus in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TinhTrangDuongSuDTO>> getAllTinhTrangDuongSus(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of TinhTrangDuongSus");
        Page<TinhTrangDuongSuDTO> page = tinhTrangDuongSuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tinh-trang-duong-sus/:id} : get the "id" tinhTrangDuongSu.
     *
     * @param id the id of the tinhTrangDuongSuDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tinhTrangDuongSuDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TinhTrangDuongSuDTO> getTinhTrangDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to get TinhTrangDuongSu : {}", id);
        Optional<TinhTrangDuongSuDTO> tinhTrangDuongSuDTO = tinhTrangDuongSuService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tinhTrangDuongSuDTO);
    }

    /**
     * {@code DELETE  /tinh-trang-duong-sus/:id} : delete the "id" tinhTrangDuongSu.
     *
     * @param id the id of the tinhTrangDuongSuDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTinhTrangDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to delete TinhTrangDuongSu : {}", id);
        tinhTrangDuongSuService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
