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
import vn.vnpt.repository.QuanHeDuongSuRepository;
import vn.vnpt.service.QuanHeDuongSuService;
import vn.vnpt.service.dto.QuanHeDuongSuDTO;
import vn.vnpt.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vnpt.domain.QuanHeDuongSu}.
 */
@RestController
@RequestMapping("/api/quan-he-duong-sus")
public class QuanHeDuongSuResource {

    private static final Logger log = LoggerFactory.getLogger(QuanHeDuongSuResource.class);

    private static final String ENTITY_NAME = "duongSuQuanHeDuongSu";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuanHeDuongSuService quanHeDuongSuService;

    private final QuanHeDuongSuRepository quanHeDuongSuRepository;

    public QuanHeDuongSuResource(QuanHeDuongSuService quanHeDuongSuService, QuanHeDuongSuRepository quanHeDuongSuRepository) {
        this.quanHeDuongSuService = quanHeDuongSuService;
        this.quanHeDuongSuRepository = quanHeDuongSuRepository;
    }

    /**
     * {@code POST  /quan-he-duong-sus} : Create a new quanHeDuongSu.
     *
     * @param quanHeDuongSuDTO the quanHeDuongSuDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quanHeDuongSuDTO, or with status {@code 400 (Bad Request)} if the quanHeDuongSu has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<QuanHeDuongSuDTO> createQuanHeDuongSu(@RequestBody QuanHeDuongSuDTO quanHeDuongSuDTO) throws URISyntaxException {
        log.debug("REST request to save QuanHeDuongSu : {}", quanHeDuongSuDTO);
        if (quanHeDuongSuDTO.getId() != null) {
            throw new BadRequestAlertException("A new quanHeDuongSu cannot already have an ID", ENTITY_NAME, "idexists");
        }
        quanHeDuongSuDTO = quanHeDuongSuService.save(quanHeDuongSuDTO);
        return ResponseEntity.created(new URI("/api/quan-he-duong-sus/" + quanHeDuongSuDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, quanHeDuongSuDTO.getId().toString()))
            .body(quanHeDuongSuDTO);
    }

    /**
     * {@code PUT  /quan-he-duong-sus/:id} : Updates an existing quanHeDuongSu.
     *
     * @param id the id of the quanHeDuongSuDTO to save.
     * @param quanHeDuongSuDTO the quanHeDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quanHeDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the quanHeDuongSuDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quanHeDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<QuanHeDuongSuDTO> updateQuanHeDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody QuanHeDuongSuDTO quanHeDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to update QuanHeDuongSu : {}, {}", id, quanHeDuongSuDTO);
        if (quanHeDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, quanHeDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!quanHeDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        quanHeDuongSuDTO = quanHeDuongSuService.update(quanHeDuongSuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, quanHeDuongSuDTO.getId().toString()))
            .body(quanHeDuongSuDTO);
    }

    /**
     * {@code PATCH  /quan-he-duong-sus/:id} : Partial updates given fields of an existing quanHeDuongSu, field will ignore if it is null
     *
     * @param id the id of the quanHeDuongSuDTO to save.
     * @param quanHeDuongSuDTO the quanHeDuongSuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quanHeDuongSuDTO,
     * or with status {@code 400 (Bad Request)} if the quanHeDuongSuDTO is not valid,
     * or with status {@code 404 (Not Found)} if the quanHeDuongSuDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the quanHeDuongSuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<QuanHeDuongSuDTO> partialUpdateQuanHeDuongSu(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody QuanHeDuongSuDTO quanHeDuongSuDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update QuanHeDuongSu partially : {}, {}", id, quanHeDuongSuDTO);
        if (quanHeDuongSuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, quanHeDuongSuDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!quanHeDuongSuRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<QuanHeDuongSuDTO> result = quanHeDuongSuService.partialUpdate(quanHeDuongSuDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, quanHeDuongSuDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /quan-he-duong-sus} : get all the quanHeDuongSus.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quanHeDuongSus in body.
     */
    @GetMapping("")
    public ResponseEntity<List<QuanHeDuongSuDTO>> getAllQuanHeDuongSus(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of QuanHeDuongSus");
        Page<QuanHeDuongSuDTO> page = quanHeDuongSuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quan-he-duong-sus/:id} : get the "id" quanHeDuongSu.
     *
     * @param id the id of the quanHeDuongSuDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quanHeDuongSuDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<QuanHeDuongSuDTO> getQuanHeDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to get QuanHeDuongSu : {}", id);
        Optional<QuanHeDuongSuDTO> quanHeDuongSuDTO = quanHeDuongSuService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quanHeDuongSuDTO);
    }

    /**
     * {@code DELETE  /quan-he-duong-sus/:id} : delete the "id" quanHeDuongSu.
     *
     * @param id the id of the quanHeDuongSuDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuanHeDuongSu(@PathVariable("id") Long id) {
        log.debug("REST request to delete QuanHeDuongSu : {}", id);
        quanHeDuongSuService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
